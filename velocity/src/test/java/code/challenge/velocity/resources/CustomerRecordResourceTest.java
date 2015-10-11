package code.challenge.velocity.resources;

import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import code.challenge.velocity.dao.CustomerRecordDao;
import code.challenge.velocity.model.CustomerRecord;

/**
 * Test class for CustomerRecordResource
 * 
 * @author aaron
 */
public class CustomerRecordResourceTest {

	private CustomerRecordResource custRecordRes;
	private CustomerRecordDao dao;
	
	
	@Before
	public void setUp() throws Exception {
		dao = mock(CustomerRecordDao.class); 
		custRecordRes = new CustomerRecordResource();
		custRecordRes.setCustomerRecordDao(dao);
	}

	
	@Test
	public void testGetCustomerRecords() {
		
		// Create list
		List<CustomerRecord> records = new ArrayList<CustomerRecord>();
		records.add(new CustomerRecord("John", "Doe", "j.doe@test.com", "1 Main Street"));
		records.add(new CustomerRecord("Dave", "Smith", "d.smith@test.com", "1 North Avenue"));
		
		//return mocked result set on find
		when(dao.getAllCustomerRecords()).thenReturn(records); 
		List<CustomerRecord> result = custRecordRes.getCustomerRecords();
		assertArrayEquals("getCustomerRecords result is not as expected.", records.toArray(), result.toArray()); 
		
		//verify the method was called
		verify(dao).getAllCustomerRecords(); 
	}

	@Test
	public void testAddCustomerRecords() {
		
		// Test for empty list
		List<CustomerRecord> emptyList = new ArrayList<CustomerRecord>();
		Response result = custRecordRes.addCustomerRecords(emptyList);
		assertEquals("addCustomerRecords result is not as expected.", 400, result.getStatus());
		
		
		// Begin DAO test using Mock
		List<CustomerRecord> mockCustRecords = new ArrayList<CustomerRecord>();
		mockCustRecords.add(new CustomerRecord("John", "Doe", "j.doe@test.com", "1 Main Street"));

		//return mocked result set on find
		when(dao.addCustomerRecord(mockCustRecords.get(0))).thenReturn(mockCustRecords.get(0)); 
		result = custRecordRes.addCustomerRecords(mockCustRecords);
		assertEquals("addCustomerRecords result is not as expected.", 201, result.getStatus());
		
		//verify the method was called
		verify(dao).addCustomerRecord(mockCustRecords.get(0)); 
	}

}
