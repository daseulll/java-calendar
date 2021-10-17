package calendar;

import java.util.*;

public class CalendarVersion2 {
	public static void main(String[] args) {
		System.out.println("+----------------------+");
		System.out.println("1. 일정 등록");
		System.out.println("2. 일정 검색");
		System.out.println("3. 달력 보기");
		System.out.println("h. 도움말 q. 종료");
		
		HashMap<String, ArrayList<String>> calendar = new HashMap<String, ArrayList<String>>();
		
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.printf(">");
			String command_num = scanner.nextLine();
			
			if (command_num.equals("1")) {
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
			} else if (command_num.equals("2")){
				System.out.println("[일정 검색] 날짜를 입력하세요.");
				System.out.printf(">");			
				String date = scanner.nextLine();
				ArrayList<String> scheduleList = calendar.get(date);
				System.out.println(scheduleList.size() + "개의 일정이 있습니다.");
				
				for (int i=0; i < scheduleList.size(); i++) {
					System.out.println(i + 1 + "." + scheduleList.get(i));
				}
				
			} else if (command_num.equals("q")){
				System.out.println("Bye");
				break;
			}
		}
		scanner.close();
	}
}
