package ac.yongin.ssy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ac.yongin.ssy.user.dao.UserDAO;
import ac.yongin.ssy.user.vo.UserVO;

public class LoginController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//유효성 검사
		if (id.isEmpty() || password.isEmpty()) {
			request.setAttribute("result", "모든 항목을 입력해주세요.");
			HttpUtil.forward(request, response, "login.jsp");
			return;
		}
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserVO dvo = dao.getUser(vo);
		//회원정보가 DB에 없을 때
		if (dvo == null) {
			request.setAttribute("result", "정확한 회원정보를 입력해주세요");
			HttpUtil.forward(request, response, "login.jsp");
			return;
		}
		
		//로그인 성공
		HttpSession session = request.getSession();
		session.setAttribute("login", dvo);
		HttpUtil.forward(request, response, "getBoardList.do");
	}
}
