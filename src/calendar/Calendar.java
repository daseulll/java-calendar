package calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] LAST_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getLastDayOfMonth(int month) {
		return LAST_DAYS[month - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = 1;
		
		while (true) {
			System.out.println("달을 입력하세요. ");
			System.out.print("$");
			month = scanner.nextInt();
			
			if (month == -1) {
				break;
			}
			
			else if (month > 12) {
				System.out.println("1과 12 사이의 값만 입력가능합니다.");
				continue;
			}
			System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getLastDayOfMonth(month));
		}
		
		System.out.println("Bye!");
		scanner.close();
	}
}
