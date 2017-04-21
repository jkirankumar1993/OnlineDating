package bean;

public class searchuserconversation {
	private String username;
	private String photoimage;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhotoimage() {
		return photoimage;
	}
	public void setPhotoimage(String photoimage) {
		this.photoimage = photoimage;
	}
	public searchuserconversation(String username, String photoimage) {
		super();
		this.username = username;
		this.photoimage = photoimage;
	}
	
}
