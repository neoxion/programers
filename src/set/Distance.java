package set;

import java.util.*;

public class Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution("ULURRDLLU")); //7
		System.out.println(solution("LULLLLLLU")); //7

	}

	private static int solution(String dirs) {
		// TODO Auto-generated method stub
		
		HashSet<String> set = new HashSet<String>();
		
		int fromX = 0;
		int fromY = 0;
		
		for(int i = 0; i < dirs.length(); i++) {
			
			int toX = fromX;
			int toY = fromY;
			
			switch(dirs.charAt(i)) {
				case 'U':
					if(toY < 5) toY++;
					break;
				case 'D':
					if(toY > -5) toY--;
					break;
				case 'L':
					if(toX > -5) toX--;
					break;
				case 'R':
					if(toX < 5) toX++;
					break;
			}
			
			set.add("["+fromX+","+fromY+"]-["+toX+","+toY+"]");
			set.add("["+toX+","+toY+"]-["+fromX+","+fromY+"]");
			
			fromX = toX;
			fromY = toY;
		}
		
		return set.size()/2;
	}

}
