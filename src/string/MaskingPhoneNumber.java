package string;

public class MaskingPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution("01012345678"));
		System.out.println(solution("0222224444"));

	}

	private static String solution(String str) {
		// TODO Auto-generated method stub
		
		String[] answer = str.split("");
		
		for(int i = str.length() - 1; i >= 0; i--) {
			if(i < str.length() - 4) {
				answer[i] = "*";
			}
		}
		
		return String.join("", answer);
	}

}
