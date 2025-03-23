package com.example.webapp.todoapp.welcome;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class Welcome {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedUsername());
		return "welcome";
	}
	
	public String getLoggedUsername() {
		
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		
	}
}
