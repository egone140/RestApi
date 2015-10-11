package code.challenge.velocity.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import code.challenge.velocity.model.CustomerRecord;
import code.challenge.velocity.utils.HibernateUtil;

/**
 * Class to handle communication the database
 * 
 * @author aaron
 */
public class CustomerRecordDao {
	
	/**
	 * This method add a CustomerRecord to the database
	 * 
	 * @param customerRecord
	 * @return customerRecord
	 */
	public CustomerRecord addCustomerRecord(CustomerRecord customerRecord) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(customerRecord);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return customerRecord;
    }


	/**
	 * This method retrieves all CustomerRecords
	 * 
	 * @return customerRecords
	 */
    @SuppressWarnings("unchecked")
	public List<CustomerRecord> getAllCustomerRecords() {
        List<CustomerRecord> customerRecords = new ArrayList<CustomerRecord>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            customerRecords = session.createQuery("from CustomerRecord").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return customerRecords;
    }
}
