package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Destination
 *
 */
@Entity

public class Destination implements Serializable {

	   
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String description;
	private static final long serialVersionUID = 1L;

	public Destination() {
		super();
	}   
	
	public Destination(String id, String firstName, String lastName, String eMail, String description) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.description = description;
	}
	
	public String getId() {
		return this.id;
	}

	
	public void setId(String id) {
		this.id = id;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
