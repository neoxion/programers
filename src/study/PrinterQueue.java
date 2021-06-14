import java.util.*;
class PrinterQueue {
    public int solution(int[] priorities, int location) {
        int len = priorities.length;
        
        LinkedList<Integer> qu = new LinkedList<Integer>();
        for(int i = 0; i < len; i++) qu.add(i);
        
        for(int i = 0; i < len; i++) { qu = sort(qu, priorities); }
                
        return qu.indexOf(location)+1;
    }
    
    public static LinkedList<Integer> sort(LinkedList<Integer> qu, int[] priorities) {
        int len = priorities.length;
        
        for(int i = 0; i < len; i++) {
            int p = priorities[i];
            int qi = qu.indexOf(i);
            
            for(int j = qi+1; j < len; j++) {
                int pj = priorities[qu.get(j)];
                if(pj > p) {
                    qu.remove(qi);
                    qu.addLast(i);
                    break;
                }
            }
        }
        
        return qu;
    }
}