package study;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Mobile {

	public static void main(String[] args) {
	}

	static class Node {
		int weight;
		int count;

		public Node(int weight, int count) {
			this.weight = weight;
			this.count = count;
		}
	}

	private static int solution(int[] weights) {
		int answer = 1;

		PriorityQueue<Node> nodes = new PriorityQueue<Node>(
				(a, b) -> a.weight == b.weight ? b.count - a.count : a.weight - b.weight);

		List<Node> list = new ArrayList<Node>();
		for (int w : weights)
			list.add(new Node(w, 1));

		list.sort((a, b) -> a.weight - b.weight);

		for (int w : weights)
			nodes.add(new Node(w, 1));

		while (nodes.size() > 1) {
			Node a = nodes.poll();
			Node b = nodes.poll();

			if (a.weight == b.weight) {
				nodes.add(new Node(a.weight + b.weight, a.count + b.count));
				if (a.count + b.count > answer)
					answer = a.count + b.count;
			} else {
				nodes.add(b);
			}

		}

		return answer;
	}

}
