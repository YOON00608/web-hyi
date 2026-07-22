package ex_0722.cohension;

public class SystemExitManager {
	public void onSystemExit() {
		saveUserSettings(); // 설정값 저장
		disconnectDatabase();// db연결 종료
		saveUserSettings(); // 임시파일 삭제
	}

	private void disconnectDatabase() {
		System.out.println();
		
	}

	private void saveUserSettings() {
		// TODO Auto-generated method stub
		
	}
}
