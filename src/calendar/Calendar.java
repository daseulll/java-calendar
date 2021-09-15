package calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] LAST_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getLastDayOfMonth(int month) {
		return LAST_DAYS[month - 1];
	}
	
	public int getMonth(Scanner scanner) {
		System.out.println("달을 입력하세요. ");
		System.out.print("$");
		return scanner.nextInt();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month;
		
		month = cal.getMonth(scanner);
		while (month != -1) {
			System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getLastDayOfMonth(month));
			month = cal.getMonth(scanner);
		}
		
		System.out.println("Bye!");
		scanner.close();
	}
}
