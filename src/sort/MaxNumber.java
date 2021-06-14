package sort;

import java.util.*;

public class MaxNumber {


	static String solution(int[] numbers) {

        
		String[] numStr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) numStr[i] = String.valueOf(numbers[i]); // numbers[i] + "";
        Arrays.sort(numStr, (a, b) -> {
        	Integer ab = Integer.parseInt(a + b);
        	Integer ba = Integer.parseInt(b + a);
//        	if(ab > ba) {
//        		return 1;
//        	} else if(ba > ab) {
//        		return -1;
//        	}
//        	return 0;
        	return -Integer.compare(ab, ba);
        });
        
        if(numStr[0].equals("0")) return "0";
        
        return String.join("", numStr);
        
        
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] numbers = {3, 30, 34, 0, 9};
		int[] numbers = {0, 0, 0, 0};
		
		System.out.println(solution(numbers));

	}

}
