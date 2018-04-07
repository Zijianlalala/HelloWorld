package cn.anwuli.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.anwuli.bean.Word;
import cn.anwuli.dao.WordDao;
import cn.anwuli.util.ObjectToString;

public class WordService {
	//返回单词列表
	public String queryWords(int userId) {
		List<Word> allWords = WordDao.queryWords();
		List<Word> collectedWords = WordDao.queryCollectedWords(userId);
		for(int i = 0; i < allWords.size(); i++) {
			for(int j = 0; j < collectedWords.size(); j++) {
				if(allWords.get(i).getId() == collectedWords.get(j).getId()) {
					allWords.get(i).setCollected(true);
				}
			}
		}
		return ObjectToString.toString(allWords);
	}
	//返回收藏列表
	public List<Word> queryCollection(int userId) {
		List<Word> list = new ArrayList<>();
		list = WordDao.queryCollectedWords(userId);
		return list;
	}
	
	public void addCollectionWord(String wordId, int userId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("wordID", Integer.parseInt(wordId));
		map.put("userID", userId);
		WordDao.addCollectionWord(map);
	}
	public static void main(String[] args) {
		WordService service = new WordService();
//		service.addCollectionWord(2+"", 2);
		System.out.println(service.queryCollection(1));
	}
	
	
}
