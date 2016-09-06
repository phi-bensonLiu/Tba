package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import phi.vo.ReturnMsg;
import net.sf.json.JSONObject;

public class ErrorMessage {
	
	public static String MsgJsonObj(String message) {
		JSONObject ErrorMsg = new JSONObject();
		ErrorMsg.put("errorCode", 400);
		ErrorMsg.put("errorMessage", message);
		return ErrorMsg.toString();
	}
	
	public static List<Map<String, Object>> MsgListMap(String message) {
		List<Map<String, Object>> ErrMsgList = new ArrayList<Map<String, Object>>();
		Map<String, Object> ErrMsgMap = new HashMap<String, Object>();
		ErrMsgMap.put("errorCode", 400);
		ErrMsgMap.put("errorMessage", message);
		ErrMsgList.add(ErrMsgMap);
		return ErrMsgList;
	}
	
	public static Map<String, Object> MsgMap(String message) {
		Map<String, Object> ErrMsgMap = new HashMap<String, Object>();
		ErrMsgMap.put("errorCode", 400);
		ErrMsgMap.put("errorMessage", message);
		return ErrMsgMap;
	}
	
	public static ReturnMsg MsgClass(Integer code, String message, Object result) {
		ReturnMsg returnMsg = new ReturnMsg();
		returnMsg.setCode(code);
		returnMsg.setMessage(message);
		returnMsg.setResult(result);
		return returnMsg;
	}
}
