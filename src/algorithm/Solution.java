package algorithm;

public class Solution {
	    public static void rotate(int[] nums, int k) {
	        int len=nums.length;
	        for(int i=0;i<k;i++){
	            int tmp=nums[len-1];
	            for(int j=len-2;j>=0;j--){
	                nums[j+1]=nums[j];
	            }
	            nums[0]=tmp;
	            System.out.println(nums[0]+" "+nums[1]+" "+nums[2]+" "+nums[3]+" "+nums[4]+" "+nums[5]+" "+nums[6]);
	            }
	        }
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6,7};
		rotate(nums,3);
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]);
	}

}
