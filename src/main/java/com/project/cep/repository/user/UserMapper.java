package com.project.cep.repository.user;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.cep.dto.user.UserVO;

@Mapper
public interface UserMapper {

	public UserVO login(String userId);
	public int join(UserVO userVO);
	public UserVO checkLogin(String userName);
	public void updatePw(@Param("user_pw") String user_pw ,@Param("user_pn") String user_pn );
	
	public int auth(Map<String,Object> map);
	public UserVO aLogin(String pn);
	public UserVO authCheck(@Param("auth_nm") String auth_nm, @Param("user_pn") String user_pn);
}
