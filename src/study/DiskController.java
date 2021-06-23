package study;

import java.util.PriorityQueue;

public class DiskController {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	static class Job {
		int start, time;

		public Job(int start, int time) {
			this.start = start;
			this.time = time;
		}
	}

	private static int solution(int[][] jobs) {
		PriorityQueue<Job> pq = new PriorityQueue<Job>(
				(a, b) -> a.start == b.start ? a.time - b.time : a.start - b.start);
		PriorityQueue<Job> wq = new PriorityQueue<Job>((a, b) -> a.time - b.time);

		for (int[] j : jobs) {
			pq.add(new Job(j[0], j[1]));
		}

		int now = 0;
		int sum = 0;

		while (!pq.isEmpty()) {
			if (pq.peek().start > now) {
				now = pq.peek().start;
			}
			while (!pq.isEmpty() && pq.peek().start <= now) {
				wq.add(pq.poll());
			}

			Job job = wq.poll();
			now += job.time;
			sum += now - job.start;

			while (!wq.isEmpty()) {
				pq.add(wq.poll());
			}
		}

		return sum / jobs.length;
	}
}