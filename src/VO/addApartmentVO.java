package VO;

import java.io.Serializable;

public class addApartmentVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int apartment_id;
	private String file_name;
	private String encrypted_name;
	private String address;
	private int bedroom;
	private int bathroom;
	private String aminities;
	private String city;
	private String state;
	private Long zip_code;
	private Float price;
	private String rental_status;
	
	
	
	public String getRental_status() {
		return rental_status;
	}
	public void setRental_status(String rental_status) {
		this.rental_status = rental_status;
	}
	public int getApartment_id() {
		return apartment_id;
	}
	public void setApartment_id(int apartment_id) {
		this.apartment_id = apartment_id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getEncrypted_name() {
		return encrypted_name;
	}
	public void setEncrypted_name(String encrypted_name) {
		this.encrypted_name = encrypted_name;
	}
	
	public int getBedroom() {
		return bedroom;
	}
	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}
	public int getBathroom() {
		return bathroom;
	}
	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}
	public String getAminities() {
		return aminities;
	}
	public void setAminities(String aminities) {
		this.aminities = aminities;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getZip_code() {
		return zip_code;
	}
	public void setZip_code(Long zip_code) {
		this.zip_code = zip_code;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	}
