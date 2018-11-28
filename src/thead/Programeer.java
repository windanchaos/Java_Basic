/**  
 * Project Name:Java_Basic  
 * File Name:Programeer.java  
 * Package Name:thead  
 * Date:2018年10月15日下午10:39:07  
 * Copyright (c) 2018, yaobo7878@163.com All Rights Reserved.  
 *  
 */
package thead;

/**  
 *使用Runnable创建线程
 *1、类实现Runnable接口，并重写run()  ===真实角色
 *2、启动多线程 使用静态代理
 *	1）、创建真实角色；
 *	2）创建代理角色+真实角色引用
 *	3）调用start(),启动多线程
 * @author chaosbom  
 * @version   
 * @since JDK 1.6  
 */
public class Programeer implements Runnable
{

	@Override
	public void run()
	{
		  for(int i=0;i<1000;i++) {
			  System.out.println("hahahahaahah");
		  }
	}
	
}
