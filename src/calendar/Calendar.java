package calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] LAST_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static int lastDayOfMonth(int month) {
		return LAST_DAYS[month - 1];
	}
	
	public static void main(String[] args) {
		System.out.println("달을 입력하세요. ");
		
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		
		System.out.printf("%d월은 %d일까지 있습니다.", month, lastDayOfMonth(month));
		
		scanner.close();
	}
}
