package entities;

import java.io.Serializable;

/**
 * ID class for entity: askings
 *
 */ 
public class askingsPK  implements Serializable {   
   
	         
	private int firstMeeting;         
	private int secondMeeting;
	private static final long serialVersionUID = 1L;

	public askingsPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof askingsPK)) {
			return false;
		}
		askingsPK other = (askingsPK) o;
		return true
			&& getFirstMeeting() == other.getFirstMeeting()
			&& getSecondMeeting() == other.getSecondMeeting();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getFirstMeeting();
		result = prime * result + getSecondMeeting();
		return result;
	}
   
   
}
