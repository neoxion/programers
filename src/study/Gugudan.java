package study;

public class Gugudan {

	public static void main(String[] args) {
		int value = 0;

		Loop: for (int i = 2; i < 9; i++) {
			Loop2: for (int j = 2; j < 9; j++) {
				if (i == 2)
					break Loop2;
				if (j == 5)
					break Loop;
				value = i * j;
			}
		}

		System.out.println(value);

	}

}
