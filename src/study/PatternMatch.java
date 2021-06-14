import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PatternMatch {
	public static void main(String[] args) {
		String name = "Myungho Choi";

		char[] chars = name.toCharArray();

		for (char c : chars) {
			int index = name.indexOf(c);

			int charInt = (int) c - 48; // char to int 형변환
		}

		// chars to ArrayList
		ArrayList<Character> chs1 = new ArrayList<Character>(
				name.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
		List<Character> chs2 = name.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());

		Collections.reverse(chs1);

		String filter = "ABC";
		String[] targets = { "ABCD", "BCDE" };
		for (String s : targets) {
			if (filter.indexOf(s.replaceAll("[^" + filter + "]", "")) == 0) {

			}
		}

		// 정규식
		name.replaceAll("[0-9]", ""); // 숫자만 제거
		name.replaceAll("[^0-9]", ""); // 숫자만 남기고 제거
		name.replaceAll("[A-Z]", ""); // 대문자 제거
		name.replaceAll("[a-z]", ""); // 소문자 제
		name.replaceAll("[a-zA-Z]", "");// 대소문자 제거
		name.replaceAll("[A-z]", ""); // 대소문자 제거
		name.replaceAll("[a-Z]", ""); // 에러
		name.replaceAll("[ㄱ-ㅎ]", ""); // 자음 삭제
		name.replaceAll("[ㅏ-ㅣ]", ""); // 모음 삭제
		name.replaceAll("[ㅏ-ㅣㄱ-ㅎ]", ""); // 모음 자음 삭제
		name.replaceAll("[ㄱ-ㅣ]", ""); // 모음 자음 삭제
		name.replaceAll("[ㅣ-ㄱ]", ""); // 에러
		name.replaceAll("[가-힣]", ""); // 모음 자음 남김
		name.replaceAll("[ㄱ-ㅎ가-힣]", ""); // 모음만 남음
		name.replaceAll("[ㅏ-힣]", ""); // 자음만 남음
		name.replaceAll("[ㄱ-힣]", ""); // 모두 제거

	}

	enum Rainbow {
		RED, YELLOW
	}

}
