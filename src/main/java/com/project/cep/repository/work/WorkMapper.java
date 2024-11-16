package com.project.cep.repository.work;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.cep.dto.edu.group.GroupSearchVO;
import com.project.cep.dto.edu.group.GroupVO;
import com.project.cep.dto.work.WorkVO;
import com.project.cep.service.work.AmountCriteria;

import java.util.ArrayList;

@Mapper
public interface WorkMapper {
    public ArrayList<WorkVO> getList(@Param("cri") AmountCriteria cri, @Param("user_id") String user_id);
    public ArrayList<WorkVO> getList2(@Param("cri") AmountCriteria cri, @Param("user_id") String user_id);
    public ArrayList<WorkVO> getList3(@Param("cri") AmountCriteria cri, @Param("user_id") String user_id);
    public int getTotal(@Param("cri") AmountCriteria cri, @Param("user_id") String user_id); //전체게시글 수
    public int getTotal2(@Param("cri") AmountCriteria cri, @Param("user_id") String user_id); //전체게시글 수
    ArrayList<GroupVO> selectGroup(@Param("gvo") GroupVO gvo, @Param("gsvo") GroupSearchVO gsvo);
    public int regist(WorkVO vo);
    public int insertHw(@Param("h_no")String h_no,@Param("sg_no")String sg_no);
    public WorkVO getDetail(int h_no);
    public void delete(int h_no);
    public WorkVO getHomework(String h_no);

}
