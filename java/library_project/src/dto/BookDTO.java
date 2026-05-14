package dto;

public class BookDTO {

	private int book_id;
	private String title;
	private String author;
	private int stock;

	public BookDTO() {
	}

	public BookDTO(String title, String author, int stock) {
		this.title = title;
		this.author = author;
		this.stock = stock;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
