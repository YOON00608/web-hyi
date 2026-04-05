package T_0405.INTERFACE;

public class JoinService {
	private String[] existingIds = {"admin", "user01", "java"};
	
	public void register(String newId) throws DuplicateUserIdException {
		for(String id : existingIds) {
			if(id.equals(newId)) {
				throw new DuplicateUserIdException("이미 사용 중인 아이디입니다. " + newId);
			}
		}
		System.out.println(newId + "님, 가입을 축하합니다!");
	}
	
}
