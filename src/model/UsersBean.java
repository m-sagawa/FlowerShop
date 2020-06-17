package model;

import java.io.Serializable;

public class UsersBean implements Serializable {
	private String userID;
	private String userPASS;
	private String type;

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPASS() {
		return userPASS;
	}
	public void setUserPASS(String userPASS) {
		this.userPASS = userPASS;
	}
	public String getType() {
		return type;
	}
	public void getType(String type) {
		this.type = type;
	}
}
