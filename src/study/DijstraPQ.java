import java.util.*;

public class DijstraPQ {

  public static void main(String[] args) {
    int N = 5;
    int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}; // 4
    int K = 3;
    System.out.println(solution(N, road, K));
  }

  static class Node {
    int idx, distance;

    Node(int idx, int distance) {
      this.idx = idx;
      this.distance = distance;
    }
  }

  private static int solution(int n, int[][] road, int k) {
    int start = 1;

    int answer = 0;

    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    @SuppressWarnings("unchecked")
    List<Node>[] nodes = new ArrayList[n + 1];
    for (int i = 0; i < n + 1; i++) {
      nodes[i] = new ArrayList<Node>();
    }

    for (int[] r : road) {
      nodes[r[0]].add(new Node(r[1], r[2]));
      nodes[r[1]].add(new Node(r[0], r[2]));
    }

    PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> a.distance - b.distance);

    dist[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();

      if (node.distance > dist[node.idx]) {
        continue;
      }

      for (Node next : nodes[node.idx]) {
        int newDist = dist[node.idx] + next.distance;
        if (newDist < dist[next.idx]) {
          dist[next.idx] = newDist;
          pq.add(new Node(next.idx, newDist));
        }
      }
    }

    for (int d : dist) {
      if (d <= k)
        answer++;
    }

    // 경로 구하기 1
    int end = 5;
    List<Integer> path = new ArrayList<Integer>();
    path.add(end);

    pq.add(new Node(end, dist[end]));
    while (pq.peek().idx != start) {
      Node node = pq.poll();
      for (Node before : nodes[node.idx]) {
        pq.add(new Node(before.idx, dist[before.idx]));
      }
      Node p = pq.poll();
      path.add(p.idx);
      pq.clear();
      pq.add(p);
    }
    Collections.reverse(path);
    System.out.println(path.toString());

    // 경로 구하기 2
    List<Integer> path2 = new ArrayList<Integer>();
    path2.add(end);
    while (end != start) {
      for (Node before : nodes[end]) {
        if (dist[before.idx] < dist[end]) {
          end = before.idx;
          path2.add(end);
        }
      }
    }
    Collections.reverse(path2);
    System.out.println(path2.toString());

    return answer;
  }

}
