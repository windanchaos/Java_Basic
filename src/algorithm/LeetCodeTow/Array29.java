package algorithm.LeetCodeTow;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class Array29 {
    @Test
    public void test(){
        int[] nums = {2, 7, 11, 15};
        int[] index ={0,1};
        int[] index2 ={1,3};
        assertThat("expect", index, equalTo(twoSum(nums,9)));
        assertThat("expect", index2, equalTo(twoSum(nums,22)));
    }
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==(target-nums[i])){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
}
