package array;

import java.util.*;

public class Snail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] snail1 = {
				{1,   2,  3,  4, 5},
				{16, 17, 18, 19, 6},
				{15, 24, 25, 20, 7},
				{14, 23, 22, 21, 8},
				{13, 12, 11, 10, 9}};
		int[][] snail2 = {
				{1,   2,  3,  4, 5, 0},
				{16, 17, 18, 19, 6, 0},
				{15, 24, 25, 20, 7, 0},
				{14, 23, 22, 21, 8, 0},
				{13, 12, 11, 10, 9, 0},
				{131, 122, 113, 104, 95, 6}
				};
		
		System.out.println(Arrays.toString(solution(snail1)));
		System.out.println(Arrays.toString(solution(snail2)));

	}

	private static int[] solution(int[][] snail) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		int len = snail.length;
		int K = len * len;
		
		
		int x = 0;
		int y = 0;
		
		while(answer.size() < K) {
			
			for(int i = 0; i < len; i++) {
				answer.add(snail[x][y]);
				y++;
			}
			
			x++;
			y--;
			len--;
			
			for(int i = 0; i < len; i++) {
				answer.add(snail[x][y]);
				x++;
			}
						
			x--;
			y--;
			
			for(int i = 0; i < len; i++) {
				answer.add(snail[x][y]);
				y--;
			}
			
			x--;
			y++;
			len--;
			
			
			for(int i = 0; i < len; i++) {
				answer.add(snail[x][y]);
				x--;
			}
			
			x++;
			y++;
		};
		
		
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

}
