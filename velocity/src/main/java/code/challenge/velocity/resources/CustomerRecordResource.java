package code.challenge.velocity.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import code.challenge.velocity.dao.CustomerRecordDao;
import code.challenge.velocity.model.CustomerRecord;

/**
 * This class is the Root resource (exposed at "CustomerRecords" path)
 * 
 * @author aaron
 */
@Path("/CustomerRecords")
public class CustomerRecordResource {
	
	CustomerRecordDao customerRecordDao = new CustomerRecordDao();
	
    /**
     * Method handling HTTP GET requests.
     *
     * @return List<CustomerRecord>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerRecord> getCustomerRecords() {
        return customerRecordDao.getAllCustomerRecords();
    }
	
    /**
     * Method handling HTTP POST requests. 
     *
     * @return Response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomerRecords(List<CustomerRecord> customerRecords) {
    	
    	Response response;
    	if(null != customerRecords && !customerRecords.isEmpty()) {
    		for(CustomerRecord customerRecord : customerRecords) {
	    		customerRecordDao.addCustomerRecord(customerRecord);
	    	}
    		response = Response.status(201).entity("Customer Records Added").build();
    	}
    	else {
	    	response = Response.status(400).entity("No records to add").build();
    	}
    	return response;
    }
    
    /**
     * Method to facilitate mocking dao for testing
     * @param dao
     */
    public void setCustomerRecordDao(CustomerRecordDao dao){
    	customerRecordDao = dao;
    }
	
}
