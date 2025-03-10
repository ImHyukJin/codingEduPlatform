
package com.project.cep.controller.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.cep.dto.board.AnswerVO;
import com.project.cep.dto.board.BoardPageVO;
import com.project.cep.dto.board.QuestionVO;
import com.project.cep.dto.board.RegistEduVO;
import com.project.cep.service.board.BoardServiceImpl;
import com.project.cep.service.board.WritingCriteria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/board")
public class boardController {

	@Autowired
	@Qualifier("boardService")
	private BoardServiceImpl boardService;
	
	@GetMapping("/list")
	public String list(Model model, WritingCriteria cri, @RequestParam(value = "questionSearch", required=false) String questionSearch,
					   @RequestParam(value = "status", required=false) String status) {

		if(cri.getCurrentPage() == null || cri.getWriting() == null){
			cri = new WritingCriteria();
		}

		BoardPageVO vo = new BoardPageVO(cri, boardService.getBoardPageTotal(questionSearch, status));
		ArrayList<QuestionVO> questionList = boardService.questionList(cri, questionSearch, status);
		System.out.println(questionList);
		model.addAttribute("questionList",questionList);
		model.addAttribute("pageVO",vo);
		model.addAttribute("search",questionSearch);
		return"board/list";
	}
	@GetMapping("/listDetail")
	public String listDetail(QuestionVO vo, Model model) {
		System.out.println(vo);

		model.addAttribute("qDetail", boardService.getboardDetail(vo));
		model.addAttribute("AnswerList", boardService.getAnswerList(vo));
		System.out.println(boardService.getAnswerList(vo));
		return "board/list_detail";
	}
	
	@GetMapping("/faq_list")
	public String faq_list() {
		return "board/faq_list";
	}
	@GetMapping("/regist_p")
	public String regist_p() {
		return "board/regist_p";
	}
	@GetMapping("/regiPopup")
	public String regiPopup() {
		return "board/regiPopup";
	}
	
	@PostMapping("/regist_educator")
	public String regist_educator(@RequestParam("edu_name") String edu_name, @RequestParam("edu_sub") String edu_sub) {
		System.out.println("edu_name : " + edu_name);
		System.out.println("edu_sub : " + edu_sub);
		return "board/regist_p";
	}
	
	@PostMapping("/regist_educator1")
	public @ResponseBody String  regist_educator1(@RequestBody List<RegistEduVO> vo) {
		for (RegistEduVO experience : vo) {
            System.out.println("Company: " + experience.getCompany());
            System.out.println("Position: " + experience.getPosition());
            System.out.println("Duration: " + experience.getDuration());
        }
		return vo.toString();
	}
	
	@GetMapping("/regiContents")
	public String regiContents() {
		return "board/regiContents";
	}

	@GetMapping("/updateContents")
	public String updateContents(QuestionVO vo, Model model) {

		model.addAttribute("qDetail", boardService.getboardDetail(vo));
		return "board/list_update";
	}
	@PostMapping("/QuestionUpdateReal")
	public String QuestionUpdateReal(QuestionVO vo, RedirectAttributes ra) {
		System.out.println(vo);
		boardService.QuestionUpdateReal(vo);
		ra.addAttribute("q_no", vo.getQ_no());
		return "redirect:/board/listDetail";
	}
///////////////////////////////////////////////////////////
	@PostMapping("/delQuestion")
	public String delQuestion(QuestionVO vo, RedirectAttributes ra) {
	System.out.println(vo);
	boardService.delQuestionAnswer(vo);
	boardService.delQuestion(vo);

	ra.addAttribute("q_no", vo.getQ_no());
	return "redirect:/board/list";
}

	@PostMapping("/registAnswer")
	public String registAnswer(AnswerVO vo, RedirectAttributes ra) {
		System.out.println(vo);
		boardService.registAnswer(vo);
		ra.addAttribute("q_no", vo.getQ_no());
		return "redirect:/board/listDetail";
	}

	@PostMapping("/delAnswer")
	public String delAnswer(AnswerVO vo, RedirectAttributes ra) {
		System.out.println(vo);
		boardService.delAnswer(vo);
		ra.addAttribute("q_no", vo.getQ_no());
		return "redirect:/board/listDetail";
	}



	////////////////////////////////////////////////////////
	@PostMapping("/regist")
	public String regist(QuestionVO vo) {
		int a =boardService.boardRegi(vo);
		if(a ==1) {
			return "redirect:/board/list";
		}else {
			//실행오류로 
			return "";
			
		}
	}
	


}

