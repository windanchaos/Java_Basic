/** 
* Project Name:Java_Basic 
* Package Name:data 
* File Name:IOdemo.java 
* Date:2018年9月28日下午10:21:05 
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

import java.awt.List;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Base64.Decoder;
import java.util.Iterator;

/**
 * ClassName: IOdemo <br/>
 * Function: TODO 功能说明. <br/>
 * 
 * date: 2018年9月28日 下午10:21:05 <br/>
 * 
 * @author chaosbom
 * @version
 * @since JDK 1.8
 * 
 * @modified By： <修改人> <br/>
 * @modified Date:<修改日期> <br/>
 * @desc：修改日志 <修改描述> <br/>
 */
public class IOdemo
{

	public static void main(String[] args)
	{
//		try
//		{
//			copydir("D:\\有道笔记\\yaobo7878@163.com", "D:\\tmp");
//		} catch (FileNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		SplitFile sp=new SplitFile("D:\\Code\\setting\\ym_formatter.xml", "D:\\Code\\setting", 500);
		try
		{
			System.out.println(sp.getSplitNumber());
			sp.split();
		} catch (IOException e)
		{
			  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
			
		}
	}

	/**
	 * 
	 * 拷贝文件，传入string
	 * 
	 * @author chaosbom
	 * @param source
	 * @param destination
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void copyfile(String source, String destination) throws IOException, FileNotFoundException
	{
		File file = new File(source);
		File file2 = new File(destination);
		copyfile(file, file2);
	}

	/**
	 * 
	 * 拷贝文件，传入File对象
	 * 
	 * @author chaosbom
	 * @param source
	 * @param destination
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void copyfile(File source, File destination) throws IOException, FileNotFoundException
	{
		InputStream st = null;
		OutputStream out = null;
		if (source.isFile())
		{
			// 选择流
			st = new FileInputStream(source);
			out = new FileOutputStream(destination);
			// 流中传输最小的单位大小
			byte[] bs = new byte[20];
			int len = 0;
			while (-1 != (len = st.read(bs)))
			{
				out.write(bs, 0, len);
			}
			out.close();
			st.close();
		}
		else
			throw new IOException();
	}

	/**
	 * 
	 * 文件夹拷贝
	 * 
	 * @author chaosbom
	 * @param source
	 * @param destination
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void copydir(String source, String destination) throws FileNotFoundException, IOException
	{
		File sourcefile = new File(source);
		File destinationfile = new File(destination);
		copydir(sourcefile, destinationfile);
	}

	/**
	 * 
	 * 文件夹拷贝
	 * 
	 * @author chaosbom
	 * @param source
	 * @param destination
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void copydir(File sourcefile, File destinationfile) throws FileNotFoundException, IOException
	{
		if (sourcefile.isFile() && sourcefile.exists())
		{
			File des = new File(destinationfile, sourcefile.getName());
			copyfile(sourcefile, des);
		}
		if (sourcefile.isDirectory() && sourcefile.exists())
		{
			File des = new File(destinationfile, sourcefile.getName());
			des.mkdirs();
			// 递归
			for (File filepath : sourcefile.listFiles())
			{
				copydir(filepath, des);
			}
		}
	}
}

/**
 * 分割文件类 输入源文件路径，目标目录，单个分割文件的大小 输出分割的子文件
 * 
 */
class SplitFile
{
	private String sourceFilePath, destFolderPath;
	private int splitFileSize;
	private File sourceFile, destFolder;

	private int SplitNumber;

	// 构造
	public SplitFile(String sourceFilePath, String destFolderPath) {
		this.sourceFilePath = sourceFilePath;
		this.destFolderPath = destFolderPath;
		this.sourceFile = new File(sourceFilePath);
		this.destFolder = new File(destFolderPath);
		this.splitFileSize = 1024;
	}

	public SplitFile(String sourceFilePath, String destFolderPath, int splitFileSize) {
		this(sourceFilePath, destFolderPath);
		this.splitFileSize = splitFileSize < 300 ? 300 : splitFileSize;
	}

	public SplitFile(File sourceFile, File destFolder) {
		this.sourceFile = new File(sourceFilePath);
		this.destFolder = new File(destFolderPath);
		this.splitFileSize = 1024;
	}

	public SplitFile(File sourceFile, File destFolder, int splitFileSize) {
		this(sourceFile, destFolder);
		this.splitFileSize = splitFileSize < 300 ? 300 : splitFileSize;
	}

	// 实现功能的主函数
	public void split() throws IOException
	{
		RandomAccessFile st = new RandomAccessFile(sourceFile, "r");
		List filesNames = getSplitFilesName();
		// 流中传输最小的单位大小
		byte[] bs = new byte[300];
		int len = 0;
		//输出流
		BufferedOutputStream out=null;
		//循环体分割文件
		for (int i = 0; i < SplitNumber; i++)
		{
			//输入流起始位置
			long splitFileSizecout = 0;
			//输入流的剩余文件大小
			long splitFileSizeleft=sourceFile.length()-splitFileSizecout;
			//分隔符的名字
			String deString=filesNames.getItem(i);
			//输入流
			st.seek(splitFileSizecout);
			while (-1 != (len = st.read(bs)))
			{
				out=new BufferedOutputStream(new FileOutputStream(deString));
				//分块内byte[]填充块
				if(splitFileSizeleft-len>0) {				
					out.write(bs,0,len);
					out.flush();
					//填充后减少剩余块长度
					splitFileSize-=len;
					splitFileSizecout = splitFileSizecout + splitFileSize;
				}else {
					out.write(bs,0,splitFileSize);
					out.close();
					break;
				}
				}
				
		}
		
		st.close();
	}

	// 取分块数的方法
	public int getSplitNumber()
	{
		float filesize = sourceFile.length();
		if (sourceFile.isFile() && filesize > 0)
		{
			SplitNumber = (int) Math.ceil(filesize / splitFileSize);
		}
		else
		{
			return 1;
		}
		return SplitNumber;
	}

	// 构建分割文件名
	private List getSplitFilesName()
	{
		List filesName=new List();
		String sourceFilepath = sourceFile.getPath();
	
		for (int i = 0; i < SplitNumber; i++)
		{
			String name = sourceFilepath + "_split_part_" + i;
			filesName.add(name);
		}
		return filesName;
	}
}
