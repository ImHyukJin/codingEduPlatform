package com.project.cep.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerVO {

	private Integer a_no;
	private Integer q_no;
	private String a_context;
	private String a_date;
	private String user_id;
	private String a_count;
	
}
