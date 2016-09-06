package service;

import phi.vo.ReturnMsg;
import phi.vo.ReturnObj;

public class MessageObj {
	
	public static ReturnObj MsgObj(Integer code, Object result) {
		ReturnObj returnObj = new ReturnObj();
		returnObj.setCode(code);
		returnObj.setResult(result);
		return returnObj;
	}
	
	public static ReturnMsg MsgClass(Integer code, String message) {
		ReturnMsg returnMsg = new ReturnMsg();
		returnMsg.setCode(code);
		returnMsg.setMessage(message);
		return returnMsg;
	}
	
	public static ReturnMsg MsgClass(Integer code, Object result) {
		ReturnMsg returnMsg = new ReturnMsg();
		returnMsg.setCode(code);
		returnMsg.setResult(result);
		return returnMsg;
	}
	
	public static ReturnMsg MsgClass(Integer code, String message, Object result) {
		ReturnMsg returnMsg = new ReturnMsg();
		returnMsg.setCode(code);
		returnMsg.setMessage(message);
		returnMsg.setResult(result);
		return returnMsg;
	}
	
	public static ReturnMsg MsgClass(Integer code, Object result, Object other) {
		ReturnMsg returnMsg = new ReturnMsg();
		returnMsg.setCode(code);
		returnMsg.setResult(result);
		returnMsg.setOther(other);
		return returnMsg;
	}
	
	public static ReturnMsg MsgClass(Integer code, Object result, Object other, Object other2) {
		ReturnMsg returnMsg = new ReturnMsg();
		returnMsg.setCode(code);
		returnMsg.setResult(result);
		returnMsg.setOther(other);
		returnMsg.setOther2(other2);
		return returnMsg;
	}
	
	public static ReturnMsg MsgClass(Integer code, Object result, Object other, Object other2, Object other3) {
		ReturnMsg returnMsg = new ReturnMsg();
		returnMsg.setCode(code);
		returnMsg.setResult(result);
		returnMsg.setOther(other);
		returnMsg.setOther2(other2);
		returnMsg.setOther3(other3);
		return returnMsg;
	}
}
