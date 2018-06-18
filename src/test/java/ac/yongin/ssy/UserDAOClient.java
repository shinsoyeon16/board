package ac.yongin.ssy;

import ac.yongin.ssy.user.dao.UserDAO;
import ac.yongin.ssy.user.vo.UserVO;

public class UserDAOClient {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		
		vo.setId("user1");
		vo.setPassword("user1");
		UserVO uvo = dao.getUser(vo);
		System.out.println(uvo);
		
		vo.setId("user1");
		vo.setPassword("1111");
		uvo = dao.getUser(vo);
		System.out.println(uvo);
	}
		
}
