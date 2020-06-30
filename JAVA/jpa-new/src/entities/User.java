package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity(name="user")
@Table(name = "users")

public class User implements Serializable {

	@Id
	
	private String id;
	private String first_name;
	private String last_name;
	private String telephone;
	private String address;
	private String email;
	private String password;
	private boolean isManager;

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}

	public User(String id, String first_name, String last_name, String telephone, String address, String email,
			String password,boolean isManager) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.telephone = telephone;
		this.address = address;
		this.email = email;
		this.password = password;
		this.isManager = isManager;
	}

	

	
}
