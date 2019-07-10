/** 
* Project Name:Java_Basic 
* Package Name:data 
* File Name:CollectionDemo.java 
* Date:2018年9月16日下午8:46:44 
* 
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