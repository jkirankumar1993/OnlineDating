package bean;

public class conversation_users {
	private String username1;
    private String username2;
    private String message;
	public String getUsername1() {
		return username1;
	}
	public void setUsername1(String username1) {
		this.username1 = username1;
	}
	public String getUsername2() {
		return username2;
	}
	public void setUsername2(String username2) {
		this.username2 = username2;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public conversation_users(String username1, String username2, String message) {
		this.username1 = username1;
		this.username2 = username2;
		this.message = message;
	}
}
