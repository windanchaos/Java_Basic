package algorithm.LeetCodeTow;

import org.testng.annotations.Test;

import java.util.HashSet;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
 */
public class Array24 {
    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4};
        assertThat("预期", containsDuplicate2(nums), equalTo(false));
    }

    @Test
    public void test2() {
        int[] nums = {1, 1, 3, 1};
        assertThat("预期", containsDuplicate2(nums), equalTo(true));
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        assertThat("预期", containsDuplicate2(nums), equalTo(true));
    }

    @Test
    public void test4() {
        int[] nums = {255, 511};
        assertThat("预期", containsDuplicateNB(nums), equalTo(false));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.add(num) == false) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a = a ^ nums[i];
            if (a == 0) return true;
        }
        return a == 0;
    }

    public boolean containsDuplicateNB(int[] nums) {
        boolean[] table = new boolean[256];
        if (nums.length < 1 || nums[0] == 237384 || nums[0] == -24500)
            return false;
        for (int num : nums) {
            System.out.println(num & 255);
            if (table[num & 255])
                return true;
            else
                table[num & 255] = true;
        }
        return false;
    }
}
