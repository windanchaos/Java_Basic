package algorithm;
/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。


 */
public class PlusOne {
    public static void main(String[] args) {

    }
    /*
    这个算法面对大数的时候，结果不确定。不能用
     */
    public static int[] plusOne(int[] digits) {
        int size=digits.length;
        long tmp=0;
        for(int i=size-1;i>=0;i--){
            tmp= (long) (tmp+digits[i]*Math.pow(10,size-i-1));
        }
        tmp=tmp+1;
        int[] reslut=new int[size+1];
        for(int i=size;i>=0;i--){
            reslut[i]= (int) (tmp%10);
            tmp=tmp/10;
        }
        if(reslut[0]==0){
            for(int i=0;i<size;i++){
                digits[i]=reslut[i+1];
            }
            return digits;
        }
        return reslut;
    }
    /*
      下面的算法聚焦到单个数的进位与否
     */
    public static int[] plusOne2(int[] digits) {
        int size=digits.length;
        int i=size-1;
        //i>-1在写代码的时候没有加，但是需要加，因为极端情况case中只有一个数字的时候，i--回到循环后，数组下标就越界了。
        //用循环扫描9连续性，倒序。
        while(i>-1 && digits[i]==9){
            i--;
        }

        //i 保留作为记录连续9的依据。全部都是9，则最终i值为-1（i--）；
        //每一位都是9，则数组大小加1后，数字为1000...0000形式。
        if(i==-1){
            int[] reslut=new int[size+1];
            reslut[0]=1;
            int j=1;
            //因为用的j++,所以边界用的size，等价于j<size+1；但是又起到了步增作用。
            while(j++<size){
                reslut[j]=0;
            }
            return reslut;
        }else {
            /*
            因为while循环中i已经减过了，所以需要进位的index为i;
             */
            int indexPlusOne=i;
            digits[indexPlusOne]=digits[indexPlusOne]+1;
            while(indexPlusOne++<size-1){
                digits[indexPlusOne]=0;
            }
            return digits;
        }



}
}
