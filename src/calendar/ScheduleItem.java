package calendar;

import java.time.LocalDate;
import java.io.*;

public class ScheduleItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2394156325559121584L;

	private LocalDate ScheduleDate;
	private String detail;
	
	public ScheduleItem(String strDate, String detail) {
		this.ScheduleDate = getLocalDateFromString(strDate);
		this.detail = detail;
				
	}
	
	public static LocalDate getLocalDateFromString(String strDate) {
		return LocalDate.parse(strDate);
	}
	
	public LocalDate getDate() {
		return ScheduleDate;
	}
	
	public String getDetail() {
		return detail;
	}
}
