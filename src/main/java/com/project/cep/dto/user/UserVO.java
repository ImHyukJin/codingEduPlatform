package com.project.cep.dto.user;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@lombok.Builder
@Builder
public class UserVO {
	private String user_id;
	private String user_pw;
	private String role;
	private String user_nm;
	private int user_age;
	private String user_gn;
	private String user_pn;
	private String parn_pn;
	
}
