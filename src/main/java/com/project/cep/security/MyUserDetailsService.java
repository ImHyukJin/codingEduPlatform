package com.project.cep.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.cep.dto.user.UserVO;
import com.project.cep.repository.user.UserMapper;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//로그인 시도
		UserVO userVO = userMapper.login(username);
		
		if(userVO != null) {
			return new MyUserDetails(userVO);
		}
		return null;
	}
}
