package service;

import net.sf.json.JSONObject;
import phi.vo.ReturnMsg;

public class Typecast {
	
	public static JSONObject ClassToJsonobj(ReturnMsg returnMsg) {
		return JSONObject.fromObject(returnMsg);
	}
}
