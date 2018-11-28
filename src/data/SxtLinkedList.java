/** 
* Project Name:Java_Basic 
* Package Name:data 
* File Name:SxtLinkedList.java 
* Date:2018年9月17日下午10:28:28 
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

import java.io.ObjectInputStream.GetField;
import java.nio.charset.MalformedInputException;

public class SxtLinkedList
{
	private Node firstNode;
	private Node lastNode;
	private Node currentNode;
	private int size;

	public SxtLinkedList() {
		this.lastNode = null;
	}

	public SxtLinkedList(Object obj) {
		Node node = new Node(obj);
		lastNode = node;
		size++;
	}

	// 添加元素
	public void add(Object obj)
	{
		Node node = new Node(obj);
		// 空的时候直接初始化第一个元素
		if (lastNode == null)
		{
			firstNode = node;
			lastNode = firstNode;
			lastNode.setNetxNode(null);
		}
		else
		{
			for (int i = 0; i < size; i++)
			{
				// 寻找最后一个元素
				if (lastNode.getnextNode() == null)
				{
					lastNode.setNetxNode(node);
					node.setPreNode(lastNode);
					// 将新增元素设置为最后元素
					lastNode = node;
					lastNode.setNetxNode(null);
				}
				else
				{
					lastNode = lastNode.getnextNode();
				}
			}
		}
		size++;
	}

	public Object get(int index) throws Exception
	{
		Node tmp = firstNode;
		if (checkIndex(index))
		{
			for (int i = 0; i < index; i++)
			{
				if (tmp.getnextNode() != null)
				{
					tmp = tmp.getnextNode();
				}
			}
		}
		else
		{
			throw new Exception("索引不合法");
		}
		return tmp.getObj();
	}

	// 索引处插入
	public void insert(int index, Object obj)
	{
		Node node = new Node(obj);
		if (checkIndex(index))
		{
			if (index == 0)
			{
				firstNode.setPreNode(node);
				node.setNetxNode(firstNode);
				firstNode = node;
			}
			else
			{
				for (int i = 0; i < index; i++)
				{
					// 寻找index元素
					currentNode = firstNode;
					currentNode = currentNode.getnextNode();
				}
				//索引位置的连接打断，插入新节点。重建连接关系。
				Node next=currentNode.getnextNode();
				currentNode.setNetxNode(node);
				node.setPreNode(currentNode);
				node.setNetxNode(next);
				next.setPreNode(node);
			}
			size++;
		}

	}

	// del
	public void del(Object obj)
	{

	}

	// 索引处删除
	public void del(int index, Object obj)
	{

	}

	// 判断范围是否合法
	private boolean checkIndex(int index)
	{
		if (index >= 0 && index < this.size)
		{
			return true;
		}
		else
			return false;
	}

}
