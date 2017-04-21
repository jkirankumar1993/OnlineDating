package bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;


public class usercompleteinfo {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String name;
	private Date dob;
	private String sex;
	private String interest;
	private String status;
	private int likes;
	private int views;
	private String photoimage;
	private int zipcode;
	private int theme;
	
	
	
	public int getTheme() {
		return theme;
	}
	public void setTheme(int theme) {
		this.theme = theme;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getPhotoimage() {
		return photoimage;
	}
	public void setPhotoimage(String photoimage) {
		this.photoimage = photoimage;
	}
	
	
	
	public usercompleteinfo(String username, String name, Date dob, String sex, String interest, String status,
			int likes, int views, String photoimage, int zipcode, int theme) {
		super();
		this.username = username;
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.interest = interest;
		this.status = status;
		this.likes = likes;
		this.views = views;
		this.photoimage = photoimage;
		this.zipcode = zipcode;
		this.theme = theme;
	}
	public int getage(){
		
	LocalDate dateofbirth = dob.toLocalDate();
	LocalDate current = LocalDate.now();
	return Period.between(dateofbirth, current).getYears();
		
	}
	
	
	
	
	
	
	
}
