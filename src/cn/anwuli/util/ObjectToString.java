package cn.anwuli.util;

import java.util.List;

import com.google.gson.Gson;

import cn.anwuli.bean.Word;

public class ObjectToString {
	public static String toString(List<Word> list) {
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}
}
