 /** 
 * Project Name:Java_Basic 
 * Package Name:data 
 * File Name:BasicalData.java 
 * Date:2018年9月9日下午10:47:25 
 * 
 * Modified By：   <修改人中文名或拼音缩写>                                        
 * Modified Date:  <修改日期，格式:YYYY-MM-DD>                                   
 * Why & What is modified  <修改原因描述>
 * 
 * Copyright (c) 2016-2018, YaMai Tech
 *
 * Licensed under the YaMai License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.yamaichina.com/licenses/LICENSE-1.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package data;

/** 
 * ClassName: BasicalData <br/> 
 * Function: Java基础数据类型. <br/>
 * 
 * date: 2018年9月9日 下午10:47:25 <br/> 
 * @author ChaosBom 
 * @version  
 * @since JDK 1.8
 * 
 * @modified By：   ChaosBom <br/>                                        
 * @modified Date:2018/9/9  <br/>                                  
 * @desc：Java基础数据类型 <br/>
 * Java8种数据类型：short\int\long\float\double\boolean\char\byte
 *
 */
public class BasicalData
{

	/** 
	 * 描述这个方法的作用
	 * 
	 * @author ChaosBom 
	 * @param args 
	 */
	/** 
	 * 描述这个方法的作用
	 * 
	 * @author ChaosBom 
	 * @param args 
	 */
	public static void main(String[] args)
	{
        /** 
         *Math.sqrt()//计算平方根
         *Math.cbrt()//计算立方根
         *Math.pow(a, b)//计算a的b次方
         *Math.max( , );//计算最大值
         *Math.min( , );//计算最小值
         */ 
		//byte的封装类型
		Byte testbyte1=new Byte((byte) 258);
		Byte testbyte2=new Byte("11");
		System.out.println(testbyte1+"\n"+testbyte2);
		System.out.println("Byte数据类型是8位、有符号的，以二进制补码表示的整数");
		System.out.println("范围最小:"+String.valueOf(-Math.pow(2, 7))+"\n最大："+String.valueOf(Math.pow(2, 7)-1));

	}

}
