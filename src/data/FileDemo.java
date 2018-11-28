 /** 
 * Project Name:Java_Basic 
 * Package Name:data 
 * File Name:FileDemo.java 
 * Date:2018年9月14日下午10:15:46 
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
import java.io.File;
import java.nio.file.*;

import org.omg.CORBA.PUBLIC_MEMBER;
/** 
 * ClassName: FileDemo <br/> 
 * Function: TODO 功能说明. <br/>
 * 
 * date: 2018年9月14日 下午10:15:46 <br/> 
 * @author ChaosBom 
 * @version  
 * @since JDK 1.8
 * 
 * @modified By：   <修改人> <br/>                                        
 * @modified Date:<修改日期>  <br/>                                  
 * @desc：修改日志 <修改描述> <br/>
 */
public class FileDemo
{

	/** 
	 * 打印文件目录的递归函数
	 * 
	 * @author ChaosBom 
	 * @param args 
	 */
	public static void printFiles(File file,int level){
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()){
			for(File filepath:file.listFiles()){
				printFiles(filepath,level+1);
			}
		}
		
	}
	public static void main(String[] args)
	{
		//打印树状目录
		File parentFile=new File("D:\\BaiduNetdiskDownload");
		printFiles(parentFile,0);

	}

}
