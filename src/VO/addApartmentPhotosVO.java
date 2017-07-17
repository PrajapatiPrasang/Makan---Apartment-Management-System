package VO;

import java.io.Serializable;

public class addApartmentPhotosVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int photo_id;
	private String file_name;
	private String encrypted_name;
	private addApartmentVO addApartmentVO;
	
	public int getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
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
	
	public addApartmentVO getAddApartmentVO() {
		return addApartmentVO;
	}
	public void setAddApartmentVO(addApartmentVO addApartmentVO) {
		this.addApartmentVO = addApartmentVO;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	}
