package array;

import java.util.*;

public class StringArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strings = {"abce", "abcd", "cdx"};
		String[] strings2 = {"sun", "bed", "car"};
		int n = 2;
		
		System.out.println(Arrays.toString(solution(strings, n)));
		System.out.println(Arrays.toString(solution(strings2, 1)));
		

	}

	private static String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (String a, String b) -> {		
			if(a.charAt(n) == b.charAt(n)) {
				return a.compareTo(b);
			} else {
				return Character.compare(a.charAt(n), b.charAt(n));
			}
		});
		return strings;
	}

}
