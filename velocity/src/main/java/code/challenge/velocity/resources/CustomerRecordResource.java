package code.challenge.velocity.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import code.challenge.velocity.model.CustomerRecord;
import code.challenge.velocity.service.CustomerRecordService;

/**
 * Root resource (exposed at "customer" path)
 */
@Path("/customer")
public class CustomerRecordResource {
	
	CustomerRecordService recordService = new CustomerRecordService();
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "JSON" media type.
     *
     * @return String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerRecord> getCustomerRecords() {
        return recordService.getAllCustomerRecords();
    }
	
	
}
