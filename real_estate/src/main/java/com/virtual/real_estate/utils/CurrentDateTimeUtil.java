package com.virtual.real_estate.utils;

import java.time.LocalDateTime;

public class CurrentDateTimeUtil {
	
	public static String nowDate() {
		// 현재 날짜/시간
		LocalDateTime now = LocalDateTime.now();
		// 현재 날짜/시간 출력
//		System.out.println(now); // 2021-06-17T06:40:35.477667600
		// 년, 월(문자열, 숫자), 일(월 기준, 년 기준), 요일(문자열, 숫자), 시, 분, 초 구하기
		int year = now.getYear(); // 연도
//		String month = now.getMonth().toString(); // 월(문자열)
		int monthValue = now.getMonthValue(); // 월(숫자)
		int dayOfMonth = now.getDayOfMonth(); // 일(월 기준)
//		int dayOfYear = now.getDayOfYear(); // 일(년 기준)
//		String dayOfWeek = now.getDayOfWeek().toString(); // 요일(문자열)
//		int dayOfWeekValue = now.getDayOfWeek().getValue(); // 요일(숫자)
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
//		// 년, 월(문자열, 숫자), 일(월 기준, 년 기준), 요일(문자열, 숫자), 시, 분, 초 출력
//		System.out.println("년 : " + year); // 년 : 2021
//		System.out.println("월 : " + month + "(" + monthValue + ")"); // 월 : JUNE(6)
//		System.out.println("일(월기준) : " + dayOfMonth); // 일(월기준) : 17
//		System.out.println("일(년기준) : " + dayOfYear); // 일(년기준) : 168
//		System.out.println("요일 : " + dayOfWeek + "(" + dayOfWeekValue + ")"); // 요일 : THURSDAY(4)
//		System.out.println("시간 : " + hour); // 시간 : 6
//		System.out.println("분 : " + minute); // 분 : 40
//		System.out.println("초 : " + second); // 초 : 35
		StringBuffer sbf = new StringBuffer();
		sbf.append(year);
		sbf.append(monthValue);
		sbf.append(dayOfMonth);
		sbf.append(hour);
		sbf.append(minute);
		sbf.append(second);
		
		return sbf.toString();
	}
}
