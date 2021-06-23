package set;

import java.util.*;

public class WordRelay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		String[] words = {"tk", "kk", "kw", "wl", "ld", "dm", "mr", "rt", "tk"};
		
		System.out.println(Arrays.toString(solution(n, words)));

	}

	private static int[] solution(int n, String[] words) {
		// TODO Auto-generated method stub
		int[] answer = {0, 0};
		
		HashSet<String> set = new HashSet<String>();
		
		String preWord = "";
		set.add(words[0]);
		
		for(int i = 1; i < words.length; i++) {
			preWord = words[i-1];
			if(set.contains(words[i]) || preWord.charAt(1) != words[i].charAt(0)) {
				answer[0] = i % n + 1;
				answer[1] = i / n + 1;
				break;
			}
		}
		
		return answer;
	}

}
