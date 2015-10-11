package code.challenge.velocity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import code.challenge.velocity.model.CustomerRecord;
public class CustomerRecordService {
	
	/**
	 * 
	 * @return CustomerRecords
	 */
	public List<CustomerRecord> getAllCustomerRecords(){
		
		//Temp return stuff until postgres working
		CustomerRecord c1 = new CustomerRecord(UUID.randomUUID(), "John", "Doe", "j.doe@example.com", "1 Main Street");
		CustomerRecord c2 = new CustomerRecord(UUID.randomUUID(), "Jane", "Jone", "j.jones@example.com", "2 North Street");
		
		List<CustomerRecord> customerRecords = new ArrayList<>();
		customerRecords.add(c1);
		customerRecords.add(c2);
		
		return customerRecords;
		
	}

}