package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
数组交集
给定两个数组，编写一个函数来计算它们的交集。
说明：
    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
    我们可以不考虑输出结果的顺序。

 */
public class ArrayIntersection {

    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++){
            list1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            list2.add(nums2[i]);
        }
        list1.retainAll(list2);
        int[] a=new int[list1.size()];
        for(int i:list1){
            int j=0;
            a[j]=i;
            j++;
        }
        return a;
    }
}
