package entites;

import java.time.LocalDateTime;

public class Request {
	int code;

	String requesterId;
	int requester_meetingId;
	LocalDateTime dateToChange;

	String responderId;
	int responder_meetingId;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getRequesterId() {
		return requesterId;
	}
	public void setRequesterId(String requesterId) {
		this.requesterId = requesterId;
	}
	public int getRequester_meetingId() {
		return requester_meetingId;
	}
	public void setRequester_meetingId(int requester_meetingId) {
		this.requester_meetingId = requester_meetingId;
	}
	public LocalDateTime getDateToChange() {
		return dateToChange;
	}
	public void setDateToChange(LocalDateTime dateToChange) {
		this.dateToChange = dateToChange;
	}
	public String getResponderId() {
		return responderId;
	}
	public void setResponderId(String responderId) {
		this.responderId = responderId;
	}
	public int getResponder_meetingId() {
		return responder_meetingId;
	}
	public void setResponder_meetingId(int responder_meetingId) {
		this.responder_meetingId = responder_meetingId;
	}
	public Request(int code, String requesterId, int requester_meetingId, LocalDateTime dateToChange,
			String responderId, int responder_meetingId) {
		super();
		this.code = code;
		this.requesterId = requesterId;
		this.requester_meetingId = requester_meetingId;
		this.dateToChange = dateToChange;
		this.responderId = responderId;
		this.responder_meetingId = responder_meetingId;
	}

}
