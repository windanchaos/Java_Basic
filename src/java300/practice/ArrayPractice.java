package java300.practice;

import java.util.Scanner;

/*
120.	【上机】定义一个长度为10 的一维字符串数组，在每一个元素存放一个单词；然
        后运行时从命令行输入一个单词，程序判断数组是否包含有这个单词，包含这个
        单词就打印出“Yes”，不包含就打印出“No”
125.	【上机】用二重循环求出二维数组b所有元素的和：
	int[][] b={{11},{21,22},{31,32,33}}
 */
public class ArrayPractice {
    public static void main(String[] args) {
        String[] words=new String[]{"discipline","utility","performs","invocation","synchronized","encapsulate","sentinel","serialization","utilization","horizontal"};
        System.out.println("输入单词，将返回数组中是否包含它,我们的数组包括:");
        for(String word:words){
            System.out.print(word+" ");
        }
        System.out.println("请输入单词:");
        Scanner sc = new Scanner(System.in);
        String enterWord = sc.nextLine();
        boolean contain=false;
        for(String word:words){
           if(enterWord.equalsIgnoreCase(word)){
               System.out.println("你输入了数组当中有的单词："+enterWord);
               contain=true;
               break;
           }
        }
        if(!contain)
            System.out.println("你输入的单词："+enterWord+"不在数组当中");
        int[][] b={{11},{21,22},{31,32,33}};
        int sum=0;
        for(int[] tmp:b){
            for(int num:tmp){
                sum=num+sum;
            }
        }
        System.out.println("二维数组的和为："+sum);
    }
}
