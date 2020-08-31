package idv.owen.Application.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
		
	@GetMapping("/")
	public String index(Map<String, Object> model) {
		String message="New Message Demo";
		model.put("message",message);
		return "index";
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
}












