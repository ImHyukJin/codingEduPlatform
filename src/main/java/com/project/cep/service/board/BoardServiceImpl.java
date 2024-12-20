package com.project.cep.service.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cep.dto.board.AnswerVO;
import com.project.cep.dto.board.QuestionVO;
import com.project.cep.repository.board.BoardMapper;


@Service("boardService")
public class BoardServiceImpl implements boardService {

	@Autowired
	BoardMapper boardMapper ;
	
	@Override
	public int boardRegi(QuestionVO vo) {
		int a = boardMapper.boardRegi(vo);
		return a;
	}

	@Override
	public ArrayList<QuestionVO> questionList(WritingCriteria cri, String questionSearch, String status) {
		ArrayList<QuestionVO> list = boardMapper.questionList(cri, questionSearch, status);
		return list;
	}

	@Override
	public int getBoardPageTotal(String questionSearch, String status) {
		return boardMapper.getBoardPageTotal(questionSearch, status);
	}

	@Override
	public QuestionVO getboardDetail(QuestionVO vo) {
		return boardMapper.getboardDetail(vo);
	}

	@Override
	public ArrayList<AnswerVO> getAnswerList(QuestionVO vo) {
		return boardMapper.getAnswerList(vo);
	}

	@Override
	public int QuestionUpdateReal(QuestionVO vo) {
		return boardMapper.QuestionUpdateReal(vo);
	}

	@Override
	public int delQuestion(QuestionVO vo) {
		return boardMapper.delQuestion(vo);
	}

	@Override
	public int registAnswer(AnswerVO vo) {
		return boardMapper.registAnswer(vo);
	}

	@Override
	public int delAnswer(AnswerVO vo) {
		return boardMapper.delAnswer(vo);
	}

	@Override
	public int delQuestionAnswer(QuestionVO vo) {
		return 0;
	}


}
