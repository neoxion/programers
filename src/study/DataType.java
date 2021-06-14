import java.util.*;
import java.util.stream.Collectors;

public class DataType {
	private static final int MAX_ENTRIES = 3;

	public static void main(String[] args) {
		try {
			StringBuilder sb = new StringBuilder();
			List<String> list = new ArrayList<String>(); // 검색에 유리, 삭제 불리
			LinkedList<String> qu = new LinkedList<String>(); // 추가.삭제 유리, 검색 불리, 선입선출
			List<List<String>> list2 = new ArrayList<List<String>>();
			Map<Integer, Job> map = new HashMap<Integer, Job>();
			Set<Job> set = new HashSet<Job>();
			TreeSet<String> ts = new TreeSet<String>(); // 중복제거 및 자동정렬
			TreeSet<String> reverseTs = new TreeSet<String>(Collections.reverseOrder()); // 역방향 정렬
			TreeMap<Integer, Job> tm = new TreeMap<Integer, Job>(); // 정렬

			// 입력순서 저장 - https://library1008.tistory.com/11
			Map<Integer, Job> lhm = new LinkedHashMap<Integer, Job>() {
				@Override
				protected boolean removeEldestEntry(Map.Entry<Integer, Job> eldest) {
					return size() == MAX_ENTRIES ? true : false;
				}
			}; // put(v) & get(k)

			Stack<String> st = new Stack<>(); // 후입선출 push & pop

			for (String s : list) {
				sb.append(s);
				st.push(s);
				st.pop();

				List<String> m = new ArrayList<String>(); // list 이중구조
				m.add(s);
				list2.add(m);

				ts.add(s); // 중복제거 및 정렬
			}

			Job j = new Job(0, 1);
			set.add(j);

			List<String> removeDupList = list.stream().distinct().collect(Collectors.toList()); // 중복제거

			int[] arr = { 1, 2, 3, 4, 5 };
			int[] arr2 = Arrays.copyOf(arr, 3); // 길이만큼 복사
			int[] arr3 = Arrays.copyOfRange(arr, 2, 3); // 길이만큼 복사
			Arrays.sort(arr); // 정렬
			Arrays.fill(arr, 0); // 0으로 초기화
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
	}

	static class Job {
		int start, time;

		public Job(int start, int time) {
			this.start = start;
			this.time = time;
		}
	}

}
