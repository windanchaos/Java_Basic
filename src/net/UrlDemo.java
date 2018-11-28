/**  
 * Project Name:Java_Basic  
 * File Name:UrlDemo.java  
 * Package Name:net  
 * Date:2018年10月19日下午1:42:57  
 * Copyright (c) 2018, yaobo7878@163.com All Rights Reserved.  
 *  
 */
package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo
{


	public static void main(String[] args) throws IOException
	{
		URL url=new URL("http://www.baidu.com");
		InputStream in=url.openStream();
//		byte[] flush =new byte[1024];
//		int len=0;
//		while(-1!=(len=in.read(flush))) {
//			System.out.print(new String(flush,0,len));
//		}
		
		System.out.println("======================");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(in,"utf-8"));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8"));
		String html=null;
		while((html=br.readLine())!=null){
			//System.out.print(html);
			writer.append(html);
			writer.newLine();
			
		}
		
		writer.close();
		br.close();
		
		
	}

}
