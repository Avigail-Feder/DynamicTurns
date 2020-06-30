package entites;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.johnzon.mapper.JohnzonConverter;

public class Meeting {

	
	private int id;
	private String subject;
	@JohnzonConverter(LocalDateTimeConverter.class)
	private LocalDateTime startTime;
	@JohnzonConverter(LocalDateTimeConverter.class)
	private LocalDateTime endTime;
	private String destId;
	private String customerId;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getDestId() {
		return destId;
	}
	public void setDestId(String destId) {
		this.destId = destId;
	}

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Meeting(int id, String subject, LocalDateTime startTime, LocalDateTime endTime,String destId,String cusId) {
		super();
		this.id = id;
		this.subject = subject;
		this.startTime = startTime;
		this.endTime = endTime;
		this.destId=destId;
		this.customerId=cusId;
	}
	public Meeting() {
		super();
	}
	@Override
	public String toString() {
		return "Meeting [id=" + id + ", subject=" + subject + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", destId=" + destId + ", customerId=" + customerId + "]";
	}


	
}
