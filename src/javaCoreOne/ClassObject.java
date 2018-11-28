package javaCoreOne;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;

public class ClassObject {

	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		LocalDate newYearEve=LocalDate.of(2018, 12, 12);
		LocalDate newYearEveAdd=newYearEve.plusDays(1000);
		System.out.println(newYearEve);
		System.out.println(newYearEveAdd);
		
		NumberFormat currencyFormater=NumberFormat.getCurrencyInstance();
		NumberFormat percentFormater=NumberFormat.getPercentInstance();
		double x=0.12;
		System.out.println(currencyFormater.format(x));
		System.out.println(percentFormater.format(x));
	}
}
