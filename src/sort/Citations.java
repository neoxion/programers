package sort;

import java.util.Arrays;

public class Citations {

	
	static int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int n = citations.length;
        
        
        // {0, 1, 3, 5, 6}
        
        
        for(int i = 0; i < n; i++) {
        	int c = citations[i];
        	int h = n - i;
        	// 0 vs. 5
        	// 1 vs. 4
        	// 3 vs. 3
        	// 5 vs. 2
        	// 6 vs. 1
        	
        	if(c >= h) {
        		return h;
        	}
        	
        	
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3, 0, 6, 1, 5};
		
		System.out.println(solution(citations));

	}

}
