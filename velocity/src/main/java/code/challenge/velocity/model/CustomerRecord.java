package code.challenge.velocity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This Class represents the CustomerRecord object
 * 
 * @author aaron
 */
@Entity
public class CustomerRecord {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	 * Constructor 
	 * 
	 * @param userid
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 */
	public CustomerRecord(String firstName, String lastName, String email, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}
	
	/**
	 * Getter for Id
	 * 
	 * @return Id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Setter for Id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	} 	
	
	/**
	 * Getter for FirstName
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Setter for FirstName
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Getter for LastName
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Setter for LastName
	 *  
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Getter for email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setter for email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Setter for Address
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Setter for Address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
