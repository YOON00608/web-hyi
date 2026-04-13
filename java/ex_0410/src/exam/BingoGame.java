// BingoGame.java
package exam;

import java.util.Scanner;

public class BingoGame {

    private Bingo board;   // Bingo 객체 필드
    private Scanner sc;    // Scanner 객체 필드

    public BingoGame() {
        board = new Bingo();            // 생성자에서 빙고판 생성
        sc = new Scanner(System.in);    // 입력 도구 생성
    }

    public void start() {
        System.out.println("빙고 게임을 시작합니다.");

        while (true) {
            // 1단계: 현재 빙고판 출력
            board.printBoard();

            // 1-1단계: 현재 빙고 개수 출력
            int bingoCount = board.countBingo();
            System.out.println("현재 빙고 개수 : " + bingoCount + "개");

            // 1-2단계: 3빙고 달성 시 게임 종료
            if (bingoCount >= 3) {
                System.out.println("3빙고 완성! 게임 종료");
                break; // while 루프 탈출
            }

            // 2단계: 숫자 입력받기
            System.out.print("숫자를 입력하세요 : ");
            int num = sc.nextInt();

            boolean result = board.markNumber(num);

            // 3~4단계: 숫자 존재 여부에 따라 메시지 출력
            if (result) {
                System.out.println(num + "를 체크했습니다.");
            } else {
                System.out.println("빙고판에 없는 숫자입니다.");
            }
        }
    }
}