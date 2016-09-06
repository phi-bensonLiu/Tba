package phi.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReturnObj implements Serializable{
	private Integer code;
	private Object result;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
