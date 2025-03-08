package com.example.webapp.todoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username,String password) {
		boolean isUsername=username.equals("dummy");
		boolean isPassword=password.equals("password");
		
		return isUsername && isPassword;
	}

}
