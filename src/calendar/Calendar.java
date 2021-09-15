package calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] LAST_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getLastDayOfMonth(int month) {
		return LAST_DAYS[month - 1];
	}

	public static void main(String[] args) {
		System.out.println("반복 횟수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		int repetitionCount = scanner.nextInt();

		System.out.println("달을 입력하세요. ");

		String PROMPT = "$";
		int[] monthList = new int[repetitionCount];
		for (int i = 0; i < repetitionCount; i++) {
			System.out.print(PROMPT);
			monthList[i] = scanner.nextInt();
		}
		scanner.close();

		Calendar cal = new Calendar();
		for (int i = 0; i < repetitionCount; i++) {
			System.out.printf("%d월은 %d일까지 있습니다.\n", monthList[i], cal.getLastDayOfMonth(monthList[i]));
		}
	}
}
