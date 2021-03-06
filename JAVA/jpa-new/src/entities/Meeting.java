package entities;

import java.io.Serializable;
import java.lang.String;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Meeting
 *
 *
 */
@Entity

public class Meeting implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subject;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String destId;
	private String customerId;
	
	private static final long serialVersionUID = 1L;

	public Meeting() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}   
	public LocalDateTime getStartTime() {
		return this.startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}   
	public LocalDateTime getEndTime() {
		return this.endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getDestId() {
		return destId;
	}
	public void setDestId(String destId) {
		this.destId = destId;
	}
   
}
