package net.ibtech.hibernate.model;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "account")
public class Account {
    @Id
    private int id;
    private String iban;
    private BigDecimal balance;
    @Column(name = "last_transaction")
    private Timestamp lastTransaction;
    @OneToMany(mappedBy = "account")
    private List<XBatch> batchDataList;
    @OneToMany(mappedBy = "account")
    private List<AccountTrx> accountTrxList;
	
    public Account(int id, String iban, BigDecimal balance, Timestamp lastTransaction, List<XBatch> batchDataList,
			List<AccountTrx> accountTrxList) {
		super();
		this.id = id;
		this.iban = iban;
		this.balance = balance;
		this.lastTransaction = lastTransaction;
		this.batchDataList = batchDataList;
		this.accountTrxList = accountTrxList;
	}

	public Account() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Timestamp getLastTransaction() {
		return lastTransaction;
	}

	public void setLastTransaction(Timestamp lastTransaction) {
		this.lastTransaction = lastTransaction;
	}

	public List<XBatch> getBatchDataList() {
		return batchDataList;
	}

	public void setBatchDataList(List<XBatch> batchDataList) {
		this.batchDataList = batchDataList;
	}

	public List<AccountTrx> getAccountTrxList() {
		return accountTrxList;
	}

	public void setAccountTrxList(List<AccountTrx> accountTrxList) {
		this.accountTrxList = accountTrxList;
	}
    
    
    
    // constructors, getters, setters, toString, etc.
}