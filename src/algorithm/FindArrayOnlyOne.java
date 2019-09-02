package algorithm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.concurrent.SynchronousQueue;

public class FindArrayOnlyOne {
    public static void main(String[] args) {
        int[] nums={2,1,2,3,4,1};
        FindArrayOnlyOne findArrayOnlyOne=new FindArrayOnlyOne();
        int[] r=findArrayOnlyOne.singleNumberMiddle(nums);
        System.out.print(Array.getInt(r,0)+" ");
        System.out.println(Array.getInt(r,1));
    }
/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
输入: [2,2,1]
输出: 1
 */
    public int singleNumberSimple(int[] nums) {
        int onlyOne=nums[0];
        for (int i=1; i<nums.length; i++){
            onlyOne=onlyOne^nums[i];
        }
        return onlyOne;
    }
/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
输入: [1,2,1,3,2,5]
输出: [3,5]
 */
    public int[] singleNumberMiddle(int[] nums) {
        int group[]=new int[2];
        int xorNumber=nums[0];
        for (int i=1; i<nums.length; i++){
            xorNumber=xorNumber^nums[i];
        };
        System.out.println(xorNumber);
        int tmp=xorNumber;
        for(int j=0;j<nums.length; j++){
            xorNumber=xorNumber^nums[j];
            if(xorNumber==0 && j!=(nums.length-1)){
                group[0]=nums[j];
                group[1]=tmp^nums[j];
            }
        };

        return group;
    }
    @DataProvider(name="findTwoNumbers")
    public int[] myDataProvider2(){
        int a[]={1,2,1,3,2,5};
        return a;
    }
    @Test(dataProvider = "findTwoNumbers",enabled = false)
    public void testsingleNumberMiddle(int[] a){
        System.out.print(singleNumberMiddle(a));
    }
    /*
    扩展：亦或运算交换值
     */
    @DataProvider(name="numbers")
    public Object[][] myDataProvider(){
        return  new Object[][]{
                {12,14},
                {25,1}
        };
    }
    @Test(dataProvider = "numbers",enabled = false)
    public void testXorExchangeValue(int a,int b){
        System.out.println("交换前："+a +" " +b);
        a=a^b;
        System.out.println("交换a=a^b后的a: "+a );
        b=b^a;
        System.out.println("交换b=b^a后的b: "+b );
        a=a^b;
        System.out.println("交换后："+a +" " +b);
        System.out.println("数a对b连续亦或运算");
        a=a^b^b;
        System.out.println("数a对b连续亦或运算:"+a);
        a=(a^b)^(a^b);
        System.out.println("数a对b和b连续亦或运算:"+a);

    }
}

