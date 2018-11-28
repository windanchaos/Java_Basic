/**  
 * Project Name:Java_Basic  
 * File Name:Voice.java  
 * Package Name:pattern  
 * Date:2018年10月8日下午11:19:17  
 * Copyright (c) 2018, yaobo7878@163.com All Rights Reserved.  
 *  
 */
package pattern;

/**  
 * ClassName: Voice <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2018年10月8日 下午11:19:17 <br/>  
 *  
 * @author chaosbom  
 * @version   
 * @since JDK 1.6  
 */
public class Voice
{
	private int voice=10;

	/**  
	 * Creates a new instance of Voice.  
	 *  
	 * @param voice  
	 */  
	
	public Voice() {
	}

	public int getVoice()
	{
		return voice;
	}

	public void setVoice(int voice)
	{
		this.voice = voice;
	}
	
	public void say() {
		System.out.println(voice);
	}
}
