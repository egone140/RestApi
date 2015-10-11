package code.challenge.velocity.model;

import java.util.UUID;


public class CustomerRecord {
	
	//{"firstName":"John", "lastName":"Doe", "email":"j.doe@velocity.com", "address":"1 Main Street"},
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	
	/**
	 * No Arg Constructor 
	 */
	public CustomerRecord() {
	
	}
	
	/**
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 */
	public CustomerRecord(UUID id, String firstName, String lastName, String email, String address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
