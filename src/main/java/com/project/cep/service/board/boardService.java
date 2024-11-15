package com.project.cep.service.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.project.cep.dto.board.AnswerVO;
import com.project.cep.dto.board.QuestionVO;

public interface boardService {
	public int boardRegi(QuestionVO vo);
	public ArrayList<QuestionVO> questionList(Criteria cri, String questionSearch, String status);
	int getBoardPageTotal(String questionSearch, String status);
	QuestionVO getboardDetail(QuestionVO vo);
	ArrayList<AnswerVO> getAnswerList(QuestionVO vo);
	int QuestionUpdateReal(QuestionVO vo);
	int delQuestion(QuestionVO vo);
	int registAnswer(AnswerVO vo);
	int delAnswer(AnswerVO vo);
	int delQuestionAnswer(QuestionVO vo);
}
