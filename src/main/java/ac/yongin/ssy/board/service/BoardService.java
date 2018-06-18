package ac.yongin.ssy.board.service;

import java.util.ArrayList;

import ac.yongin.ssy.board.vo.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	BoardVO getBoard(BoardVO vo);

	ArrayList<BoardVO> getBoardList(BoardVO vo);

}