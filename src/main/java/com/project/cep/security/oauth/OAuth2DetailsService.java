package com.project.cep.security.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.project.cep.dto.user.UserVO;
import com.project.cep.repository.user.UserMapper;
import com.project.cep.security.MyUserDetails;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuth2DetailsService extends DefaultOAuth2UserService{

	private static final Logger logger = LoggerFactory.getLogger(OAuth2DetailsService.class);
	private BCryptPasswordEncoder bc;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oauth2User = super.loadUser(userRequest);
		
		String provider = userRequest.getClientRegistration().getRegistrationId();
		logger.info("provider : " +provider);
		
		String providerId = oauth2User.getAttribute("sub");
		String loginId = "#" + providerId;
		
		logger.info("loginId : " +loginId);
		
		UserVO vo = userMapper.login(loginId);
		
		if( vo == null) {
			vo = UserVO.builder()
					.user_id(loginId)
					.user_nm(oauth2User.getAttribute("name"))
					.role("Role_stud")
					.build();
		}
		
		
		return new MyUserDetails(vo , oauth2User.getAttributes());
	}
	
	
	
}
