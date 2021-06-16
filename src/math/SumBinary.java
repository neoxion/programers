package math;
import java.util.*;

public class SumBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String a = "1010101001";
//		String b = "11010";
		
//		String a = "1101", b="100";
		String a = "110100000000111011011100101010101", b="100101010101010010101101110110010100111010111010111001110101010000101100010101110";
		System.out.println(solution(a, b));
		System.out.println(solutionByList(a, b));
		System.out.println(solution(a, b).equals(solutionByList(a, b)));

	}

	private static String solution(String a, String b) {
		// TODO Auto-generated method stub
		String answer = "";
		
//		int intA = Integer.parseInt(a, 2);
//		int intB = Integer.parseInt(b, 2);
//		
//		int sum = intA + intB;
		
//		answer = Integer.toBinaryString(sum);
		
		
		int carry = 0;
		int x = a.length() - 1;
		int y = b.length() - 1;
		
		while(x >= 0 || y >= 0 || carry > 0) {
			
			carry += (x >= 0) ? a.charAt(x) - '0' : 0;
			carry += (y >= 0) ? b.charAt(y) - '0' : 0;
			
			answer = (char)(carry % 2 + '0') + answer;
			
			
			carry = carry/2;
			
			x--; y--;
			
		}
		return answer;
	}
	
	private static String solutionByApi(String a, String b) {
		int intA = Integer.parseInt(a, 2);
		int intB = Integer.parseInt(b, 2);
		
		int sum = intA + intB;
		
		return Integer.toBinaryString(sum);
	}
	
	private static String solutionByList(String a, String b) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < Math.max(a.length(), b.length()); i++) {
			int x = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
			int y = i < b.length() ? Character.getNumericValue(b.charAt(b.length() - 1 - i)) : 0;
			list.add(x+y);
		}
		
		for(int j = 0; j < list.size(); j++) {
			int bit = list.get(j);
			
			if(bit > 1) {
				list.set(j, bit % 2);
				if(j < list.size() - 1) {
					list.set(j+1, list.get(j+1) + bit/2);
				} else {
					list.add(bit/2);
				}
			}
		};
		
		String answer = "";
		for(int i = list.size() - 1; i >= 0; i--) {
			answer += String.valueOf(list.get(i));
		}
				
		return answer;
	}

}
