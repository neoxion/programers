package stack;

import java.util.*;

public class Deploy {

	static class Func {
        int prgs, spds;
        boolean cplt;
        
        public Func(int prgs, int spds, boolean cplt) {
            this.prgs = prgs;
            this.spds = spds;
            this.cplt = cplt;
        }
        
        public void work() {
            prgs += spds;
            if(prgs > 99) cplt = true;
        }
    }
	
	static int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Func> list = new LinkedList<Func>();
        ArrayList<Integer> deploy = new ArrayList<Integer>();
        
        for(int i = 0; i < progresses.length; i++) list.add(new Func(progresses[i], speeds[i], false));
        
        while(!list.isEmpty()) {
        	
        	for(int i = 0; i < list.size(); i++) {
        		Func fn = list.get(i);
        		fn.work();
        		list.set(i, fn);
        	}
        	
        	int cnt = 0;
        	while(!list.isEmpty()) {
        		Func fn = list.peek();
        		if(fn.cplt) {
        			list.remove();
        			cnt++;
        		} else {
        			break;
        		}
        	}
        	if(cnt > 0) {
        		deploy.add(cnt);
        	}
        }
        
        return deploy.stream().mapToInt(Integer::intValue).toArray();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));

	}

}
