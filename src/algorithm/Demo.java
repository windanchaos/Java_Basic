 /** 
 * Project Name:Java_Basic 
 * Package Name:algorithm 
 * File Name:Demo.java 
 * Date:2018年9月23日下午8:05:35 
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
package algorithm;


public class Demo
{

	public static void main(String[] args)
	{
		Integer array[]={10,37,2,95,57,25,47,75,43,22};
		for(int i=0;i<array.length;i++){
			for(int j=i;j<array.length;j++){
				if(array[i]<array[j]){
					int tmp;
					tmp=array[i];
					array[i]=array[j];
					array[j]=tmp;
				}
			}
		}
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}

}
