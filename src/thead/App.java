/**  
 * Project Name:Java_Basic  
 * File Name:App.java  
 * Package Name:thead  
 * Date:2018年10月15日下午10:04:30  
 * Copyright (c) 2018, yaobo7878@163.com All Rights Reserved.  
 *  
 */
package thead;

/**
 * ClassName: App <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年10月15日 下午10:04:30 <br/>
 * 
 * @author chaosbom
 * @version
 * @since JDK 1.6
 */
public class App
{

	public static void main(String[] args) throws Throwable
	{

		// Rabbit rab=new Rabbit();
		// Tortoise tor=new Tortoise();
		//
		// rab.start();
		// tor.start();
		//
		//
		// You you=new You();
		// Weddingcompany company=new Weddingcompany(you);
		// company.marry();

		Programeer pro = new Programeer();

		Thread proxy = new Thread(pro);
		proxy.start();
		for (int i = 0; i < 1000; i++)
		{
			System.out.println("eeeeee");
//			if(i%50==0) {
//				proxy.join();
//			}
		}

	}

}
