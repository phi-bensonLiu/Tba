package phi.controller.spring;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EventController {
	
	@RequestMapping({"/event"})
	public String event(Model model, HttpServletResponse response) throws Exception {
		return "/webView/event";
	}
	
}
