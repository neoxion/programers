package heap;

import java.util.*;

public class Scoville {

	static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int s : scoville) pq.add(s);
                        
        while(pq.peek() <= K) {
        	if(pq.size() < 2) return -1;
        	int f = pq.poll();
        	int s = pq.poll();
        	
        	int n = f + s*2;
        	
        	pq.add(n);
        	
        	answer++;
        }
                
        return answer;
    }
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
		
		int[] scoville = {1, 2, 3, 9, 10, 12}; 
		
		System.out.println(solution(scoville, 700000000));

	}

}
