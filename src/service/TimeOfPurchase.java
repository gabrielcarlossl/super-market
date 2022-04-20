package service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeOfPurchase {

	public LocalDateTime timeOfPurchase;
	public int hourFormatted;
	
	public void defineTimeOfPurchase(int day, int month, int year, int hours, int minutes, int seconds) {
		String formattedDate = String.format("%02d/%02d/%02d %02d:%02d:%02d", day, month, year, hours, minutes, seconds);		
		this.timeOfPurchase = LocalDateTime.parse(formattedDate, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		this.hourFormatted = hours;
	}
	
	public LocalDateTime getTimeOfPurchase() {
		return timeOfPurchase;
	}
	
	public int gethourFormatted() {
		return hourFormatted;
	}
	
	public String getHourFormatted() {
		return String.format("%02d/%02d/%02d %02d:%02d:%02d", timeOfPurchase.getDayOfMonth(), timeOfPurchase.getMonthValue(), timeOfPurchase.getYear(), timeOfPurchase.getHour(), timeOfPurchase.getMinute(), timeOfPurchase.getSecond());
	}
	
	public String getDayOfTheWeek() {
		if(timeOfPurchase.getDayOfWeek() == DayOfWeek.MONDAY) {
			return "Segunda";
		}
		if(timeOfPurchase.getDayOfWeek() == DayOfWeek.TUESDAY) {
			return "Terça";
		}
		if(timeOfPurchase.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
			return "Quarta";
		}
		if(timeOfPurchase.getDayOfWeek() == DayOfWeek.THURSDAY) {
			return "Quinta";
		}
		if(timeOfPurchase.getDayOfWeek() == DayOfWeek.FRIDAY) {
			return "Sexta";
		}
		if(timeOfPurchase.getDayOfWeek() == DayOfWeek.SATURDAY) {
			return "Sábado";
		}
		if(timeOfPurchase.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return "Domingo";
		}
		return "";
	}

}
