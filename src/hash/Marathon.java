package hash;

import java.util.*;

public class Marathon {

	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> hm = new HashMap<String, Integer>();
        
//        for(String c : completion) {
//        	if(hm.containsKey(c)) {
//        		hm.put(c, hm.get(c) + 1);
//        	} else {
//        		hm.put(c, 1);
//        	}
//        }
//        
//        for(String p : participant) {
//        	if(hm.containsKey(p)) {
//        		int remain = hm.get(p) - 1;
//        		if(remain < 1) {
//        			hm.remove(p);
//        		} else {
//        			hm.put(p, remain);
//        		}
//        	} else {
//        		answer = p;
//        		break;
//        	}
//        }
        
        for(String c : completion) hm.put(c, hm.getOrDefault(c, 0) + 1);
        for(String p : participant) hm.put(p, hm.getOrDefault(p, 0) - 1);
        
        for(String key : hm.keySet()) {
        	if(hm.get(key) < 0) answer = key;
        }
       
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] case1_p = {"leo", "kiki", "eden"};
		String[] case1_c = {"eden", "kiki"};
		
		System.out.println(solution(case1_p, case1_c));

	}

}