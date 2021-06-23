package stack;

import java.util.*;

public class Bracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solutionA("(()("));
		System.out.println(solutionB("(()("));

	}

	private static boolean solutionA(String string) {
		// TODO Auto-generated method stub
		int counter = 0;
		
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == '(') {
				counter++;
			} else {
				if(counter > 0) {
					counter--;
				} else {
					return false;
				}
			}
		}
		
		if(counter != 0) return false;
		
		return true;
	};
	
	private static boolean solutionB(String string) {
		// TODO Auto-generated method stub
		Stack<Character> st = new Stack<Character>();
		
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == '(') {
				st.add(string.charAt(i));
			} else {
				if(st.size() > 0) {
					st.pop();
				} else {
					return false;
				}
			}
		}
		
		if(st.size() != 0) return false;
		
		return true;
	}

}
