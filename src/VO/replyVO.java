package VO;

import java.io.Serializable;

public class replyVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int reply_id;
	private requestServiceVO requestServiceVO;
	private addResidentVO addResidentVO;
	private String reply_message;
		public static long getSerialversionuid() {
		return serialVersionUID;
	}
		public int getReply_id() {
			return reply_id;
		}
		public void setReply_id(int reply_id) {
			this.reply_id = reply_id;
		}
		
		
		public requestServiceVO getRequestServiceVO() {
			return requestServiceVO;
		}
		public void setRequestServiceVO(requestServiceVO requestServiceVO) {
			this.requestServiceVO = requestServiceVO;
		}
		public addResidentVO getAddResidentVO() {
			return addResidentVO;
		}
		public void setAddResidentVO(addResidentVO addResidentVO) {
			this.addResidentVO = addResidentVO;
		}
		public String getReply_message() {
			return reply_message;
		}
		public void setReply_message(String reply_message) {
			this.reply_message = reply_message;
		}
	


}
