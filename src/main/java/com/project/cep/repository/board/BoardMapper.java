package com.project.cep.repository.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.cep.dto.board.AnswerVO;
import com.project.cep.dto.board.QuestionVO;
import com.project.cep.service.board.WritingCriteria;


@Mapper
public interface BoardMapper {
	public int boardRegi(QuestionVO vo);
	public ArrayList<QuestionVO> questionList(@Param("cri") WritingCriteria cri, @Param("questionSearch") String questionSearch, @Param("status") String status);
	int getBoardPageTotal(@Param("questionSearch") String questionSearch, @Param("status") String status);
	QuestionVO getboardDetail(QuestionVO vo);
	ArrayList<AnswerVO> getAnswerList(QuestionVO vo);
	int QuestionUpdateReal(QuestionVO vo);
	int delQuestion(QuestionVO vo);
	int registAnswer(AnswerVO vo);
	int delAnswer(AnswerVO vo);
	int delQuestionAnswer(QuestionVO vo);
}
