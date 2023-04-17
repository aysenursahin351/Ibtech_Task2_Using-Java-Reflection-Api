package net.ibtech.hibernate.operation;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import net.ibtech.hibernate.dao.AccountDao;
import net.ibtech.hibernate.dao.XBatchDao;
import net.ibtech.hibernate.model.Account;
import net.ibtech.hibernate.model.XBatch;

public class Operation implements Runnable {

    private final AccountDao accountDao;
    private final XBatchDao batchDao;
    private final CountDownLatch latch;
    private List<XBatch> batches;
    private final int commitCount;

    public Operation(AccountDao accountDao, XBatchDao batchDao, List<XBatch> batches, int commitCount, CountDownLatch latch) {
        this.accountDao = accountDao;
        this.batchDao = batchDao;
        this.latch = latch;
        this.batches = batches;
        this.commitCount = commitCount;
    }

    @Override
    public void run() {
        try {
        	batches=batchDao.getAllXBatchs();
            for (XBatch batch : batches) {
                synchronized (batch) {
                    if (batch.getStatus().equals("0")) {
                        Account account = batch.getAccount();
                        BigDecimal amount = batch.getAmount();
                        String transactionType = batch.getTransactionType();

                        if (transactionType.equals("A")) {
                            account.setBalance(account.getBalance().add(amount));
                        } else if (transactionType.equals("B")) {
                            account.setBalance(account.getBalance().subtract(amount));
                        }

                        batch.setStatus("1");
                        batchDao.updateBatch(batch);

                        if (commitCount > 0 && batch.getSiraNo() % commitCount == 0) {
                           // batchDao.flush();
                            ///accountDao.flush();
                        }
                    }
                }
            }
        } finally {
            latch.countDown();
        }
    }
}
