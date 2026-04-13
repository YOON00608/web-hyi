package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Bingo {

    private int[][] bingo = new int[5][5]; // 클래스 멤버변수로 선언

    public Bingo() {
        createBoard();
    }

    // 빙고판 생성 (중복 없는 숫자 25개로 채우기)
    private void createBoard() {
        HashSet<Integer> set = new HashSet<>();

        while (set.size() != 25) {
            set.add((int)(Math.random() * 50) + 1);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.shuffle(list);

        Iterator<Integer> iter = list.iterator();

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo[i].length; j++) {
                bingo[i][j] = iter.next();
            }
        }
    }

    // 숫자 체크 메서드 - 존재하면 0으로 바꾸고 true, 없으면 false 반환
    public boolean markNumber(int number) {
        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo[i].length; j++) {
                if (bingo[i][j] == number) {
                    bingo[i][j] = 0; // 체크된 칸은 0으로 표시
                    return true;
                }
            }
        }
        return false;
    }

    // 빙고판 출력 메서드 - 체크된 칸은 X로 출력
    public void printBoard() {
        System.out.println("=== 현재 빙고판 ===");
        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo[i].length; j++) {
                if (bingo[i][j] == 0) {
                    System.out.print("  X"); 
                } else {
                    System.out.printf(" %02d", bingo[i][j]);
                }
            }
            System.out.println();
        }
    }

    // 완성된 빙고 줄 수 계산 메서드
    public int countBingo() {
        int count = 0;

        // 가로 검사 (5줄)
        for (int i = 0; i < bingo.length; i++) {
            boolean isLine = true; // 일단 빙고라고 가정하고 시작
            for (int j = 0; j < bingo[i].length; j++) {
                if (bingo[i][j] != 0) { // 0이 아닌 칸 발견 시 빙고 아님
                    isLine = false;
                }
            }
            if (isLine) count++;
        }

        // 세로 검사 (5줄) - 가로와 i, j 역할만 바뀜
        for (int j = 0; j < bingo[0].length; j++) {
            boolean isLine = true;
            for (int i = 0; i < bingo.length; i++) {
                if (bingo[i][j] != 0) {
                    isLine = false;
                }
            }
            if (isLine) count++;
        }

        // 대각선 검사 (2줄)
        boolean diag1 = true; // 왼쪽 위 → 오른쪽 아래 (i == j)
        boolean diag2 = true; // 오른쪽 위 → 왼쪽 아래 (i + j == 4)
        
        for (int i = 0; i < bingo.length; i++) {
            if (bingo[i][i] != 0)     diag1 = false;
            if (bingo[i][4 - i] != 0) diag2 = false;
        }
        if (diag1) count++;
        if (diag2) count++;

        return count;
    }
}