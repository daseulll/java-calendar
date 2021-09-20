package calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] LAST_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_LAST_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getLastDayOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_LAST_DAYS[month - 1];			
		}
		return LAST_DAYS[month - 1];
	}

	public boolean isLeapYear(int year) {
		if (year % 400 == 0) {
			return true;			
		}
		else if (year % 4 == 0 && year % 100 != 0) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("출력할 연도와 월을 입력하세요. ex) 2021 9");
			System.out.print("$");
			int year = scanner.nextInt();
			int month = scanner.nextInt();

			if (year == -1 || month == -1) {
				break;
			}

			else if (month > 12) {
				System.out.println("1과 12 사이의 값만 입력가능합니다.");
				continue;
			}
			
			System.out.printf("%d년 %d월은 %d일까지 있습니다.\n", year, month, cal.getLastDayOfMonth(year, month));
		}

		System.out.println("Bye!");
		scanner.close();
	}
}
