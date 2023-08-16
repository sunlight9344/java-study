package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 11); // 12월
		cal.set(Calendar.DATE, 25);
		
		printDate(cal);
		
		cal.set(1998,03,20,12,30,00);
		cal.add(Calendar.DATE, 10000);
		
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		
		final String[] DAYS = {"일","월","화","수","목","금","토"};
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0 ~ 11, +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				year + "/" +
				(month + 1) + "/" +
				date + " "+
				DAYS[day-1] + "요일 "+
				hour+":"+
				minute +":"+
				second
				);
		
		
	}

}
