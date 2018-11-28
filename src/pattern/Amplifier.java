/**  
 * Project Name:Java_Basic  
 * File Name:Amplifier.java  
 * Package Name:pattern  
 * Date:2018年10月8日下午11:21:47  
 * Copyright (c) 2018, yaobo7878@163.com All Rights Reserved.  
 *  
 */
package pattern;

/**  
 * ClassName: Amplifier <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason: TODO ADD REASON(可选). <br/>  
 * date: 2018年10月8日 下午11:21:47 <br/>  
 *  
 * @author chaosbom  
 * @version   
 * @since JDK 1.6  
 */
public class Amplifier
{
	private Voice v;

	public Voice getV()
	{
		return v;
	}

	public void setV(Voice v)
	{
		this.v = v;
	}

	/**  
	 * Creates a new instance of Amplifier.  
	 *  
	 * @param v  
	 */  
	
	public Amplifier(Voice v) {
		super();
		this.v = v;
	}
	
	public void say() {
		System.out.println(v.getVoice()*1000);
	}
	
}
