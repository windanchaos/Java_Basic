package algorithm.LeetCodeTow;


import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Array26 {

    @Test
    public void test1() {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = {4, 9};
        assertThat("expect", solution(nums1, nums2), equalTo(result));
    }

    @Test
    public void test2() {
        int[] nums1 = {4, 1, 2, 1, 2, 1};
        int[] nums2 = {2, 2, 1, 1};
        int[] result = {2, 2, 1, 1};
        assertThat("expect", solution(nums1, nums2), equalTo(result));
    }

    @Test
    public void test3() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    public static int[] solution(int[] nums1, int[] nums2) {
        HashMap<Long, Integer> num1Hash = new HashMap<>();
        HashMap<Long, Integer> num2Hash = new HashMap<>();
        for (int nums : nums1) {
            Long key = new Long(nums);
            if (num1Hash.containsKey(key)) {
                num1Hash.put(key, num1Hash.get(key) + 1);
            } else num1Hash.put(key, 1);
        }
        for (int nums : nums2) {
            Long key = new Long(nums);
            if (num2Hash.containsKey(key)) {
                num2Hash.put(key, num2Hash.get(key) + 1);
            } else num1Hash.put(key, 1);
        }
        HashMap<Long, Integer> result = new HashMap<>();
        num1Hash.entrySet().forEach(integerIntegerEntry1 -> {
            num2Hash.entrySet().forEach(integerIntegerEntry2 -> {
                if (integerIntegerEntry1.getKey().equals(integerIntegerEntry2.getKey())) {
                    result.put(integerIntegerEntry1.getKey(), integerIntegerEntry1.getValue() >= integerIntegerEntry2.getValue() ? integerIntegerEntry2.getValue() : integerIntegerEntry1.getValue());
                    System.out.println(integerIntegerEntry1.getKey() + ":" + (integerIntegerEntry1.getValue() >= integerIntegerEntry2.getValue() ? integerIntegerEntry2.getValue() : integerIntegerEntry1.getValue()));
                }
            });
        });
        int size = 0;
        for (Map.Entry<Long, Integer> entry : result.entrySet()) {
            size = entry.getValue() + size;
        }
        int[] array = new int[size];
        int i = 0;
        for (Map.Entry<Long, Integer> entry : result.entrySet()) {
            if (entry.getValue() > 1) {
                for (int j = 0; j < entry.getValue(); j++) {
                    array[i] = entry.getKey().intValue();
                    i++;
                }
            } else {
                array[i] = entry.getKey().intValue();
                i++;
            }
        }
        return array;
    }
}
