package ex3_bytestream.exam;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LoginExample {
	public static void main(String[] args) {
        try {
            // 1. 파일 읽기
            FileInputStream fis = new FileInputStream("member.txt");
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            fis.close();

            // 2. 줄바꿈 기준으로 id, 비밀번호 분리
            String content = new String(bytes);
            String[] lines = content.split("\n");
            String fileId = lines[0].trim();
            String filePw = lines[1].trim();

            // 3. 사용자 입력 받기
            Scanner sc = new Scanner(System.in);
            System.out.print("아이디: ");
            String inputId = sc.nextLine();
            System.out.print("비밀번호: ");
            String inputPw = sc.nextLine();

            // 4. 비교 후 결과 출력
            if (fileId.equals(inputId) && filePw.equals(inputPw)) {
                System.out.println("로그인 성공");
            } else {
                System.out.println("로그인 실패");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
