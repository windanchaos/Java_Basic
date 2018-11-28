/**  
 * Project Name:Java_Basic  
 * File Name:ThreadSleepDemo.java  
 * Package Name:thead  
 * Date:2018年10月16日下午10:21:40  
 * Copyright (c) 2018, yaobo7878@163.com All Rights Reserved.  
 *  
 */
package thead;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**  
 * ClassName: ThreadSleepDemo <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2018年10月16日 下午10:21:40 <br/>  
 *  
 * @author chaosbom  
 * @version   
 * @since JDK 1.6  
 */
public class ThreadSleepDemo
{

	public static void main(String[] args) throws InterruptedException
	{
		Date endDate=new Date(15000);
		long end =endDate.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endDate));
			end=end-1000;
			endDate=new Date(end);
			Thread.sleep(1000);
			System.out.println(Thread.currentThread());
			if(end<=0) {
				break;
			}
		}
	}
}
