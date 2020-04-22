package algorithm.LeetCodeTow;


import org.junit.Test;

import java.util.HashSet;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4
 */
public class Array25 {

    @Test
    public void test1() {
        int[] nums = {2, 2, 1};
        assertThat("expect", solution(nums), equalTo(1));
    }

    @Test
    public void test2() {
        int[] nums = {4, 1, 2, 1, 2};
        assertThat("expect", solution(nums), equalTo(4));
    }

    public static int solution(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a = a ^ num;
        }
        return a;
    }
}
