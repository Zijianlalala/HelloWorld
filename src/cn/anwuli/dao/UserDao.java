package cn.anwuli.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.anwuli.bean.User;
import cn.anwuli.db.DBAccess;

public class UserDao {
	/**
	 * 查询某个命令以及其对应的内容的所有信息
	 */
	public static User queryUser(String usernam, String password) {
		DBAccess dBAccess = new DBAccess();
		SqlSession sqlSession = null;
		User result = null;
		try {
			sqlSession = dBAccess.getSqlSession();
			//通过SqlSession执行SQL语句
			User user = new User();
			user.setUsername(usernam);
			user.setPassword(password);
			result = sqlSession.selectOne("User.queryUser",user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}
//	public static User queryUserByName(String usernam) {
//		DBAccess dBAccess = new DBAccess();
//		SqlSession sqlSession = null;
//		User result = null;
//		try {
//			sqlSession = dBAccess.getSqlSession();
//			//通过SqlSession执行SQL语句
//			User user = new User();
//			user.setUsername(usernam);
//			result = sqlSession.selectOne("User.queryUserByName",user);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if(sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//		return result;
//	}
	
	public static int updateInfo(User user) {
		DBAccess dBAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dBAccess.getSqlSession();
			//通过SqlSession执行SQL语句
			result = sqlSession.update("User.updateInfo",user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setNickname("1111111");
		user.setPassword("123456");
		user.setUsername("wuzijian");
		int i = UserDao.updateInfo(user);
		System.out.println(i);
	}
}
