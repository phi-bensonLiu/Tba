package phi.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReturnMsg implements Serializable{
	private Integer code;
	private String message;
	private Integer lastId;
	private Object result;
	private Object other;
	private Object other2;
	private Object other3;
	
	public ReturnMsg() {
		
	}
	
	public ReturnMsg(Integer code, String message){
		this.code = code;
		this.message = message;
	}
	
	public ReturnMsg(Integer code, String message, Integer lastId){
		this.code = code;
		this.message = message;
		this.lastId = lastId;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getLastId() {
		return lastId;
	}
	public void setLastId(Integer lastId) {
		this.lastId = lastId;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public Object getOther() {
		return other;
	}
	public void setOther(Object other) {
		this.other = other;
	}
	public Object getOther2() {
		return other2;
	}
	public void setOther2(Object other2) {
		this.other2 = other2;
	}
	public Object getOther3() {
		return other3;
	}
	public void setOther3(Object other3) {
		this.other3 = other3;
	}
}
