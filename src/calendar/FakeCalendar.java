package calendar;

import java.util.Scanner;

public class FakeCalendar {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("달을 입력하세요.");
			System.out.print("$");
			int year = scanner.nextInt();
			int month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			else if (month < 1 || month > 12) {
				System.out.println("1과 12 사이의 값만 입력해주세요.");
				continue;
			}

			int lastDayOfMonth = new Calendar().getLastDayOfMonth(year, month);

			System.out.println(" SU MO TU WE TH FR SA");
			System.out.println("=====================");

			for (int i = 1; i <= lastDayOfMonth; i++) {
				System.out.printf("%3d", i);
				if (i % 7 == 0 || i == lastDayOfMonth) {
					System.out.println();
				}
			}
		}
		scanner.close();
		
		System.out.println("Bye!");
	}
}
