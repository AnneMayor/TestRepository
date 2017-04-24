package ch11.exam16;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateExample {

	public static void main(String[] args) {
		Date now = new Date();// 얘는 API에서 웬만하면 쓰지말라고 한다...참고하자!
		System.out.println(now);
		
		Calendar cal = Calendar.getInstance(); // 얘는 시간객체이므로 연월일 다 나옴!
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DAY_OF_MONTH);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		
		System.out.println(year + "-" + month + "-" + date);
		
		
	}

}
