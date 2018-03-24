package cn.anwuli.service;

import java.util.List;

import cn.anwuli.bean.Word;
import cn.anwuli.dao.WordDao;

public class WordService {
	//返回单词列表
	public List<Word> queryWords() {
		return WordDao.queryWords();
	}
}
