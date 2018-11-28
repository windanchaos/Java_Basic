/**  
 * Project Name:Java_Basic  
 * File Name:app_1.java  
 * Package Name:pattern  
 * Date:2018年10月8日下午11:25:13  
 * Copyright (c) 2018, yaobo7878@163.com All Rights Reserved.  
 *  
 */
package pattern;

/**  
 * ClassName: app_1 <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2018年10月8日 下午11:25:13 <br/>  
 *  
 * @author chaosbom  
 * @version   
 * @since JDK 1.6  
 */
public class app_1
{

	/**  
	 * 类和类之间的关系：
	 * 1、依赖：形参|局部变量
	 * 2、关联：属性
	 * 			聚合：属性整体与部分，不一致的生命周期
	 * 			组合：属性整体与部分，一致的生命周期
	 * 3、继承：父子类关系
	 * 4、实现：接口和实现类关系
	 * @author chaosbom  
	 * @param args  
	 * @since JDK 1.6  
	 */
	public static void main(String[] args)
	{
		Voice voice=new Voice();
		voice.say();
		Amplifier amplifier=new Amplifier(voice);
		amplifier.say();
		
	}

}
