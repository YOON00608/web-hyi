package dto;

public class CustomerDTO {
	private int customer_id;
	private String name;
	private String phone;
	
	public CustomerDTO () {}
	
	public CustomerDTO (String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return customer_id;
	}

	public void setId(int id) {
		this.customer_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
