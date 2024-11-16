package com.project.cep.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.project.cep.dto.user.account.UserVO;

public class MyUserDetails implements UserDetails , OAuth2User{

	private static final Logger logger = LoggerFactory.getLogger(MyUserDetails.class);
	private UserVO userVO;
	private Map<String, Object> attributes;
	
	public MyUserDetails(UserVO vo) {
		this.userVO = vo;
	}
	public MyUserDetails(UserVO vo , Map<String,Object> attributes) {
		this.userVO = vo;
		this.attributes = attributes;
		logger.info("vo : " + vo);
		logger.info("attributes : " + attributes);
	}
	
	public UserVO getUserVO() {
		return userVO;
	}
	
	public String getRole() {
		return userVO.getRole();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		ArrayList<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(()-> userVO.getRole());
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userVO.getUser_pw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userVO.getUser_nm();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return attributes;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return userVO.getUser_nm();
	}

	
}
