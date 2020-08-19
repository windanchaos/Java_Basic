package algorithm.LeetCodeTow;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */
public class Array28 {
    @Test
    public void test1() {
        int[] nums1 = {4, 0, 5, 6};
        int[] nums2 = {9, 0, 1, 0, 9};
        int[] nums3 = {4, 9, 0};
        int[] nums4 = {1, 9};
        int[] nums5 = {9};
        int[] result1 = {4, 5, 6, 0};
        int[] result2 = {9, 1, 9, 0, 0};
        int[] result3 = {4, 9, 0};
        int[] result4 = {1, 9};
        int[] result5 = {9};
        moveZeroes2(nums1);
        moveZeroes2(nums2);
        moveZeroes2(nums3);
        moveZeroes2(nums4);
        moveZeroes2(nums5);
        assertThat("expect", nums1, equalTo(result1));
        assertThat("expect", nums2, equalTo(result2));
        assertThat("expect", nums3, equalTo(result3));
        assertThat("expect", nums4, equalTo(result4));
        assertThat("expect", nums5, equalTo(result5));
    }

    public static int findFirstZero(int[] nums,int index){
        for (int i = index; i < nums.length; i++) {
            //记录0的index
            if (nums[i] == 0) {
                index = i;
                return index;
            }
        }
        return -1;
    }
    public static void moveZeroes(int[] nums) {
        if(nums.length==1 || nums==null || findFirstZero(nums,0)==-1) return;
        int index = findFirstZero(nums,0);
        for (int i = index; i < nums.length; i++) {
            //第一个不是0的数和第一个0交换
            if(nums[i] != 0){
                nums[index]=nums[i];
                nums[i]=0;
                //交换之后，重置i，继续寻找第一个不是0的数,index需要自加1
                i=findFirstZero(nums,++index);
            }
        }
    }

    //第二种算法，上面的效率太低。提高了2ms，但是还是不够快。多余的动作在寻找不是0这里。
    public static void moveZeroes2(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]!=0){
                        nums[i]=nums[j];
                        nums[j]=0;
                        break;
                    }
                }
            }
        }
    }
    //第三种官方最佳
    public static void moveZeroes3(int[] nums){
        if(nums==null) {
            return;
        }
        //数组集合被分成0和非零，那么依次自增j赋非0值，剩下的就是0
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        for (int i=j;i<nums.length;i++){
            nums[i]=0;
        }
    }
    //第三种，是我很久以前写的，有个很可爱的k。记录找过的数。
    public void moveZeroes4(int[] nums) {
        //主要错误在边界识别上，i一开写的是i<size-1；不对
        //设一个标记记录第一个找打不是0的下标
        int k=1;
        lable:
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue lable;
            }else{
                for (int j = i + k; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        continue lable;
                    }else
                        //向后找1次，加1次，直到不为0。那么下一次i到j之间找过的就不用再找了。
                        k++;
                }
            }
        }
    }
    //基于第三种优化第二种，本质上二和三是一个思路。不比官方慢！完美
    public static void moveZeroes5(int[] nums){
        int k=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                for(int j=i+k;j<nums.length;j++){
                    if(nums[j]!=0){
                        nums[i]=nums[j];
                        nums[j]=0;
                        break;
                    }
                    //i处为0，向后找找到非0。结构类似 000000033第二个0到3之间不用再找了
                    k++;
                }
            }
        }
    }
}

