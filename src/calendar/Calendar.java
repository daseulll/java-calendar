package calendar;

import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
		System.out.println("달을 입력하세요. ");
		
		int[] lastDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
		Scanner scanner = new Scanner(System.in);
		int inputValue = scanner.nextInt();
		
		int lastDayOfMonth =  lastDays[inputValue + 1];
		System.out.printf("%d월은 %d일까지 있습니다.", inputValue, lastDayOfMonth);
		
		scanner.close();
	}
}
