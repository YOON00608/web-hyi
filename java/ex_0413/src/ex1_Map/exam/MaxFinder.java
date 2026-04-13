package ex1_Map.exam;

import java.util.HashMap;
import java.util.Map;

public class MaxFinder {
	public static void main(String[] args) {
		
		int[] arr = {1,3,2,3,4,3,2,2,2};
		Map<Integer,Integer> map = new HashMap<>();
		
		//- 숫자별 등장 횟수를 HashMap<Integer,Integer>로 센다.
		// 가장 큰 빈도수를 가진 숫자를 찾는다.
		for(int num : arr) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}else {
				map.put(num, 1);
			}
		}
		
		int maxCount = 0;
		int maxNum = 0;
		
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			if(entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxNum = entry.getKey();
			}
		}
		
		System.out.println("가장 많이 등장한 숫자 : " + maxNum + " / " + maxCount + "번");
	}
}
