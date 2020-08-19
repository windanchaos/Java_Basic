package algorithm.array;

import java.util.*;

/*
数组交集
给定两个数组，编写一个函数来计算它们的交集。
说明：
    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
    我们可以不考虑输出结果的顺序。

 */
public class ArrayIntersection {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2,1,0};
        System.out.println(Arrays.toString(solution(nums1, nums2)));
    }

    public static int[] solution(int[] nums1, int[] nums2) {
        List list = new ArrayList<>();
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (hash.containsKey(nums1[i])) {
                hash.put(nums1[i], hash.get(nums1[i]) + 1);
            } else
                hash.put(nums1[i], 1);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (hash.containsKey(nums2[j])) {
                hash.put(nums2[j], hash.get(nums2[j]) - 1);
                if(hash.get(nums2[j])>=0){
                    list.add(nums2[j]);
                }
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = (int) list.get(i);
        }
        return array;
    }
}
