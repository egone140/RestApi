package code.challenge.velocity.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import code.challenge.velocity.model.CustomerRecord;
import code.challenge.velocity.utils.HibernateUtil;


public class CustomerRecordDao {
	
	public void addCustomerRecord(CustomerRecord customerRecord) {
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
    }



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

    public CustomerRecord getCustomerRecordsById(int userId) {
    	CustomerRecord customerRecord = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            customerRecord = session.get(CustomerRecord.class, userId);
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return customerRecord;
    }
	
//	/**
//	 * 
//	 * @return CustomerRecords
//	 */
//	public List<CustomerRecord> getAllCustomerRecords(){
//		
//		//Temp return stuff until postgres working
//		CustomerRecord c1 = new CustomerRecord("John", "Doe", "j.doe@example.com", "1 Main Street");
//		CustomerRecord c2 = new CustomerRecord("Jane", "Jone", "j.jones@example.com", "2 North Street");
//		
//		List<CustomerRecord> customerRecords = new ArrayList<>();
//		customerRecords.add(c1);
//		customerRecords.add(c2);
//		
//		return customerRecords;
//		
//	}

}
