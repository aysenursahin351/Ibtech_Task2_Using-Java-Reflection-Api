package net.ibtech.hibernate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import net.ibtech.hibernate.dao.AccountDao;
import net.ibtech.hibernate.dao.AccountTrxDao;
import net.ibtech.hibernate.dao.XBatchDao;
import net.ibtech.hibernate.model.Account;
import net.ibtech.hibernate.model.AccountTrx;
import net.ibtech.hibernate.model.XBatch;
import net.ibtech.hibernate.operation.Operation;
import net.ibtech.hibernate.util.HibernateUtil;



public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        AccountDao accountDao = new AccountDao();
        XBatchDao batchDao = new XBatchDao();
        List<XBatch> batches = new ArrayList<>(); // batches listesine uygun veriler eklenmeli
        int commitCount = 10; // veya başka bir değer
        CountDownLatch latch = new CountDownLatch(1); // 1 yerine başka bir sayı da olabilir

        Operation operation = new Operation(accountDao, batchDao, batches, commitCount, latch);
        operation.run();

        
        
        try {
            tx = session.beginTransaction();

            
            
          
         tx.commit();}
         catch (Exception e) {
        	    // Exception handling code
        	} finally {
        	    // Code that should always be executed
        	}}}