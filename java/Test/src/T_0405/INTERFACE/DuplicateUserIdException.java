package T_0405.INTERFACE;

public class DuplicateUserIdException extends RuntimeException {
	public DuplicateUserIdException(String meString) {
		super(meString);
	}
}
