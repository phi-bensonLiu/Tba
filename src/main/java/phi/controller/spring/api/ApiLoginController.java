package phi.controller.spring.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import phi.dao.to.Members;
import phi.vo.ReturnObj;
import service.Log;
import service.MessageObj;

import com.google.code.kaptcha.Constants;

@Controller
@RequestMapping(value = "/Tba/Api")
public class ApiLoginController {
	private final static ResourceBundle apiBundle = ResourceBundle.getBundle("resources/api");
	private final String USER_AGENT = "Mozilla/5.0";
	
	@RequestMapping(value = {"/Login"})
	public @ResponseBody ReturnObj apiLogin(@RequestBody Members members, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		ReturnObj returnObj = new ReturnObj();
		String loginApiPath = apiBundle.getString("loginApiPath");
		try {
			HttpSession session = request.getSession();  
			String sessionKaptcha = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
			
			if(sessionKaptcha.equals(members.getValidateCode())){
				HttpClient client = HttpClientBuilder.create().build();
				HttpPost post = new HttpPost(loginApiPath);
				post.setHeader("User-Agent", USER_AGENT);
				
				List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
				urlParameters.add(new BasicNameValuePair("pAccount", members.getAccount()));
				urlParameters.add(new BasicNameValuePair("pPwd", members.getPassword()));
				post.setEntity(new UrlEncodedFormEntity(urlParameters));
				
				HttpResponse rep = client.execute(post);
				if(rep.getStatusLine().getStatusCode() == 200){
					BufferedReader rd = new BufferedReader(new InputStreamReader(rep.getEntity().getContent()));

					StringBuffer result = new StringBuffer();
					String line = "";
					while ((line = rd.readLine()) != null) {
						result.append(line);
					}
					JSONObject memberTmp = JSONObject.fromObject(result.toString());
					if(!"".equals(memberTmp.getString("Type"))){
						members.setAccount(memberTmp.getString("Account"));
						members.setMemberType(memberTmp.getString("Type"));
						members.setMemberRank(memberTmp.getString("Rank"));
						members.setMemberName(memberTmp.getString("Name"));
						members.setMemberSex(memberTmp.getString("Sex"));
						members.setMemberCid(memberTmp.getString("Cid"));
						members.setAuth(memberTmp.getString("AuthKey"));
						
						returnObj = MessageObj.MsgObj(200, members);
						session.setAttribute("memberInfo", returnObj);
					}else{
						returnObj = MessageObj.MsgObj(400, "帳號密碼錯誤");
					}					
				}
			}else{
				returnObj = MessageObj.MsgObj(400, "驗證碼錯誤");
			}
		} catch (Exception e){
			Log.logError("ApiLoginController apiLogin Error : ", e);
		}
		return returnObj;
	}
}


