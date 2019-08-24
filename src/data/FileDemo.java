 /** 
 * Project Name:Java_Basic 
 * Package Name:data 
 * File Name:FileDemo.java 
 * Date:2018年9月14日下午10:15:46 
 */ 
package data;
import java.io.File;
import java.nio.file.*;
import java.util.LinkedList;

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
		System.out.println(file.getPath());
		LinkedList linkedList=new LinkedList();
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
