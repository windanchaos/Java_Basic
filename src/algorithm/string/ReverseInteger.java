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

/*
已经战胜 68.46 % 的 java 提交记录
思路：数字转string转char数组，对char数组做变化，再char转string转int。string转int的时，如果异常表明溢出则返回0.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.print(solution2(-123));
    }

    public static int solution(int x) {
        char[] y = Integer.toString(x).toCharArray();
        char[] back = new char[y.length];
        if (y[0] == '-') {
            back[0] = '-';
            for (int i = 1; i < y.length; i++) {
                back[i] = y[y.length - i];
            }
            int num;
            try {
                num = Integer.parseInt(String.valueOf(back));
                return num;
            } catch (Exception e) {
                return 0;
            }
        } else {
            for (int i = y.length - 1; i > -1; i--) {
                back[y.length - 1 - i] = y[i];
            }
            int num;
            try {
                num = Integer.parseInt(String.valueOf(back));
                return num;
            } catch (Exception e) {
                return 0;
            }
        }
    }

    /*
    思路二，数学转换
    这里最大的问题，是溢出判定
    执行用时 :3 ms, 在所有 Java 提交中击败了92.22% 的用户
    内存消耗 :34.1 MB, 在所有 Java 提交中击败了78.39%的用户
     */
    public static int solution2(int x) {
        int new_num = 0;
        while (x != 0) {
            //极值减去new_num加起来的值比较加前的值
            if (new_num > 0 && new_num > (Integer.MAX_VALUE - x % 10) / 10) {
                return 0;
            }
            //极值减去new_num加起来的值比较加前的值
            if (new_num < 0 && new_num < (Integer.MIN_VALUE - x % 10) / 10) {
                return 0;
            }
            new_num = new_num * 10 + x % 10;
            x = x / 10;
        }
        return new_num;
    }
}
