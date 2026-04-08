package ex1_generic.exam6;

public class ApiResponse<T> {
	int statusCode;
	T body;
	
	public ApiResponse(int statusCode,T body) {
		this.statusCode = statusCode;
		this.body = body;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public T getBody() {
		return body;
	}
}
