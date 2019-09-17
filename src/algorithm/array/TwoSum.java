package algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]


 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution2(new int[]{3, 2, 3}, 6)));

    }

    /*
    暴力破解。这种破解是N*N的复杂度，效率不行
     */
    public static int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == tmp) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /*
    利用hashmap的搜索能力。直接进了入前20%算力，战胜86%。执行用时：7 ms
     */
    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int needNumber = target - nums[i];
            if (map.containsKey(needNumber)) {
                if (map.get(needNumber) != i) {
                    return new int[]{map.get(needNumber), i};
                }
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /*
    大神级的算力,执行用时：1ms。拷贝过来研究。
     */
    public static int[] solution3(int[] nums, int target) {
        int cap = 4;
        while (cap < nums.length)
            cap <<= 1;
        int[] map = new int[cap + nums.length * 3];
        int idx = cap--;
        NEXT:
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            int index = key & cap;
            int ei;
            for (ei = map[index]; ei != 0; ei = map[ei]) {
                if (map[ei + 1] == key) {
                    return new int[]{map[ei + 2], i};
                }
            }
            key = nums[i];
            index = key & cap;
            for (ei = map[index]; ei != 0; ei = map[ei]) {
                if (map[ei + 1] == key)
                    continue NEXT;
            }
            ei = idx++;
            map[ei] = map[index];
            map[index] = ei;
            map[idx++] = key;
            map[idx++] = i;
        }
        return null;
    }
}
