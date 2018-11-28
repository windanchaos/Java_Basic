package javaCoreOne.CalendarTest;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarTest {

	public static void main(String[] args) {
		LocalDate date=LocalDate.now();
		int month=date.getMonthValue();
		int today=date.getDayOfMonth();
		
		//当月最小
		date=date.minusDays(today-1);
		//初始星期
		DayOfWeek weekday=date.getDayOfWeek();
		int value=weekday.getValue();//1=Monday,7=Sunday
		System.out.println("Mon\tTue\tWeb\tThu\tFri\tSat\tSun");
		for(int i=1;i<value;i++) {
			System.out.print("\t");
		}
		
		while(date.getMonthValue()==month) {
			System.out.printf("%3d",date.getDayOfMonth());
			//打印今天跟星号
			if(date.getDayOfMonth()==today) {
				System.out.print("*\t");
			}else {
				System.out.print("\t");
			}
			date=date.plusDays(1);
			//
			if(date.getDayOfWeek().getValue()==1)
				System.out.println();
		}
		
		

	}

}
