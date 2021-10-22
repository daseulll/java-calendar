package calendar;

import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class CalendarVersion2 {
	static HashMap<LocalDate, ArrayList<ScheduleItem>> calendar = new HashMap<LocalDate, ArrayList<ScheduleItem>>();

	public static boolean validateDateInput(String strDate) {
		String regex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|12[0-9]|3[01])$";
		return Pattern.matches(regex, strDate);
	}
	
	public static LocalDate parseDate(String strDate) {
		return LocalDate.parse(strDate);
	}
	
	public static void registerSchedule(Scanner scanner) {
		System.out.println("[일정 등록] 날짜를 입력하세요. (yyyy-mm-dd)");
		System.out.printf(">");
		String strDate = scanner.nextLine().trim();
		
		if (!validateDateInput(strDate)) {
			System.out.println("yyyy-mm-dd 형식이 아닙니다! 다시 입력해주세요.");
			registerSchedule(scanner);
		}

		System.out.println("일정을 등록하세요.");
		System.out.printf(">");
		String detail = scanner.nextLine();
		
		ArrayList<ScheduleItem> scheduleList = calendar.get(ScheduleItem.getLocalDateFromString(strDate));
		if (scheduleList == null) {
			scheduleList = new ArrayList<ScheduleItem>();
		}

		scheduleList.add(new ScheduleItem(strDate, detail));
		calendar.put(parseDate(strDate), scheduleList);
	}
	public static void searchSchedule(Scanner scanner) {
		System.out.println("[일정 검색] 날짜를 입력하세요.");
		System.out.printf(">");
		String strDate = scanner.nextLine().trim();
		if (!validateDateInput(strDate)) {
			System.out.println("yyyy-mm-dd 형식이 아닙니다! 다시 입력해주세요.");
			registerSchedule(scanner);
		}

		ArrayList<ScheduleItem> scheduleList = calendar.get(ScheduleItem.getLocalDateFromString(strDate));
		
		if (!(scheduleList == null)) {
			System.out.println(scheduleList.size() + "개의 일정이 있습니다.");
			
			for (int i = 0; i < scheduleList.size(); i++) {
				System.out.println(i + 1 + "." + scheduleList.get(i).getDetail());
			}					
		} else {
			System.out.println("일정이 없습니다.");
		}
	}
	public static void showSchedule() {
		LocalDateTime now = LocalDateTime.now();
		Set<LocalDate> scheduleKeySet = calendar.keySet();
		Iterator<LocalDate> iter = scheduleKeySet.iterator();

		ArrayList<Integer> scheduledDayList = new ArrayList<Integer>();
		while (iter.hasNext()) {
			LocalDate scheduledDate = iter.next();
			if (scheduledDate.getYear() == (now.getYear())
					&& scheduledDate.getMonthValue() == now.getMonthValue()) {
				scheduledDayList.add(scheduledDate.getDayOfMonth());
			}
		}
		FakeCalendar.printScheduleCalendar(now.getYear(), now.getMonthValue(), scheduledDayList);
	}

	public static void printHelp() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");	
	}

	
	public static void main(String[] args) {
		printHelp();
		Scanner scanner = new Scanner(System.in);
		
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.printf(">");
			String command_num = scanner.nextLine();
			
			switch (command_num) {
			case "1":
				registerSchedule(scanner);
				break;
			case "2":
				searchSchedule(scanner);				
				break;
			case "3":
				showSchedule();
				break;
			case "h":
				printHelp();
				break;
			case "q":
				System.out.println("Bye");
				isLoop = false;
			}
		}
		scanner.close();
	}
}
