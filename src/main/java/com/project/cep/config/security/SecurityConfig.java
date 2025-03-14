package com.project.cep.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.project.cep.handler.account.CustomRememberMeHandler;
import com.project.cep.handler.account.CustomSuccessHandler;
import com.project.cep.security.MyUserDetailsService;
import com.project.cep.security.oauth.OAuth2DetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private MyUserDetailsService myUserDetails;
	
	@Autowired
	private OAuth2DetailsService oAuthDetailsService;
	
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
    	return web -> web.ignoring()
        	.requestMatchers(PathRequest
            	.toStaticResources()
                .atCommonLocations())	
                .antMatchers("/css/**","/js/**","/img/**");
                 
     }
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		AuthenticationManager authenticationManager = 
				authenticationManager(http.getSharedObject(AuthenticationConfiguration.class));

		

		http
		.csrf().disable()
		.headers().frameOptions().sameOrigin()
		.and()
		.authorizeHttpRequests()

//		.antMatchers("/admin/**").hasAnyRole("ADMIN","MASTER")
//		.anyRequest().authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/user/login") // 로그인 페이지 URL
		.loginProcessingUrl("/loginForm") // 로그인 처리 URL
//		.defaultSuccessUrl("/user/user_main") // 로그인 성공 후 이동할 URL
		.successHandler( loginSuccessHandler() )
		.failureUrl("/user/login?err=true") // 로그인 실패 후 이동할 URL
		.and()
		.exceptionHandling().accessDeniedPage("/user/user_deny")
		.and()	
		.logout().logoutUrl("/logout").logoutSuccessUrl("/user/main_page")
		
		.and()
		.oauth2Login()
		//3시간동안안됨 이유가 뭔가 트러블 슈팅
		.redirectionEndpoint()
        .baseUri("/login/oauth2/code/google") // 기본 리디렉션 URI 설정
        .and()
		.loginPage("/user/login") // 로그인 페이지 URL
		.successHandler( GoogleSuccessHandler() )
		 .userInfoEndpoint()  //OAuth2 로그인 성공 후 가져올 설정들
         .userService(oAuthDetailsService);  // 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시
		
		http.rememberMe()
		.key("cep") //리멤버미를 쿠키로 동작시키는데 그때, 쿠키에 저장되는 토큰값을 만들 비밀키
		.tokenValiditySeconds(604800) //1주일 동안 유효한 토큰
		.rememberMeParameter("remember-me") //화면에서 전달되는 checkbox 파라미터 값
		.userDetailsService(myUserDetails) //리멤버미 토큰이 있을때 실행시킬 로그인시도 서비스
		.authenticationSuccessHandler(authenticationSuccessHandler()); 
//		.and()
//		.addFilter(new CustomLoginFilter(authenticationManager));
		


		return http.build();
	}
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new	CustomSuccessHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler GoogleSuccessHandler() {
		return new	com.project.cep.handler.account.GoogleSuccessHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomRememberMeHandler();
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
