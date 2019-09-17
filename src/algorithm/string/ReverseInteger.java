package algorithm.string;

import java.util.Arrays;

/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321

 示例 2:

输入: -123
输出: -321

示例 3:

输入: 120
输出: 21

注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.print(solution(123));
    }
    public static int solution(int x){
        char[] y=Integer.toString(x).toCharArray();
        char[] back=new char[y.length];
        System.out.println(y);
        if(y[0]=='-'){
            back[0]='-';
            for(int i=y.length-1;i>0;i--){
                back[y.length-1-i]=y[i];
            }
            return Integer.parseInt(Arrays.toString(back));
        }else {
            for(int i=y.length-1;i>-1;i--){
                back[y.length-1-i]=y[i];
            }
            return Integer.parseInt(Arrays.toString(back).substring(1,y.length));
        }
    }
}
