package hash;

import java.util.*;

// 가위바위보
public class SRP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] players = { { 1, 1, 3 }, { 3, 2, 2 }, { 2, 2, 1 }, { 2, 2, 1 } };

		System.out.println("winner = " + solution(players));
	}

	private static int solution(int[][] players) {
		// TODO Auto-generated method stub

		// 1. 선수준비
		HashMap<Integer, int[]> list = new HashMap<Integer, int[]>();
		for (int i = 0; i < players.length; i++) {
			list.put(i, players[i]);
		}

		// 2. 게임 준비
		int games = players[0].length;

		for (int i = 0; i < games; i++) {
			HashMap<Integer, ArrayList> hm = new HashMap<Integer, ArrayList>();

			for (int player : list.keySet()) {
				ArrayList<Integer> play = hm.getOrDefault(list.get(player)[i], new ArrayList<Integer>());
				play.add(player);
				hm.put(list.get(player)[i], play);
			}

			checkWinner(hm, list);

			if (list.size() == 1) {
				return list.keySet().stream().findFirst().get() + 1;
			}
		}

		return 0;
	}

	private static void checkWinner(HashMap<Integer, ArrayList> hm, HashMap<Integer, int[]> list) {
		// TODO Auto-generated method stub
		if (hm.size() != 2)
			return;

		ArrayList<Integer> losers = null;

		if (hm.containsKey(1) && hm.containsKey(2)) {
			losers = hm.get(1);
		} else if (hm.containsKey(2) && hm.containsKey(3)) {
			losers = hm.get(2);
		} else if (hm.containsKey(3) && hm.containsKey(1)) {
			losers = hm.get(3);
		}

		for (int loser : losers) {
			list.remove(loser);
		}
	}

}
