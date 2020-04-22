package algorithm.array;

import java.util.stream.IntStream;

public class Water {
    public static void main(String[] args){
        //int number[]={0,1,0,2,1,0,1,3,2,1,2,1};
        int number[]={0,1,0,1};
        int max= IntStream.of(number).max().getAsInt();
        int sum=0;
        for(int i=1;i<max;i++){
            for (int j = 0; j <number.length ; j++) {
                int reduce=number[j]-i;
                if(reduce==-1 &&j!=0&&j!=number.length-1){
                    sum+=reduce;
                }
            }
        }
        System.out.println("sum="+Math.abs(sum));
    }
}