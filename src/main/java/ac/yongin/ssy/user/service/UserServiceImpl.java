package ac.yongin.ssy.user.service;

import ac.yongin.ssy.user.dao.UserDAO;
import ac.yongin.ssy.user.vo.UserVO;

public class UserServiceImpl {
	private UserDAO dao;
	
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

}
