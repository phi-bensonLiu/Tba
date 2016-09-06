package phi.controller.spring;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class VodController {
	
	@RequestMapping({"/vod1"})
	public String vod1(Model model, HttpServletResponse response) throws Exception {
		return "/webView/pages1";
	}
	
	@RequestMapping({"/vod2"})
	public String vod2(Model model, HttpServletResponse response) throws Exception {
		return "/webView/pages2";
	}
	
}
