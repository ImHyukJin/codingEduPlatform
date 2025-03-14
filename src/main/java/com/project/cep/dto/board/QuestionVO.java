package com.project.cep.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionVO {

	private Integer q_no;
	private String q_title;
	private String q_context;
	private String q_date;
	private String status;
	private String user_id;
	private String a_count;
}
