package ac.yongin.ssy.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	HashMap<String, Controller> list = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Controller>();
		list.put("/login.do", new LoginController());
		list.put("/logout.do", new LogoutController());
		list.put("/getBoardList.do", new GetBoardListController());
		list.put("/getBoard.do", new GetBoardController());
		list.put("/updateBoard.do", new UpdateBoardController());
		list.put("/insertBoard.do", new InsertBoardController());
		list.put("/deleteBoard.do", new DeleteBoardController());
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = list.get(path);
		subController.execute(request, response);
	}

}