package net.ibtech.hibernate.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import net.ibtech.hibernate.model.Account;
import net.ibtech.hibernate.model.XBatch;
import net.ibtech.hibernate.util.HibernateUtil;

public class XBatchDao {
	 private Session session;

	public XBatchDao(Session session) {
	        this.session = session;
	    }
	 public XBatchDao() {
			// TODO Auto-generated constructor stub
		}
	
	 public void saveXBatch(XBatch xbatch) {
		    Transaction transaction = null;
		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        transaction = session.beginTransaction();

		        session.save(xbatch);

		        transaction.commit();
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback();
		        }
		        e.printStackTrace();
		        // Daha ayrıntılı hata işleme yapılabilir
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


public void updateBatch(XBatch batch) {
  Transaction transaction = null;
  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();

      session.update(batch);

      transaction.commit();
  } catch (Exception e) {
      if (transaction != null) {
          transaction.rollback();
      }
      e.printStackTrace();
      // Daha ayrıntılı hata işleme yapılabilir
  }
}

public void deleteXBatchDao(int id) {
  Transaction transaction = null;
  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();

      XBatch xbatch = session.get(XBatch.class, id);
      if (xbatch != null) {
          session.delete(xbatch);
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

public XBatch getXBatchById(int id) {
  try (Session session = HibernateUtil.getSessionFactory().openSession()) {

	  XBatch xbatch = session.get(XBatch.class, id);

      return xbatch;
  } catch (Exception e) {
      e.printStackTrace();
      // Daha ayrıntılı hata işleme yapılabilir
      return null;
  }
}

public List<XBatch> getAllXBatchs() {
  try (Session session = HibernateUtil.getSessionFactory().openSession()) {

      List<XBatch> xbatchs = session.createQuery("from XBatch", XBatch.class).list();

      return xbatchs;
  } catch (Exception e) {
      e.printStackTrace();
      // Daha ayrıntılı hata işleme yapılabilir
      return null;
  }
}
public List<XBatch> getXBatchesWithStatus(String i) {
	  try (Session session = HibernateUtil.getSessionFactory().openSession()) {

	      List<XBatch> xbatchs = session.createQuery("from XBatch", XBatch.class).list();
	      ArrayList<XBatch> filteredList = new ArrayList<>();

	      for (int j = 0; j < xbatchs.size(); j++) {
	    	    filteredList = xbatchs.stream()
	    	                         .filter(x -> x.getStatus().equalsIgnoreCase(i))
	    	                         .collect(Collectors.toCollection(ArrayList::new));
	    	}
	      
	      return  filteredList;
	  } catch (Exception e) {
	      e.printStackTrace();
	      // Daha ayrıntılı hata işleme yapılabilir
	      return null;
	  }
	}


}
