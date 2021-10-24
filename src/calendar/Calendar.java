package calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
		HashMap<LocalDate, ArrayList<ScheduleItem>> schedule = CalendarVersion2.getSchedule(); 
		CalendarVersion2.printHelp();

		Scanner scanner = new Scanner(System.in);

		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.printf(">");
			String command_num = scanner.nextLine();

			switch (command_num) {
			case "1":
				CalendarVersion2.registerSchedule(scanner, schedule);
				break;
			case "2":
				CalendarVersion2.searchSchedule(scanner, schedule);
				break;
			case "3":
				CalendarVersion2.showSchedule(schedule);
				break;
			case "h":
				CalendarVersion2.printHelp();
				break;
			case "q":
				CalendarVersion2.storeSchedule(schedule);
				System.out.println("Bye");
				isLoop = false;
			}
		}
		scanner.close();
	}
}
