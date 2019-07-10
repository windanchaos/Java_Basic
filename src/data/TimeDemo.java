 /** 
 * Project Name:Java_Basic 
 * Package Name:data 
 * File Name:TimeDemo.java 
 * Date:2018年9月12日下午10:46:48 
 */ 
package data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/** 
 * ClassName: TimeDemo <br/> 
 * Function: TODO 功能说明. <br/>
 * 
 * date: 2018年9月12日 下午10:46:48 <br/> 
 * @author ChaosBom 
 * @version  
 * @since JDK 1.8
 * 
 * @modified By：   <修改人> <br/>                                        
 * @modified Date:<修改日期>  <br/>                                  
 * @desc：修改日志 <修改描述> <br/>
 */
public class TimeDemo
{

	/** 
	 * 描述这个方法的作用
	 * 
	 * @author ChaosBom 
	 * @param args 
	 */
	public static void main(String[] args)
	{
		
		Date date=new Date();
		long t=System.currentTimeMillis();
		System.out.println(date);
		System.out.println(t);
		System.out.println(date.toString());
		//时间转字符
		DateFormat df=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
		System.out.println(df.format(date));
		String adate="2018-10-12 23:23:23";
		//字符转时间
		DateFormat df2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try
		{
			Date d2=df2.parse(adate);
			System.out.println(d2);
			
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//时刻和日期转化,月和星期几和中文有差异
		Calendar c1=new GregorianCalendar();
		c1.set(2019, 11, 14, 11, 13,22);
		System.out.println(df.format(c1.getTime()));
		//时间计算
		c1.add(Calendar.YEAR, 3);
		System.out.println(df.format(c1.getTime()));
		//可视化日历
		System.out.println("按2011-10-2格式输入你要打印的该月日历");
		DateFormat df3=new SimpleDateFormat("yyyy-MM-dd");
		Scanner scanner =new Scanner(System.in);
		String sd3=scanner.nextLine();
		Calendar c3=new GregorianCalendar();
		try
		{
			Date d3=df3.parse(sd3);
			c3.setTime(d3);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		c3.set(c3.get(Calendar.YEAR),c3.get(Calendar.MONTH) , 1);
		int startDay=c3.get(Calendar.DAY_OF_WEEK);
		int monthDays=c3.getActualMaximum(Calendar.DATE);
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for(int i=1;i<startDay;i++){
			System.out.print("\t");
		}
		for(int i=1;i<=monthDays;i++){
				System.out.print(i+"\t");
				if((i+startDay-1)%7==0){
				System.out.println();
			}
		}
	}

}
