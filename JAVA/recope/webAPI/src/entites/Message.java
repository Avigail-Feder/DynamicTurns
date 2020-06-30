package entites;

public class Message {
	int code;
	String userId;
	String content;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Message(int code, String userId, String content) {
		super();
		this.code = code;
		this.userId = userId;
		this.content = content;
	}
	
	public Message() {
		super();
		
	}
	@Override
	public String toString() {
		return "Message [code=" + code + ", userId=" + userId + ", content=" + content + "]";
	}

}
