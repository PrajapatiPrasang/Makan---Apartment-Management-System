package VO;

import java.io.Serializable;

import java.util.Date;

public class paymentVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int payment_id;
	private String date;
	//private float rent;
	private String status;
	private addApartmentVO addApartmentVO;
	private addResidentVO addResidentVO;
	private Date payment_date;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	/*public float getRent() {
		return rent;
	}
	public void setRent(float rent) {
		this.rent = rent;
	}*/
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public addApartmentVO getAddApartmentVO() {
		return addApartmentVO;
	}
	public void setAddApartmentVO(addApartmentVO addApartmentVO) {
		this.addApartmentVO = addApartmentVO;
	}
	public addResidentVO getAddResidentVO() {
		return addResidentVO;
	}
	public void setAddResidentVO(addResidentVO addResidentVO) {
		this.addResidentVO = addResidentVO;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	
	
}
