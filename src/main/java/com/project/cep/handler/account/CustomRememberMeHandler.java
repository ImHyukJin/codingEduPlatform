package com.project.cep.handler.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.project.cep.security.MyUserDetails;


public class CustomRememberMeHandler implements AuthenticationSuccessHandler{

	@Autowired
	com.project.cep.repository.user.account.UserMapper userMapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		com.project.cep.security.MyUserDetails details =(MyUserDetails)authentication.getPrincipal();

		String role =details.getRole();
		System.out.println("자동로그인됨");

		if(role.equals("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
		}else if(role.equals("ROLE_STUDENT")) {
			response.sendRedirect("/user/mainPage");
		}else {
			response.sendRedirect("/user/mainPage");
		}
	}

}
