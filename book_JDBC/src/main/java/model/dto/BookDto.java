package model.dto;

public class BookDto {
	private int isbn;
	private String title;
	private String writer;
	private int price;
	
	public BookDto() {};
	
	public BookDto(int isbn, String title, String writer, int price) {
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookDto [isbn=" + isbn + ", title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}
	
	
}
