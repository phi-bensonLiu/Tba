package phi.controller.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import phi.vo.ReturnObj;
import service.Log;
import service.MessageObj;

@Controller
@RequestMapping(value = "/controller/view")
public class MemberController {
	@RequestMapping(value = {"/login"})
	public @ResponseBody ReturnObj loginCheck(HttpServletResponse response, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		ReturnObj returnObj = new ReturnObj();
		try {
			returnObj = (ReturnObj) session.getAttribute("memberInfo");
			if(returnObj == null){
				returnObj = MessageObj.MsgObj(400, "fail");
			}
		} catch (Exception e){
			Log.logError("LoginController loginCheck Error : ", e);
		}
		return returnObj;
	}
}


