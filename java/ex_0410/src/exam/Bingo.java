package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bingo {
	public static void main(String[] args) {
		
		// 1 ~ 50 사이의 난수가 있다.
		// 25개의 숫자를 채운다.
		// 겹치면 안 된다.
		Set<Integer> set = new HashSet<>(); // 겹치면 안 됨
		
		while(set.size() < 25) {
			int random = (int)(Math.random()*50) +1;  
			set.add(random);
		}
		
		// 만약 숫자가 오름차순으로 연속되게 나오면 섞어준다.
		List<Integer> list  = new ArrayList<>(set); // shuffle 에 넣기 전에 리스트에 넣기
		Collections.shuffle(list);
		
		// 빙고판 만드는 곳
		int[][] bingo = new int[5][5];
		int index = 0;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = list.get(index++);
			}
		}
		System.out.println("  --- 5 x 5 빙고판 ---");
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.printf("%4d", bingo[i][j]);
			}
			System.out.println();
		}
	}
}

