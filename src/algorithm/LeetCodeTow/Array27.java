package algorithm.LeetCodeTow;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */
public class Array27 {
    @Test
    public void test1() {
        int[] nums1 = {4, 9, 9};
        int[] nums2 = {9, 9, 9, 9, 9};
        int[] nums3 = {4, 9, 8};
        int[] nums4 = {9};
        int[] result1 = {5, 0,0};
        int[] result2 = {1,0, 0,0,0,0};
        int[] result3 = {4, 9, 9};
        int[] result4 = {1,0};
        assertThat("expect", solution(nums1), equalTo(result1));
        assertThat("expect", solution(nums2), equalTo(result2));
        assertThat("expect", solution(nums3), equalTo(result3));
        assertThat("expect", solution(nums4), equalTo(result4));
    }

    public static int[] solution(int[] a) {
        for (int i = a.length - 1; i > -1; i--) {
            //进位控制
            if (a[i] + 1 > 9) {
                a[i] = 0;
            } else {
                a[i] = a[i] + 1;
                break;
            }
        }
        //最高位检查
        if(a[0]==0){
            int[] b=new int[a.length+1];
            b[0]=1;
            for(int i=1;i<a.length;i++){
                b[i]=a[i-1];
            }
            return b;
        }
        return a;
    }
}
