package ch06.exam12;

public class Board {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private boolean open;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) { // 데이터 무결성 검사를 위해 실시
		if(bno < 0) bno = 0;
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
}
