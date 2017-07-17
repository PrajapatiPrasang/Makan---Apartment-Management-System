package VO;

import java.io.Serializable;

public class loginVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int login_id;
	private String user_name;
	private String password;
	private String user_type;
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}
