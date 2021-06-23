package study;

import java.util.*;

class Truck {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		LinkedList<Integer> trucks = new LinkedList<Integer>();
		LinkedList<Integer> times = new LinkedList<Integer>();

		int answer = 0;
		int len = truck_weights.length;

		int remain = len;

		int tt = 0;
		while (remain > 0) {
			answer++;

			int truck = truck_weights[len - remain];
			if ((tt + truck) <= weight) {
				trucks.add(truck);
				times.add(bridge_length);
				tt += truck;
				remain--;
			}

			for (int i = 0; i < times.size(); i++) {
				times.set(i, times.get(i) - 1);
			}
			if (times.peek() < 1) {
				tt -= trucks.poll();
				times.poll();
			}
		}
		;

		return answer + bridge_length;
	}
}