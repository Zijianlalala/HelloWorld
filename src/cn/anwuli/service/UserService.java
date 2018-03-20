package cn.anwuli.service;

import cn.anwuli.bean.User;
import cn.anwuli.dao.UserDao;

/**
 * 关于用户的业务层
 * @author wuzijian
 *
 */
public class UserService {
	public User queryUser(String username, String password) {
		User user = new User();
		user = UserDao.queryUser(username, password);
		return user;
	}
}
