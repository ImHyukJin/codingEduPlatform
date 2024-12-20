package com.project.cep.dto.work;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkVO {
    private Integer h_no;
    private String h_name;
    private String h_detail1;
    private String h_detail2;
    private String h_detail3;
    private String h_level;
    private String h_reg_ymd;
    private String h_dead;
    private String h_ans1;
    private String h_ans2;
    private String h_para1;
    private String h_para2;
    private String h_test1;
    private String h_test2;
    private String h_test3;
    private String h_test4;
    private String h_return;
    private String sg_no; //fk
    private String sg_name;

}
