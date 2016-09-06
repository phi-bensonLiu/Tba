package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import phi.vo.ReturnMsg;
import net.sf.json.JSONObject;

public class SussceMessage {
	
	public static String MsgJsonObj(String message) {
		JSONObject sussceMsg = new JSONObject();
		sussceMsg.put("sussceCode", 200);
		sussceMsg.put("sussceMessage", message);
		return sussceMsg.toString();
	}
	
	public static List<Map<String, Object>> MsgListMap(String message) {
		List<Map<String, Object>> sussceMsgList = new ArrayList<Map<String, Object>>();
		Map<String, Object> sussceMsgMap = new HashMap<String, Object>();
		sussceMsgMap.put("sussceCode", 200);
		sussceMsgMap.put("sussceMessage", message);
		sussceMsgList.add(sussceMsgMap);
		return sussceMsgList;
	}
	
	public static Map<String, Object> MsgMap(String message, Integer lastId) {
		Map<String, Object> sussceMsgMap = new HashMap<String, Object>();
		sussceMsgMap.put("sussceCode", 200);
		sussceMsgMap.put("sussceMessage", message);
		sussceMsgMap.put("lastID", lastId);
		return sussceMsgMap;
	}
	
	public static Map<String, Object> MsgMap(String message, Object msg) {
		Map<String, Object> sussceMsgMap = new HashMap<String, Object>();
		sussceMsgMap.put("sussceCode", 200);
		sussceMsgMap.put("sussceMessage", message);
		sussceMsgMap.put("msg", msg);
		return sussceMsgMap;
	}
	
	public static ReturnMsg MsgClass(Integer code, String message, Integer lastId) {
		ReturnMsg returnMsg = new ReturnMsg();
		returnMsg.setCode(code);
		returnMsg.setMessage(message);
		returnMsg.setLastId(lastId);
		return returnMsg;
	}
	
	public static ReturnMsg MsgClass(Integer code, String message) {
		ReturnMsg returnMsg = new ReturnMsg();
		returnMsg.setCode(code);
		returnMsg.setMessage(message);
		return returnMsg;
	}
}
