package cn.anwuli.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.anwuli.bean.Word;
import cn.anwuli.db.DBAccess;

public class WordDao {
	public static List<Word> queryWords() {
		DBAccess dBAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Word> result = new ArrayList<Word>();
		try {
			sqlSession = dBAccess.getSqlSession();
			//通过SqlSession执行SQL语句
			result = sqlSession.selectList("Word.queryWords");
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
	
	public static List<Word> queryCollectedWords(int userId) {
		DBAccess dBAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Word> result = new ArrayList<Word>();
		try {
			sqlSession = dBAccess.getSqlSession();
			//通过SqlSession执行SQL语句
			result = sqlSession.selectList("Word.queryCollectedWords", userId);
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
	
	public static void addCollectionWord(Map<String, Integer> map) {
		DBAccess dBAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dBAccess.getSqlSession();
			//通过SqlSession执行SQL语句
			sqlSession.insert("Word.addCollectionWord", map);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	public static void main(String[] args) {
		List<Word> list = WordDao.queryCollectedWords(1);
		
		System.out.println(list);
	}
}
