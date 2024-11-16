package com.project.cep.repository.student;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.cep.dto.edu.group.GroupAnswerVO;
import com.project.cep.dto.edu.group.GroupNoticeVO;
import com.project.cep.dto.edu.group.GroupQAVO;
import com.project.cep.dto.edu.group.GroupSearchVO;
import com.project.cep.dto.edu.group.GroupVO;
import com.project.cep.dto.edu.group.JoinGroupVO;
import com.project.cep.service.edu.ShowCriteria;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface StudentMapper {
    ArrayList<GroupVO> allGroupSelect(@Param("cri") ShowCriteria cri, @Param("search") GroupSearchVO searchVO);
    ArrayList<JoinGroupVO> myApplyGroup(String userId);


    int selectGroupPageTotal(GroupSearchVO searchVO);
    void groupApply(JoinGroupVO vo);
    int groupAplyTotal(JoinGroupVO vo);
    int groupAplyCheck(JoinGroupVO vo);

    int groupMaxAplyCheck(String userId);

    int deleteAply(JoinGroupVO vo);

    ArrayList<GroupNoticeVO> getNoticeList(String sgNo);
    ArrayList<GroupNoticeVO> getRecordNoticeList(String sgNo);

    ArrayList<GroupQAVO> getQuestionList(String sgNo);
    GroupNoticeVO getNoticeDetail(String ngNo);
    int noticeRegist(GroupNoticeVO vo);
    int noticeUpdate(GroupNoticeVO vo);
    int noticeDelete(GroupNoticeVO vo);

    int QARegist(GroupQAVO vo);
    int QDel(GroupQAVO vo);
    int ADel(GroupQAVO vo);
    GroupQAVO getQADetail(String qgNo);

    ArrayList<GroupAnswerVO> getAnswerList(String qgNo);

    int registAnswer(GroupAnswerVO vo);

    int answerDelete(Integer agNo);

    GroupVO myGroupContent(String sgNo);

    int buyContentCheck(JoinGroupVO vo);




}
