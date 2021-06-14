package hash;

import java.util.*;

public class BestAlbum {

	
	static class Song {
		String genre;
		int play, idx;
		
		public Song(String genre, int play, int idx) {
			this.genre = genre;
			this.play = play;
			this.idx = idx;
		}
	}
	
	static class Genre {
		String genre;
		int play;
		
		public Genre(String genre, int play) {
			this.genre = genre;
			this.play = play;
		}
	}
		
	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		ArrayList<Song> list= new ArrayList<Song>();
		ArrayList<Integer> bestAlbum = new ArrayList<Integer>();
				
		for(int i = 0; i < genres.length; i++) {
			hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
			list.add(new Song(genres[i], plays[i], i));
		}
		
		list.sort((a, b) -> {
			if(hm.get(a.genre) == hm.get(b.genre)) {
				if(a.play == b.play) {
					return a.idx > b.idx ? 1 : -1;
				} else {
					return a.play < b.play ? 1 : -1;
				}
			} else {
				return hm.get(a.genre) < hm.get(b.genre) ? 1 : -1;
			}
		});
		

		HashMap<String, Integer> ba = new HashMap<String, Integer>();
		for(Song s : list) {
			ba.put(s.genre, ba.getOrDefault(s.genre, 0) + 1);
			if(ba.get(s.genre) > 2) {
				continue;
			} else {
				bestAlbum.add(s.idx);
			}
		}
		
		return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
	}
//	public static int[] solution(String[] genres, int[] plays) {
//		
//		Map<String, Integer> gm = new HashMap<String, Integer>();
//		List<Song> list = new ArrayList<Song>();
//		List<Genre> glist = new ArrayList<Genre>();
//		
//		for(int i = 0; i < genres.length; i++) {
//			gm.put(genres[i], gm.getOrDefault(genres[i], 0) + plays[i]);
//			list.add(new Song(genres[i], plays[i], i));
//		}
//		
//		Collections.sort(list, (a, b) -> {
//			if(a.play == b.play) {
//				return a.idx > b.idx ? 1 : -1;
//			} else {
//				return a.play < b.play ? 1 : -1;
//			}
//		});
//		
//		for(String key : gm.keySet()) {
//			glist.add(new Genre(key, gm.get(key)));
//		}
//		
//		Collections.sort(glist, (a, b) -> {
//			return a.play < b.play ? 1 : -1;
//		});
//		
//		
//		List<Integer> bestAlbum = new ArrayList<Integer>();
//		
//		for(Genre g : glist) {
//			int cnt = 0;
//			
//			for(Song s : list) {
//				if(s.genre == g.genre) {
//					bestAlbum.add(s.idx);
//					cnt++;
//				}
//				if(cnt > 1) break;
//			}
//			
//			
//		}
//		
//		return bestAlbum.stream().mapToInt(Integer::intValue).toArray(); 
//    }
//	public static int[] solution(String[] genres, int[] plays) {
//		
//		Map<String, Integer> hm = new HashMap<String, Integer>();
//		Map<String, List> best = new HashMap<String, List>();
//		
//		
//		PriorityQueue<Genre> bestGenres = new PriorityQueue<Genre>((a, b) -> {
//			return a.play < b.play ? 1 : -1;
//		});
//		
//		
//		List<Genre> bestGenres = new ArrayList<Genre>();
//		
//		
//		
//		List<Song> list = new ArrayList<Song>();
//		
//		for(int i = 0; i < genres.length; i++) {
//			list.add(new Song(genres[i], plays[i], i));
//		}
//		
//		list.sort((a, b) -> {
//			if(a.play == b.play) {
//				return a.idx < b.idx ? 1 : -1;
//			} else {
//				return a.play < b.play ? 1 : -1;
//			}
//		});
//		
//		for(Song s : list) {
//			hm.put(s.genre, hm.getOrDefault(s.genre, 0) + s.play);
//			List newList = best.getOrDefault( s.genre, new ArrayList());
//			newList.add(s.idx);
//			best.put(s.genre, newList);
//			
////        	System.out.println(s.genre + " : " + s.play + " : " + s.idx);
//		}
//		
//		
//		List<Integer> answerList  = new ArrayList<Integer>();
//		for(String key : best.keySet()) {
////        	System.out.println(key + " -> " + best.get(key));
//			List c = best.get(key);
//			
//			for(int i = 0; i < Math.min(2, c.size()); i++) {
//				answerList.add((Integer) c.get(i));
//			}
//		}
//		
//		int[] answer = new int[answerList.size()];
//		for(int i = 0; i < answerList.size(); i++) answer[i] = answerList.get(i);
//		
//		
//		return answer;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		System.out.println(Arrays.toString(solution(genres, plays)));

	}

}
