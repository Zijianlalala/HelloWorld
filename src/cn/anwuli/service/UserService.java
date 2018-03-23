package cn.anwuli.service;

import cn.anwuli.bean.User;
import cn.anwuli.dao.UserDao;

/**
 * 关于用户的业务层
 * @author wuzijian
 *
 */
public class UserService {
	//登录查询用户名和密码
	public User queryUser(String username, String password) {
		User user = new User();
		user = UserDao.queryUser(username, password);
		return user;
	}
//	//查找用户信息
//	public User queryUserByName(String username) {
//		User user = new User();
//		user = UserDao.queryUserByName(username);
//		return user;
//	}
	//修改用户信息
	public User updateInfo(String username,String password, String nickname) {
		User user = new User();
		user.setNickname(nickname);
		user.setPassword(password);
		user.setUsername(username);
		return UserDao.updateInfo(user)==1?user:null;
	}
}
