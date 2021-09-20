package calendar;

import java.util.Scanner;

public class FakeCalendar {
	public static int getDayIndex(String day) {
		if (day == "SU") {
			return 0;
		}
		else if (day.equals("MO")) {
			return 1;
		}
		else if (day.equals("TU")) {
			return 2;
		}
		else if (day.equals("WE")) {
			return 3;
		}
		else if (day.equals("TH")) {
			return 4;
		}
		else if (day.equals("FR")) {
			return 5;
		}
		else if (day.equals("SA")) {
			return 6;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("출력할 연도와 월을 입력하세요. ex) 2021 9");
			System.out.print("$");
			int year = scanner.nextInt();
			int month = scanner.nextInt();
			
			System.out.println("첫째 날의 요일을 입력하세요. (SU MO TH WE TH FR SA)");
			String day = scanner.next();
			int dayIndex = getDayIndex(day);
			
			
			if (year == -1 || month == -1) {
				break;
			}
			else if (month < 1 || month > 12) {
				System.out.println("1과 12 사이의 값만 입력해주세요.");
				continue;
			}

			int lastDayOfMonth = new Calendar().getLastDayOfMonth(year, month);

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
