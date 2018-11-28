/** 
* Project Name:Java_Basic 
* Package Name:data 
* File Name:CollectionDemo.java 
* Date:2018年9月16日下午8:46:44 
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
import java.util.ArrayList;
import java.util.Date;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.omg.CORBA.PRIVATE_MEMBER;

public class CollectionDemo
{

	/**
	 * 描述这个方法的作用
	 * 
	 * @author ChaosBom
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArrayList<Object> list = new ArrayList<Object>();
		list.add("adb");
		list.add(1122);
		list.add(new Dog());
		list.add(new Date());
		
		ArrayList<Object> list2 = new ArrayList<Object>();
		list2.add("adb");
		list2.add(1122);
		list.add(list2);
		System.out.println(list.size());
		list.addAll(list2);
		System.out.println(list.size());
		int a[]={12,3,5,66,123};
		int l=a.length;
		a[--l]=0;
		for( int i=0;i<l+1;i++){
			System.out.println(a[i]);
		}
		
		SxtLinkedList s=new SxtLinkedList();
		s.add("aaaa");
		s.add("bbbb");
		s.add("Cccc");
		s.add("dddd");
		s.insert(0, "eeee");
		try
		{
			System.out.println(s.get(1).toString());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Dog
{

}

// 自己实现有arraylist
class MyArrayList
{
	private Object[] elementData;
	private int size;

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0)
		{
			
		}
		else
			elementData = new Object[initialCapacity];
	}

	public MyArrayList() {
		this(10);
	}
}