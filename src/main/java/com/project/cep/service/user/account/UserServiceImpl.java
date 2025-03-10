package com.project.cep.service.user.account;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cep.dto.user.account.UserVO;
import com.project.cep.repository.user.account.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserVO login(String userName) {
		UserVO vo = userMapper.login(userName);
		return vo;
	}

	@Override
	public int join(UserVO userVO) {
		int a = userMapper.join(userVO);
		return a;
	}

	@Override
	public UserVO checkLogin(String userName) {
		return userMapper.checkLogin(userName);
	}

	@Override
	public void updatePw(String user_pw, String user_pn) {
		userMapper.updatePw(user_pw, user_pn);
	}

	@Override
	public int auth(Map<String, Object> map) {
		int a = userMapper.auth(map);
		return a;
	}

	@Override
	public UserVO aLogin(String pn) {
		return userMapper.aLogin(pn);
	}

	@Override
	public UserVO authCheck(String auth_nm, String user_pn) {
		return userMapper.authCheck(auth_nm, user_pn);
	}

}
