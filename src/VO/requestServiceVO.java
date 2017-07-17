package VO;

import java.io.Serializable;

public class requestServiceVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int service_id;
	private String service_type;
	private String service_description;
	private addResidentVO addResidentVO;
	
	
	public addResidentVO getAddResidentVO() {
		return addResidentVO;
	}
	public void setAddResidentVO(addResidentVO addResidentVO) {
		this.addResidentVO = addResidentVO;
	}
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public String getService_description() {
		return service_description;
	}
	public void setService_description(String service_description) {
		this.service_description = service_description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	}
