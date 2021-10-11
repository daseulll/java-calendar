package calendar;

import java.util.Scanner;

public class FakeCalendar {

	public static int getDayIndex(int year, int month) {
		// 그레고리력 1년 1월 1일은 월요일 (1)
		int leapYearCount = (year / 4) - (year / 100) + (year / 400);
		
		int weekday = (year - leapYearCount) + (leapYearCount*2);
		
		for (int i = 1; i < month; i++) {
			int lastDayOfMonth = new Calendar().getLastDayOfMonth(year, i);
			int diff = lastDayOfMonth - 28;
			weekday += diff;
		}
				
		return weekday % 7;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("출력할 연도와 월을 입력하세요. ex) 2021 9");
			System.out.print("$");
			int year = scanner.nextInt();
			int month = scanner.nextInt();
			
			int dayIndex = getDayIndex(year, month);
			
			
			if (year == -1 || month == -1) {
				break;
			}
			else if (month < 1 || month > 12) {
				System.out.println("1과 12 사이의 값만 입력해주세요.");
				continue;
			}

			int lastDayOfMonth = new Calendar().getLastDayOfMonth(year, month);

			System.out.printf("<< %d년 %d월 >>\n", year, month);
			System.out.println(" SU MO TU WE TH FR SA");
			System.out.println("=====================");
			
			if (dayIndex > 0) {				
				System.out.printf(("%"+ Integer.toString(dayIndex * 3) +"s"), " ");
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
		scanner.close();
		
		System.out.println("Bye!");
	}
}
