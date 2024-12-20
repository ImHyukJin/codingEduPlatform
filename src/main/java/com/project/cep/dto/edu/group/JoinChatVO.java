package com.project.cep.dto.edu.group;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoinChatVO {
    //join_chat
    private String user_id;
    private String user_nm;
    private String rc_no;
    private Integer sg_no;
    private String jc_status;

    //room_chat
    private Integer rc_num;
    private String rc_title;
    private String rc_usage;
}
