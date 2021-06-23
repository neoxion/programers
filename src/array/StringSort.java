package array;

import java.util.*;

public class StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.out.println(solution("Zbcdefg"));
	}

	private static String solution(String string) {
		String answer = "";
		
//		char[] arr = string.toCharArray();
		String[] arr = string.split("");
		
		Arrays.sort(arr, Collections.reverseOrder());
		
//		for(int i = arr.length - 1; i >= 0; i--) {
//			answer += arr[i];
//		}
		for(String s : arr) answer += s;
		
		return answer;
	}

}
