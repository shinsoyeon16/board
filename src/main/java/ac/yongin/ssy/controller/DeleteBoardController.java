package ac.yongin.ssy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ac.yongin.ssy.board.dao.BoardDAO;
import ac.yongin.ssy.board.vo.BoardVO;

public class DeleteBoardController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(vo);
		
		request.setAttribute("result", "게시글 삭제가 완료되었습니다.");
		HttpUtil.forward(request, response, "getBoardList.do");
	}
}
