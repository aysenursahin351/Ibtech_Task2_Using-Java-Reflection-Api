package net.ibtech.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "batch_data")
public class XBatch {
    @Id
    private int siraNo;
    private String status;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
    private BigDecimal amount;
    @Column(name = "transaction_type")
    private String transactionType;

    public XBatch(int siraNo, String status, Account account, BigDecimal amount, String transactionType) {
        this.siraNo = siraNo;
        this.status = status;
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public XBatch() {
    }

    public int getSiraNo() {
        return siraNo;
    }

    public void setSiraNo(int siraNo) {
        this.siraNo = siraNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
