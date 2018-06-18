package ac.yongin.ssy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ac.yongin.ssy.board.dao.BoardDAO;
import ac.yongin.ssy.board.vo.BoardVO;

public class GetBoardController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchCondition  = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		if(searchKeyword.isEmpty()) {
			HttpUtil.forward(request, response, "getBoardList.do");
			return;
		}
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		if(searchCondition.equals("title")) {
			list = dao.searchBoard(searchKeyword);
		} else if(searchCondition.equals("content")) {
			list = dao.searchBoard(searchCondition,searchKeyword);
		}
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "getBoardList.jsp");
		return;
		
	}
}
