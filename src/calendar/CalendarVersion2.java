package calendar;

import java.time.LocalDateTime;
import java.util.*;

public class CalendarVersion2 {
	static HashMap<String, ArrayList<String>> calendar = new HashMap<String, ArrayList<String>>();

	public static void registerSchedule(Scanner scanner) {
		System.out.println("[일정 등록] 날짜를 입력하세요.");
		System.out.printf(">");
		String date = scanner.nextLine();

		System.out.println("일정을 등록하세요.");
		System.out.printf(">");
		String schedule = scanner.nextLine();

		ArrayList<String> scheduleList = calendar.get(date);

		if (scheduleList == null) {
			scheduleList = new ArrayList<String>();
		}

		scheduleList.add(schedule);
		calendar.put(date, scheduleList);
	}
	public static void searchSchedule(Scanner scanner) {
		System.out.println("[일정 검색] 날짜를 입력하세요.");
		System.out.printf(">");
		String date = scanner.nextLine();
		ArrayList<String> scheduleList = calendar.get(date);
		
		if (!(scheduleList == null)) {
			System.out.println(scheduleList.size() + "개의 일정이 있습니다.");
			
			for (int i = 0; i < scheduleList.size(); i++) {
				System.out.println(i + 1 + "." + scheduleList.get(i));
			}					
		} else {
			System.out.println("일정이 없습니다.");
		}
	}
	public static void showSchedule() {
		LocalDateTime now = LocalDateTime.now();
		Set<String> scheduleKeySet = calendar.keySet();
		Iterator<String> iter = scheduleKeySet.iterator();

		ArrayList<Integer> scheduledDayList = new ArrayList<Integer>();
		while (iter.hasNext()) {
			String[] key = iter.next().split("-", 3);
			if (Integer.parseInt(key[0]) == (now.getYear())
					&& Integer.parseInt(key[1]) == now.getMonthValue()) {
				scheduledDayList.add(Integer.parseInt(key[2]));
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
