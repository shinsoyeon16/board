package ac.yongin.ssy;

import java.util.ArrayList;

import ac.yongin.ssy.board.dao.BoardDAO;
import ac.yongin.ssy.board.vo.BoardVO;

public class BoardDAOClient {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("ts2");
		vo.setWriter("ts2");
		vo.setContent("tsts");
		dao.insertBoard(vo);
		
		ArrayList<BoardVO> boardList = dao.getBoardList(vo);
		for(int i=0;i<boardList.size();i++) {
			BoardVO bvo = boardList.get(i);
			System.out.println(bvo.getSeq()+bvo.getTitle()+bvo.getWriter()+bvo.getContent()+bvo.getRegDate()+bvo.getCnt());
		}
	}

}
