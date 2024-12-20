package com.project.cep.service.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.cep.dto.edu.group.GroupSearchVO;
import com.project.cep.dto.edu.group.GroupVO;
import com.project.cep.dto.work.WorkVO;
import com.project.cep.repository.work.WorkMapper;

import java.util.ArrayList;

@Service("workService")
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkMapper workMapper;

    @Override
    public ArrayList<WorkVO> getList(AmountCriteria cri, String user_id) {

        ArrayList<WorkVO> al = workMapper.getList(cri, user_id);
        return al;
    }
    @Override
    public ArrayList<WorkVO> getList2(AmountCriteria cri, String user_id) {

        ArrayList<WorkVO> al = workMapper.getList2(cri, user_id);
        System.out.println(al.toString());
        System.out.println("--------------------");
        return al;
    } @Override
    public ArrayList<WorkVO> getList3(AmountCriteria cri, String user_id) {

        ArrayList<WorkVO> al = workMapper.getList3(cri, user_id);
        return al;
    }
    @Override
    public ArrayList<GroupVO> selectGroup(GroupVO vo, GroupSearchVO gsvo) {
        return workMapper.selectGroup(vo, gsvo);
    }
    @Override
    public int getTotal(AmountCriteria cri, String h_no) {
        return workMapper.getTotal(cri, h_no);
    }
    @Override
    public int getTotal2(AmountCriteria cri, String h_no) {
        return workMapper.getTotal2(cri, h_no);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int regist(WorkVO vo) {

        int result = workMapper.regist(vo); //

        System.out.println("실행됩니다");
        System.out.println(result);
        return result;
    }


    public int insertHw(String h_no,String sg_no){
        return workMapper.insertHw(h_no,sg_no);
    }
    public WorkVO getDetail(int h_no) {
        return workMapper.getDetail(h_no);
    }
    @Override
    public void delete(int h_no) {
        workMapper.delete(h_no);
    }

}
