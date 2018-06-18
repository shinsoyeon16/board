package ac.yongin.ssy.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.yongin.ssy.board.dao.BoardDAO;
import ac.yongin.ssy.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO dao;
	
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
	}
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}
	public void deleteBoard(BoardVO vo) {
		dao.deleteBoard(vo);
	}
	public BoardVO getBoard(BoardVO vo) {
		return dao.getBoard(vo);
	}
	public ArrayList<BoardVO> getBoardList(BoardVO vo) {
		return dao.getBoardList(vo);
	}
}
