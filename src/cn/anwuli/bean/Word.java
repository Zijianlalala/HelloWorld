package cn.anwuli.bean;

public class Word {
	private int id;
	private String content;
	private String translation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	@Override
	public String toString() {
		return "Word [id=" + id + ", content=" + content + ", translation=" + translation + "]";
	}
	
	
}
