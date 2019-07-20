 /** 
 * Project Name:Java_Basic 
 * Package Name:algorithm 
 * File Name:Demo.java 
 * Date:2018年9月23日下午8:05:35
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
