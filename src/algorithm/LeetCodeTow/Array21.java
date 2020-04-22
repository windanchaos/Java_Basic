package algorithm.LeetCodeTow;


import org.junit.Test;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
示例 1:

给定数组 nums = [1,1,2],

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。
 */
public class Array21 {
    @Test
    public void test1() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertThat("期望长度是", solution(nums), equalTo(5));
    }

    @Test
    public void test2() {
        int[] nums2 = {1, 1, 2};
        assertThat("期望长度是", solution(nums2), equalTo(2));
    }

    @Test
    public void test3() {
        int[] nums3 = {1, 1};
        assertThat("期望长度是", solution(nums3), equalTo(1));
    }

    @Test
    public void test4() {
        int[] nums4 = {1};
        assertThat("期望长度是", solution(nums4), equalTo(1));
    }

    @Test
    public void test5() {
        int[] nums5 = {};
        assertThat("期望长度是", solution(nums5), equalTo(0));
    }

    @Test
    public void test6() {
        int[] nums6 = {1, 2, 3, 4, 5};
        assertThat("期望长度是", solution(nums6), equalTo(5));

    }

    @Test
    public void test7() {
        int[] nums7 = {1, 2, 3, 4, 5, 5};
        assertThat("期望长度是", solution(nums7), equalTo(5));

    }

    public static int solution(int[] array) {
        int index = 0;
        if (array.length < 2) return array.length;
        for (int i = 0; i < array.length - 1 && index < array.length - 1; i++) {
            //遍历，如果当前数和其后的数不相等，则：index加1后接住新值
            if (array[i] != array[i + 1]) {
                array[++index] = array[i + 1];
            }
        }
        return index + 1;
    }

}
