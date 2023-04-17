package net.ibtech.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.ibtech.hibernate.model.AccountTrx;
import net.ibtech.hibernate.util.HibernateUtil;

public class AccountTrxDao {
	 private Session session;
	    
	    public AccountTrxDao(Session session) {
	        this.session = session;
	    }
	 public AccountTrxDao() {
			// TODO Auto-generated constructor stub
		}
	
	 public void saveAccountTrx(AccountTrx accountTrx) {
		    Transaction transaction = null;
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        transaction = session.beginTransaction();
		        session.save(accountTrx);
		        transaction.commit();
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback();
		        }
		        e.printStackTrace();
		        // Daha ayrıntılı hata işleme yapılabilir
		    }
		}



public void updateAccountTrx(AccountTrx account) {
  Transaction transaction = null;
  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();

      session.update(account);

      transaction.commit();
  } catch (Exception e) {
      if (transaction != null) {
          transaction.rollback();
      }
      e.printStackTrace();
      // Daha ayrıntılı hata işleme yapılabilir
  }
}

public void deleteAccountTrx(int id) {
  Transaction transaction = null;
  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();

      AccountTrx account = session.get(AccountTrx.class, id);
      if (account != null) {
          session.delete(account);
      }

      transaction.commit();
  } catch (Exception e) {
      if (transaction != null) {
          transaction.rollback();
      }
      e.printStackTrace();
      // Daha ayrıntılı hata işleme yapılabilir
  }
}

public AccountTrx getAccountTrxById(int id) {
  try (Session session = HibernateUtil.getSessionFactory().openSession()) {

	  AccountTrx account = session.get(AccountTrx.class, id);

      return account;
  } catch (Exception e) {
      e.printStackTrace();
      // Daha ayrıntılı hata işleme yapılabilir
      return null;
  }
}

public List<AccountTrx> getAllAccountTrxs() {
  try (Session session = HibernateUtil.getSessionFactory().openSession()) {

      List<AccountTrx> accounts = session.createQuery("from AccountTrx", AccountTrx.class).list();

      return accounts;
  } catch (Exception e) {
      e.printStackTrace();
      // Daha ayrıntılı hata işleme yapılabilir
      return null;
  }
}
}
