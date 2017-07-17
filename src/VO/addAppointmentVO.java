package VO;

import java.io.Serializable;

public class addAppointmentVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int appointment_id;
	private String firstname;
	private String lastname;
	private String emaiid;
	private String phoneno;
	private String address;
	private String date;
	private String slot;
	private addApartmentVO addApartmentVO;
	
	public addApartmentVO getAddApartmentVO() {
		return addApartmentVO;
	}
	public void setAddApartmentVO(addApartmentVO addApartmentVO) {
		this.addApartmentVO = addApartmentVO;
	}
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmaiid() {
		return emaiid;
	}
	public void setEmaiid(String emaiid) {
		this.emaiid = emaiid;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	}
