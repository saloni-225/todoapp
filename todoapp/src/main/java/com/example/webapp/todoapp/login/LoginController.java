package com.example.webapp.todoapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	private AuthenticationService auth;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
//	@ResponseBody
	public String getLogin() {
		return "login";
	}
//	@RequestMapping("/")
//	public String showWelcomePage() {
//		
//		return "welcome";
//	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String getWelcome(@RequestParam String name,@RequestParam String password,ModelMap model) {
		
		if(auth.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
		model.put("errorMessage", "Authentication Failed");
		return "login";
	}

}
