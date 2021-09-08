package calendar;

public class Calendar {
	public static void main(String[] args) {
		System.out.println("일  월  화  수  목  금  토");
		System.out.println("----------------------");
		
		String week = ""; 
		for (int i = 1; i <= 29; i++) {
			int reapeatCount;
			int remainder = i % 7;
			
			if (remainder == 1) {
				reapeatCount = 0;
				if (i < 10) {
					reapeatCount = 1;				
				}
			}
			else {
				reapeatCount = 1;
				if (i < 10) {
					reapeatCount = 2;				
				}
			}
			
			week = week + " ".repeat(reapeatCount) + Integer.toString(i);
			if (remainder == 0) {				
				System.out.println(week);
				week = "";
			}
		}
	}
}
