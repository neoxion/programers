package study;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DualPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public int[] solution(String[] operations) {
		int[] answer = { 0, 0 };

		PriorityQueue<Integer> max = new PriorityQueue<Integer>((a, b) -> b - a);
		PriorityQueue<Integer> min = new PriorityQueue<Integer>((a, b) -> a - b);

		for (String s : operations) {
			String[] operator = s.split(" ");
			if (operator[0].equals("I")) {
				max.add(Integer.parseInt(operator[1]));
				min.add(Integer.parseInt(operator[1]));
			} else {
				if (max.isEmpty())
					continue;
				if (operator[1].equals("1")) {
					min.remove(max.poll());
				} else {
					max.remove(min.poll());
				}
			}
		}

		if (!max.isEmpty()) {
			answer[0] = max.poll();
			answer[1] = min.poll();
		}

		return answer;
	}

}
