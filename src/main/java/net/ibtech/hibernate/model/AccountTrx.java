package net.ibtech.hibernate.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

	@Entity
	@Table(name = "account_trx")
	public class AccountTrx {
	    @Id
	    private int id;
	    public AccountTrx() {
			super();
		}
		@ManyToOne
	    @JoinColumn(name = "account_id", referencedColumnName = "id")
	    private Account account;
	    private BigDecimal amount;
	    @Column(name = "last_transaction")
	    private Timestamp lastTransaction;
	    private String type;
		public AccountTrx(int id, Account account, BigDecimal amount, Timestamp lastTransaction, String type) {
			super();
			this.id = id;
			this.account = account;
			this.amount = amount;
			this.lastTransaction = lastTransaction;
			this.type = type;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public Timestamp getLastTransaction() {
			return lastTransaction;
		}
		public void setLastTransaction(Timestamp lastTransaction) {
			this.lastTransaction = lastTransaction;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	    
	    // constructors, getters, setters, toString, etc.
	}


