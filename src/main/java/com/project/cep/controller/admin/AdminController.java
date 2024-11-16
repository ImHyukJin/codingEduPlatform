package com.project.cep.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.cep.dto.admin.AdminVO;
import com.project.cep.dto.user.review.ReviewVO;
import com.project.cep.security.MyUserDetails;
import com.project.cep.service.admin.AdminService;
import com.project.cep.service.user.review.ReviewService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("AdminService")
    AdminService adminService;
    @Autowired
    @Qualifier("ReviewService")
    ReviewService reviewService;

    @GetMapping("/test")
    public String test(){

        return "test";
    }
    @GetMapping("/conMa")
    public String conMa(Model model){
        List<AdminVO> list = adminService.getContent();

        model.addAttribute("list",list);
        return "user/content";
    }
    @PostMapping("/content")
    public String content(Model model, @RequestParam("content_name")String con_nm, Authentication auth) {

        AdminVO T = adminService.getT(con_nm);

        List<AdminVO> F = adminService.getF(con_nm);

        List<ReviewVO> reviewList = reviewService.getReview(con_nm);
        String what ="";
        if (auth != null){
            MyUserDetails myuser = (MyUserDetails) auth.getPrincipal();
            what = myuser.getUsername();
        } else {
            what = null;
        }
        if(!reviewList.isEmpty()) {
            int total = 0;
            int totalstar = 0;
            for (ReviewVO i : reviewList) {
                int star1 = i.getStar();
                totalstar += star1;
            }
            total = totalstar / reviewList.size();
            //리뷰 평점
            model.addAttribute("star", total);
        }

        model.addAttribute("review",reviewList);

        model.addAttribute("content",T);
        model.addAttribute("content_list", F);
        model.addAttribute("myuser", what);

        return "user/user_content";
    }
    @PostMapping("/reviewSave")
    public String reviewSace(Model model,@RequestParam("content_name")String con_nm,
                             @RequestParam("textarea")String review_context,
                             @RequestParam("reviewStar")int star,
                             @RequestParam("user_id")String user_id,
                             Authentication auth){
        //리뷰 저장
        reviewService.inputReview(con_nm,star,review_context,user_id);
        //모든 리뷰 가져오기
        List<ReviewVO> reviewList = reviewService.getReview(con_nm);
        //컨텐츠 가져오기
        AdminVO T = adminService.getT(con_nm);
        List<AdminVO> F = adminService.getF(con_nm);

        String what ="";
        if (auth != null){
            MyUserDetails myuser = (MyUserDetails) auth.getPrincipal();
            what = myuser.getUsername();
        } else {
            what = null;
        }
        if(!reviewList.isEmpty()) {
            int total = 0;
            int totalstar = 0;
            for (ReviewVO i : reviewList) {
                int star1 = i.getStar();
                totalstar += star1;
            }
            total = totalstar / reviewList.size();
            //리뷰 평점
            model.addAttribute("star", total);
        }
        model.addAttribute("review",reviewList);
        model.addAttribute("content",T);
        model.addAttribute("content_list", F);

        model.addAttribute("myuser", what);

        return "user/user_content";

    }
    @GetMapping("/video")
    public String video(Model model,@RequestParam("src") String src){
        model.addAttribute("src",src);
        return "user/video";
    }
    @GetMapping("/FAQ")
    public String FAQ(){
        return "admin/FAQ";
    }
    @GetMapping("/Q&A")
    public String QA(){
        return "admin/Q&A";
    }


}
