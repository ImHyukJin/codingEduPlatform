package com.project.cep.handler.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	com.project.cep.repository.user.account.UserMapper userMapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		com.project.cep.security.MyUserDetails details =(com.project.cep.security.MyUserDetails)authentication.getPrincipal();
		
		String role =details.getRole();
		System.out.println("로그인성공: "+ role);
		
		
		if(role.equals("ROLE_educ")) {
			response.sendRedirect("/user/main_page");
			
		}else if(role.equals("ROLE_stud")) {
			response.sendRedirect("/user/main_page");
		}else {
			response.sendRedirect("/user/main_page");
		}
		
		
	}

}
