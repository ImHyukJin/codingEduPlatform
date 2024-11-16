package com.project.cep.dto.edu.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupAnswerVO {
    private Integer ag_no;
    private Integer qg_no;
    private String user_id;
    private String ag_content;
    private String ag_date;
}
