package calendar;

import java.util.*;

public class FakeCalendar {

	public static int getDayIndex(int year, int month) {
		// 그레고리력 1년 1월 1일은 월요일 (1)
		int leapYearCount = (year / 4) - (year / 100) + (year / 400);

		int weekday = (year - leapYearCount) + (leapYearCount * 2);

		for (int i = 1; i < month; i++) {
			int lastDayOfMonth = new Calendar().getLastDayOfMonth(year, i);
			int diff = lastDayOfMonth - 28;
			weekday += diff;
		}

		return weekday % 7;
	}

	public static void printCalendar(int year, int month) {
		System.out.printf("<< %d년 %d월 >>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("=====================");

		int lastDayOfMonth = new Calendar().getLastDayOfMonth(year, month);
		int dayIndex = getDayIndex(year, month);

		if (dayIndex > 0) {
			System.out.printf(("%" + Integer.toString(dayIndex * 3) + "s"), " ");
		}

		int currentDayIndex = dayIndex;
		for (int i = 1; i <= lastDayOfMonth; i++) {
			System.out.printf("%3d", i);
			currentDayIndex += 1;

			if (currentDayIndex == 7 || i == lastDayOfMonth) {
				currentDayIndex = 0;
				System.out.println();
			}
		}
	}

	public static void printScheduleCalendar(int year, int month, ArrayList<Integer> scheduleList) {
		System.out.printf("<< %d년 %d월 >>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("=====================");

		int lastDayOfMonth = new Calendar().getLastDayOfMonth(year, month);
		int dayIndex = getDayIndex(year, month);

		if (dayIndex > 0) {
			System.out.printf(("%" + Integer.toString(dayIndex * 3) + "s"), " ");
		}

		int delim = 7 - dayIndex;
		for (int i = 1; i <= lastDayOfMonth; i++) {
			System.out.printf("%3d", i);

			if (i % 7 == delim || i == lastDayOfMonth) {
				System.out.println();

				int start = i - 6;
				if (i == lastDayOfMonth) {
					int lastDayIndex = (dayIndex + (lastDayOfMonth - 1)) % 7;
					start = i - lastDayIndex;
				}

				for (int j = start; j <= i; j++) {
					if (!scheduleList.contains(j)) {
						System.out.printf("%3s", " ");
					} else {
						System.out.printf("%3s", "·");
					}

				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("출력할 연도와 월을 입력하세요. ex) 2021 9");
			System.out.print("$");
			int year = scanner.nextInt();
			int month = scanner.nextInt();

			if (year == -1 || month == -1) {
				break;
			} else if (month < 1 || month > 12) {
				System.out.println("1과 12 사이의 값만 입력해주세요.");
				continue;
			}

			printCalendar(year, month);
		}
		scanner.close();
		System.out.println("Bye!");
		return;
	}
}
