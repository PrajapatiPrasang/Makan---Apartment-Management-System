package VO;

import java.io.Serializable; 

public class addResidentVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int resident_id;
	private String first_name;
	private String last_name;
	private String email_id;
	private Long phone_no;
	private String address;
	private String user_id;
	private String password;
	private String user_type;
	private loginVO loginvo;
	private addApartmentVO addApartmentVO;
	
	
	
	
	public addApartmentVO getAddApartmentVO() {
		return addApartmentVO;
	}
	public void setAddApartmentVO(addApartmentVO addApartmentVO) {
		this.addApartmentVO = addApartmentVO;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public int getResident_id() {
		return resident_id;
	}
	public void setResident_id(int resident_id) {
		this.resident_id = resident_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public Long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public loginVO getLoginvo() {
		return loginvo;
	}
	public void setLoginvo(loginVO loginvo) {
		this.loginvo = loginvo;
	}
	
	
	
}
