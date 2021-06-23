package study;

public class PalindromeLongest {

	public static void main(String[] args) {

	}

	public static int solution(String s) {
		int answer = 0;

		String longest = findLongestPalindrome(s);
		answer = longest.length();

		return answer;
	}
	
	//https://www.geeksforgeeks.org/maximum-length-palindromic-substring-such-that-it-starts-and-ends-with-given-char/
	public static String findLongestPalindrome(String s) {
		// Validations
		if (s.isEmpty()) { 
			return "Please enter a String";
		}
		if (s.length() == 1) {
			return s;
		}
		
		// Start with one char (starting) as a longest palindrome
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {

			// get longest palindrome for odd length (center is i)
			String tmp = checkForEquality(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// get longest palindrome for even length (center is i, i+1)
			tmp = checkForEquality(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}

		return longest;
	}

	public static String checkForEquality(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

}
