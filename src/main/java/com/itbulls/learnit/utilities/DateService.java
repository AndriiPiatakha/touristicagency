package com.itbulls.learnit.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class DateService {
	public static java.sql.Date toSqlDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.parse(date, formatter));
		return sqlDate;
	}
	public static LocalDate stringToDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return LocalDate.parse(date, formatter);
	}
	
	public static long daysDifference(String start, String end) {
		LocalDate parsedStart =  DateService.stringToDate(start);
		LocalDate parsedend =  DateService.stringToDate(end);
		long daysBetween = ChronoUnit.DAYS.between(parsedStart, parsedend);
		return daysBetween;
	}
	
}
