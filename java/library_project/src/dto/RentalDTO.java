package dto;

public class RentalDTO {
	
	private int rental_id;
	private int customer_id;
	private int book_id;
	private String rental_date;
	
	public RentalDTO () {}
	
	public RentalDTO (int rental_id,int customer_id,int book_id,String rental_date) {
		this.rental_id = rental_id;
		this.customer_id = customer_id;
		this.book_id = book_id;
		this.rental_date = rental_date;
	}

	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getRental_date() {
		return rental_date;
	}

	public void setRental_date(String rental_date) {
		this.rental_date = rental_date;
	}

}
