package com.project.cep.service.admin;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.cep.dto.admin.AdminVO;
import com.project.cep.repository.admin.AdminMapper;

import java.util.List;

@Service("AdminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper adminMapper;
    @Override
    public void insertInformation(String con_nm,
                                  String cate_no,
                                  Integer con_price,
                                  Integer con_discount,
                                  String con_description,
                                  String con_lv,
                                  String thumbnail,
                                  String thumbnail_path,
                                  String service_class) {
        adminMapper.insertInformation(con_nm,
                cate_no,
                con_price,
                con_discount,
                con_description,
                con_lv,
                thumbnail,
                thumbnail_path,
                service_class);
    }

    @Override
    public void insertInformation2(
            String con_nm,
            String file_nm,
            String file_path,
            String service_class1
    ) {
        adminMapper.insertInformation2(con_nm,file_nm,file_path,service_class1);
    }

    @Override
    public AdminVO getT(String con_nm) {

        return adminMapper.getT(con_nm);
    }

    @Override
    public List<AdminVO> getF(String con_nm) {
        return adminMapper.getF(con_nm);
    }

    @Override
    public List<AdminVO> getContent() {
       return adminMapper.getContent();
    }

    @Override
    public void deleteContent(String con_nm) {
        adminMapper.deleteContent(con_nm);
        adminMapper.deleteContent_file(con_nm);
    }

}
