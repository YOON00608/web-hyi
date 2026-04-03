package ex2_object.exam;

public class Member {
	
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member target) {
			if(id.equals(target.id)) {
				return true;
			}
		}
		return false;
	}
	
}
