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
 * Root resource (exposed at "customer" path)
 */
@Path("/customer")
public class CustomerRecordResource {
	
	CustomerRecordDao customerRecordDao = new CustomerRecordDao();
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerRecord> getCustomerRecords() {
        return customerRecordDao.getAllCustomerRecords();
    }
	
    /**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return A list of Customer Records
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomerRecords(List<CustomerRecord> customerRecords) {
        
    	for(CustomerRecord customerRecord : customerRecords){
    		customerRecordDao.addCustomerRecord(customerRecord);
    	}
    	
    	return Response.status(200).entity("Created").build();
    }
	
}
