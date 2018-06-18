package ac.yongin.ssy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ac.yongin.ssy.board.dao.BoardDAO;
import ac.yongin.ssy.board.vo.BoardVO;

public class GetBoardListController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.getBoardList(vo);

		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "getBoardList.jsp");
		return;
	}
}
