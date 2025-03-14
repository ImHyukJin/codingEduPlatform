package com.project.cep.repository.edu;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.cep.dto.edu.group.ContentVO;
import com.project.cep.dto.edu.group.GroupSearchVO;
import com.project.cep.dto.edu.group.GroupVO;
import com.project.cep.dto.edu.group.JoinGroupVO;
import com.project.cep.dto.user.account.UserVO;
import com.project.cep.service.edu.ShowCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface EduMapper {
    public void groupRegist(GroupVO vo);
    public void studentApply(JoinGroupVO vo);
    void groupLeaderApply(JoinGroupVO vo);

    int getSgNo();


    //조회 관련
    //학습그룹학습자 조회
    ArrayList<JoinGroupVO> selectStudent(JoinGroupVO vo);
    //학습그룹 조회
    ArrayList<GroupVO> selectGroup(@Param("gvo") GroupVO gvo, @Param("gsvo") GroupSearchVO gsvo);
    //PK로 학습그룹 조회
    ArrayList<GroupVO> selectGroupPK(GroupVO vo);
    //학습그룹 가입승인조회
    ArrayList<JoinGroupVO> myJoinGroup(@Param("cri") ShowCriteria cri, @Param("userId") String userId, @Param("search") GroupSearchVO searchVO );
    //학습자 PK 조회
    ArrayList<UserVO> studentSelect(UserVO vo);

    void groupUpdateReal(GroupVO vo);

    //그룹에서 학습자 방출
    void deleteJoinStud(JoinGroupVO vo);

    void applierApply(@Param("userId") String userId, @Param("sgNo") String sgNo, @Param("jgConfirm") String jgConfirm);
    void groupDelete(String sgNo);
    void joinGroupDelete(String sgNo);


    ////////////////////페이지네이션
    int selectPageTotal(@Param("userId") String userId, @Param("search") GroupSearchVO searchVO);
    int noSearchSelectPageTotal(String userId);

    //////////////////콘텐츠
    //내콘텐츠 조회
    List<ContentVO> selectMyContents(@Param("cri") ShowCriteria cri, @Param("userId") String userId, @Param("search") GroupSearchVO searchVO);
    int contentPageTotal(@Param("userId") String userId, @Param("search") GroupSearchVO searchVO);
}
