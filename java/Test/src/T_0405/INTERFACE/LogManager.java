package T_0405.INTERFACE;

import java.io.FileWriter;
import java.io.IOException;

public class LogManager {
	
	public void saveLog(String message) {
		try (FileWriter writer = new FileWriter("log.txt",true)) {
			writer.write(message + "\n");
		} catch (IOException e) {
			System.out.println("로그 저장 실패 : " + e.getMessage());
		}
	}
	
}
