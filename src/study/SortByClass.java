import java.util.*;
import java.util.Map.Entry;

public class SortByClass {

	public static void main(String[] args) {

		// PQ 정렬
		PriorityQueue<Music> musics = new PriorityQueue<Music>(
				(a, b) -> a.genre == b.genre ? b.played - a.played : a.played - b.played);

		// List 정렬
		List<Music> list = new ArrayList<Music>();
		list.sort((a, b) -> a.played - b.played);

		// Map 정렬
		Map<String, Music> map = new HashMap<String, Music>();
		List<Map.Entry<String, Music>> linkedList = new LinkedList<>(map.entrySet());
		Collections.sort(linkedList, new Comparator<Map.Entry<String, Music>>() {
			@Override
			public int compare(Entry<String, Music> o1, Entry<String, Music> o2) {
				if (o1.getValue().genre == o2.getValue().genre) {
					return o1.getKey().compareTo(o2.getKey());
				} else {
					return (o1.getValue().played - o2.getValue().played) * -1; // 내림차순 (*-1)
				}
			}
		});

		Iterator<Map.Entry<String, Music>> it = linkedList.iterator();
		while (it.hasNext()) {
			Map.Entry<String, Music> entry = it.next();
			String key = entry.getKey();
			Music music = entry.getValue();
		}

		ListIterator<Map.Entry<String, Music>> listIt = linkedList.listIterator(); // 양방향 이동
		while (listIt.hasNext()) {
			Map.Entry<String, Music> entryA = listIt.next();
			Map.Entry<String, Music> entryB = listIt.previous();
		}

	}

	static class Music {
		String genre;
		int played, id;

		public Music(String genre, int played, int id) {
			this.genre = genre;
			this.played = played;
			this.id = id;
		}
	}
}
