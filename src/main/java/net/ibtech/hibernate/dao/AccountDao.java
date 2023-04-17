package net.ibtech.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import net.ibtech.hibernate.model.*;
import net.ibtech.hibernate.util.HibernateUtil;


public class AccountDao {
	 private Session session;
	    
	    public AccountDao(Session session) {
	        this.session = session;
	    }
	 public AccountDao() {
			// TODO Auto-generated constructor stub
		}
	
	
	 public void saveAccount(Account account) {
		    Transaction transaction = null;
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        transaction = session.beginTransaction();
		        session.save(account);
		        transaction.commit();
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback();
		        }
		        e.printStackTrace();
		        // Daha ayrıntılı hata işleme yapılabilir
		    }
		}


 public void updateAccount(Account account) {
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

 public void deleteAccount(int id) {
     Transaction transaction = null;
     try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         Account account = session.get(Account.class, id);
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

 public Account getAccountById(int id) {
     try (Session session = HibernateUtil.getSessionFactory().openSession()) {

         Account account = session.get(Account.class, id);

         return account;
     } catch (Exception e) {
         e.printStackTrace();
         // Daha ayrıntılı hata işleme yapılabilir
         return null;
     }
 }

 public List<Account> getAllAccounts() {
     try (Session session = HibernateUtil.getSessionFactory().openSession()) {

         List<Account> accounts = session.createQuery("from Account", Account.class).list();

         return accounts;
     } catch (Exception e) {
         e.printStackTrace();
         // Daha ayrıntılı hata işleme yapılabilir
         return null;
     }
 }
 public List<XBatch> getBatchesInRange(int startIndex, int endIndex) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        List<XBatch> batches = session.createQuery("from XBatch where id between :startIndex and :endIndex", XBatch.class)
	                .setParameter("startIndex", startIndex)
	                .setParameter("endIndex", endIndex)
	                .list();

	        return batches;
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Daha ayrıntılı hata işleme yapılabilir
	        return null;
	    }
	}
 public void flush() {
	    try {
	        session.flush();
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Daha ayrıntılı hata işleme yapılabilir
	    }
	}

	public void updateBatches(List<XBatch> batchList) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        for (XBatch batch : batchList) {
	            session.update(batch);
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
 
}
