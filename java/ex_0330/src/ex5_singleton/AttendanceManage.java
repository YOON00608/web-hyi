package ex5_singleton;

public class AttendanceManage {
	
	private static AttendanceManage instance = new AttendanceManage();
	private int count;
	
	private AttendanceManage() {
		count = 0;
	}
	
	public static AttendanceManage getInstance() {
		return instance;
	}
	
	public void addAttendance() {
		count++;
	}
	
	public int getAttendance() {
		return count;
	}
	
}
