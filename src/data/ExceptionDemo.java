 /** 
 * Project Name:Java_Basic 
 * Package Name:data 
 * File Name:ExceptionDemo.java 
 * Date:2018年9月16日上午10:20:23 
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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/** 
 * ClassName: ExceptionDemo <br/> 
 * Function: TODO 功能说明. <br/>
 * 
 * date: 2018年9月16日 上午10:20:23 <br/> 
 * @author ChaosBom 
 * @version  
 * @since JDK 1.8
 * 
 * @modified By：   <修改人> <br/>                                        
 * @modified Date:<修改日期>  <br/>                                  
 * @desc：修改日志 <修改描述> <br/>
 */
public class ExceptionDemo
{

	/** 
	 * 描述这个方法的作用
	 * 
	 * @author ChaosBom 
	 * @param args 
	 */
	public static void main(String[] args)
	{
		//unchecked exception
		//int i=1/0;
		//checked exception
		try
		{
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileReader reader=null;
		try
		{
			reader=new FileReader("D://hah.txt");
			char c=(char)reader.read();
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				if(reader!=null)
				reader.close();
			}catch (IOException e) {
				e.printStackTrace();				
			}
			
		}
		
	}

}
