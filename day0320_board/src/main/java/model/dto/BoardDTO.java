package model.dto;

public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String writeDate;
	private int readCount;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public BoardDTO() {}
	
	public BoardDTO(String title, String content, String writer, String writeDate, int readCount) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.readCount = readCount;
	}

	public BoardDTO(int bno, String title, String content, String writer, String writeDate, int readCount) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.readCount = readCount;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
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

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", writeDate=" + writeDate + ", readCount=" + readCount + "]";
	}
	
	
}
