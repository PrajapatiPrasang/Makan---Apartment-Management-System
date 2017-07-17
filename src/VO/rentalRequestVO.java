package VO;

import java.io.Serializable;

public class rentalRequestVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int rental_request_id;
	private String first_name;
	private String last_name;
	private String email_id;
	private String address;
	private Long phone_no;
	private String status;
	private addApartmentVO addApartmentVO;
	
		public static long getSerialversionuid() {
		return serialVersionUID;
	}

		public int getRental_request_id() {
			return rental_request_id;
		}

		public void setRental_request_id(int rental_request_id) {
			this.rental_request_id = rental_request_id;
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

		public addApartmentVO getAddApartmentVO() {
			return addApartmentVO;
		}

		public void setAddApartmentVO(addApartmentVO addApartmentVO) {
			this.addApartmentVO = addApartmentVO;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		}
