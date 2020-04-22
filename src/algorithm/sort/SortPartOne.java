package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序，两两比较，传递最大值到数组尾部；传完尾部前进1；如此往复；完成排序。
 * 复杂度 N*N
 */
public class SortPartOne {
    public static void main(String[] args) {
        int[] array={ 49, 38, 65, 97, 76, 13, 27, 50};
        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println(Arrays.toString(chooseSort(array)));
        System.out.println(Arrays.toString(insertionSort(array)));
    }

    /**
     * 冒泡排序，两两比较，传递最大值到数组尾部；传完尾部前进1；如此往复；完成排序。
     * 复杂度 N*N
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array){
        for(int k=1;k<array.length;k++){
            for (int i = 0; i < array.length-k ; i++) {
                if(array[i]>array[i+1]){
                    int temp= array[i+1];
                    array[i+1]=array[i];
                    array[i]=temp;
                }
            }
        }
    return array;
    }

    /**
     * 选择排序,最小的接住到index小的上边。一直找最小，直到完结。
     * 复杂度N*N
     */
    public static int[] chooseSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int min=array[i];
            for (int j = i+1; j < array.length ; j++) {
                if(min>array[j]){
                    int temp= array[j];
                    array[j]=min;
                    min=temp;
                }
            }
            array[i]=min;
        }
        return array;
    }
    /**
     * 插入排序,从0到index构成一个围栏，从1开始比较排序，不断的迭代直到最后。
     * 复杂度N×N
     */
    public static int[] insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = i-1; j < i; j++) {
                if(array[i]<array[j]){
                    int temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }
        return array;
    }
}
