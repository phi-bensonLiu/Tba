package phi.controller.spring.api;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import phi.dao.to.Members;
import phi.vo.ReturnObj;
import service.EncodingTool;
import service.Log;
import service.MessageObj;

@Controller
@RequestMapping(value = "/Tba/Api")
public class ApiMemberController {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/resources");
	
	@RequestMapping(value = {"/MemberInfo2"})
	public @ResponseBody ReturnObj memberInfo2(Model model, HttpServletResponse response, HttpServletRequest request, 
			@RequestParam("mid") String mid, 
			@RequestParam("type") String type,
			@RequestParam("rank") String rank,
			@RequestParam("name") String name,
			@RequestParam("sex") String sex,
			@RequestParam("cid") String cid,
			@RequestParam("auth") String auth) throws Exception {
		ReturnObj returnObj = new ReturnObj();
		try {
			Members members = new Members();
			members.setMid(mid);
			members.setMemberType(type);
			members.setMemberRank(rank);
			members.setMemberName(name);
			members.setMemberSex(sex);
			members.setMemberCid(cid);
			members.setAuth(auth);
			returnObj = MessageObj.MsgObj(200, members);
		} catch (Exception e){
			Log.logError("MemberController memberInfo Error : ", e);
		}
		return returnObj;
	}
	
	@RequestMapping(value = {"/MemberInfo"})
	public String memberInfo(Model model, HttpServletResponse response, HttpServletRequest request, 
			@RequestParam("mid") String mid, 
			@RequestParam("type") String type,
			@RequestParam("rank") String rank,
			@RequestParam("name") String name,
			@RequestParam("sex") String sex,
			@RequestParam("cid") String cid,
			@RequestParam("auth") String auth) throws Exception {
		ReturnObj returnObj = new ReturnObj();
		HttpSession session = request.getSession();
		try {
			Members members = new Members();
			members.setMid(mid);
			members.setMemberType(type);
			members.setMemberRank(rank);
			members.setMemberName(name);
			members.setMemberSex(sex);
			members.setMemberCid(cid);
			members.setAuth(auth);
			returnObj = MessageObj.MsgObj(200, members);
			session.setAttribute("memberInfo", returnObj);
		} catch (Exception e){
			Log.logError("MemberController memberInfo Error : ", e);
		}
		return "redirect:/index";
	}
}


