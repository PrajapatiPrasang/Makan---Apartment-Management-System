package VO;

import java.io.Serializable;

public class contactUsVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int contact_us_id;
	private String name;
	private String email;
	private String phone;
	private String message;
		public static long getSerialversionuid() {
		return serialVersionUID;
	}
		public int getContact_us_id() {
			return contact_us_id;
		}
		public void setContact_us_id(int contact_us_id) {
			this.contact_us_id = contact_us_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	


}
