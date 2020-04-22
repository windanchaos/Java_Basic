package algorithm.LeetCodeTow;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
[1,2,3,4,5,6,7]
[7,1,2,3,4,5,6]
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Array23 {
    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {5, 6, 7, 1, 2, 3, 4};
        assertThat("期望是", solution(nums, 3), equalTo(nums2));

    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums3 = {7, 1, 2, 3, 4, 5, 6};
        assertThat("期望是", solution(nums, 1), equalTo(nums3));
    }

    /*
    老实算法，慢
     */
    public static int[] solution(int[] array, int k) {

        for (int i = 0; i < k; i++) {
            rotate(array);
        }
        return array;
    }

    public static int[] rotate(int[] array) {
        int temp = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = temp;
        return array;
    }
}
