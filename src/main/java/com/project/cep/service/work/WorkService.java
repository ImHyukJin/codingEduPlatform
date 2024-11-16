package com.project.cep.service.work;

import org.springframework.web.multipart.MultipartFile;

import com.project.cep.dto.edu.group.GroupSearchVO;
import com.project.cep.dto.edu.group.GroupVO;
import com.project.cep.dto.work.WorkVO;

import java.util.ArrayList;
import java.util.List;

public interface WorkService {
    public ArrayList<WorkVO> getList(AmountCriteria cri, String user_id);
    public ArrayList<WorkVO> getList2(AmountCriteria cri, String user_id);
    public ArrayList<WorkVO> getList3(AmountCriteria cri, String user_id);
    ArrayList<GroupVO> selectGroup(GroupVO vo, GroupSearchVO gsvo);
    public int getTotal(AmountCriteria cri, String user_id);
    public int getTotal2(AmountCriteria cri, String user_id);
    public int regist(WorkVO vo);
    public int insertHw(String h_no,String sg_no);
    public WorkVO getDetail(int h_no);
    public void delete(int h_no);

}
