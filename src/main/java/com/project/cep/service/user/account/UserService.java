package com.project.cep.service.user.account;

import java.util.Map;

import com.project.cep.dto.user.account.UserVO;

public interface UserService {

	public UserVO login(String userName);
	public int join(UserVO userVO);
	public UserVO checkLogin(String userName);
	public void updatePw(String user_pw, String user_pn);
	
	public int auth(Map<String,Object> map);
	public UserVO aLogin(String pn);
	public UserVO authCheck(String auth_nm , String user_pn);
}
