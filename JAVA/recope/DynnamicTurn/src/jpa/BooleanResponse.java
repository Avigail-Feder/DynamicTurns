package jpa;

public class BooleanResponse {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isTrue;

	public boolean getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	public BooleanResponse(boolean isTrue) {
		super();
		this.isTrue = isTrue;
	}

	public BooleanResponse() {
		super();
	}

	@Override
	public String toString() {
		return "BooleanResponse [isTrue=" + isTrue + "]";
	}

}
