package lanqiao.vo;

import java.io.Serializable;

public class JsonResult implements Serializable{
	/**
	 * Json结果对象，用来统一消息通知
	 *
	 */
	private String status;
	private String message;
	private Object data;
	
	public JsonResult(String message,String status,Object data) {
		this.message=message;
		this.status=status;
		this.data=data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
