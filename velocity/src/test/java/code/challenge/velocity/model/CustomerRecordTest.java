package code.challenge.velocity.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for CustomerRecord
 * 
 * @author aaron
 */
public class CustomerRecordTest {
	
	private static final String TEXT = "some text";
	CustomerRecord emptyCustomerRecord;
	
	@Before
	public void setUp() throws Exception {
		emptyCustomerRecord =  new CustomerRecord();
	}

	@Test
	public void testId() {
		emptyCustomerRecord.setId(1L);
		assertEquals("Id is not as expected.", 1L, (long)emptyCustomerRecord.getId());
	}


	@Test
	public void testFirstName() {
		emptyCustomerRecord.setFirstName(TEXT);
		assertEquals("Firstname is not as expected.", TEXT, emptyCustomerRecord.getFirstName());
	}


	@Test
	public void testLastName() {
		emptyCustomerRecord.setLastName(TEXT);
		assertEquals("Lastname is not as expected.", TEXT, emptyCustomerRecord.getLastName());
	}


	@Test
	public void testEmail() {
		emptyCustomerRecord.setLastName(TEXT);
		assertEquals("Email is not as expected.", TEXT, emptyCustomerRecord.getLastName());
	}


	@Test
	public void testAddress() {
		emptyCustomerRecord.setAddress(TEXT);
		assertEquals("Address is not as expected.", TEXT, emptyCustomerRecord.getAddress());
	}

}
