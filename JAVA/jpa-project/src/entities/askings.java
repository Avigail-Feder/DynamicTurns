package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: askings
 *
 */
@Entity

@IdClass(askingsPK.class)
public class askings implements Serializable {

	
	
	@Id
	private int firstMeeting;   
	@Id
	private int secondMeeting;
	private static final long serialVersionUID = 1L;

	public askings() {
		super();
	}   
	public askings(int firstMeetingId, int secondMeetingId) {
		this.firstMeeting=firstMeetingId;
		this.secondMeeting=secondMeetingId;
	}
	public int getFirstMeeting() {
		return this.firstMeeting;
	}

	public void setFirstMeeting(int firstMeeting) {
		this.firstMeeting = firstMeeting;
	}   
	public int getSecondMeeting() {
		return this.secondMeeting;
	}

	public void setSecondMeeting(int secondMeeting) {
		this.secondMeeting = secondMeeting;
	}
	@Override
	public String toString() {
		return "askings [firstMeeting=" + firstMeeting + ", secondMeeting=" + secondMeeting + "]";
	}
   
}
