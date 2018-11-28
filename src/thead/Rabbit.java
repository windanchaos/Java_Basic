/**  
 * Project Name:Java_Basic  
 * File Name:Rabbit.java  
 * Package Name:thead  
 * Date:2018年10月15日下午9:55:04  
 * Copyright (c) 2018, yaobo7878@163.com All Rights Reserved.  
 *  
 */
package thead;

/**
 * ClassName: Rabbit <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年10月15日 下午9:55:04 <br/>
 * 
 * @author chaosbom
 * @version
 * @since JDK 1.6
 * 多线程创建方式
 * 1、定义类，继承Thread，重写run方法
 * 2、调用类对象的start()方法，将调度交给CPU。
 */
class Rabbit extends Thread
{

	@Override
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println("兔子跑了"+i+"步");
		}
	}
}

class Tortoise extends Thread
{

	@Override
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println("乌龟跑了"+i+"步");
		}
	}
}
