package algorithm.array;

import java.util.Arrays;

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:
    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。
*/
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        solution2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    下面方法只战胜了8.5%的用户
    算法的时间复杂度2次方
     */
    public static void solution(int[] nums) {
        int size = nums.length;
        //主要错误在边界识别上，i一开写的是i<size-1；不对
        lable:
        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                continue lable;
            }
            for (int j = i + 1; j < size; j++) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    continue lable;
                }
            }
        }
    }

    /*
    优化一下
    执行用时 :1 ms, 在所有 Java 提交中击败了96.96% 的用户
    内存消耗 :40.6 MB, 在所有 Java 提交中击败了55.50%的用户
     */
    public static void solution2(int[] nums) {
        int size = nums.length;
        //主要错误在边界识别上，i一开写的是i<size-1；不对
        //设一个标记记录第一个找打不是0的下标
        int k = 1;
        lable:
        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                continue lable;
            } else {
                for (int j = i + k; j < size; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        continue lable;
                    } else
                        //向后找1次，加1次，直到不为0。那么下一次i到j之间找过的就不用再找了。
                        k++;
                }
            }
        }
    }

    /*
    网友的思路
     */
    public static void solution3(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=0){
                nums[index]=nums[i];
                //如果索引不同，那么意味着i那个数不必存在了，改成0.
                if(index++!=i){
                    nums[i]=0;
                }
            }
        }
    }
}
