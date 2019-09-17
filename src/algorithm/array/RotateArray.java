package algorithm.array;
/*
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
public class RotateArray {
    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        solution(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


    }

    /*
    这个题，自己思考没有得出正确的原地翻转思路。借鉴网络上的思路。先上下对折，再对角线换
 1 2 3                 7 8 9            7 4 1
 4 5 6    —>           4 5 6  --->      8 5 2
 7 8 9                 1 2 3            9 6 3
     */
    public static void solution(int[][] matrix){
        int length=matrix.length-1;
        //上下翻转
        for(int i=0;i<matrix.length/2;i++){
            for(int j=0;j<matrix.length;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[length-i][j];
                matrix[length-i][j]=tmp;
                //System.out.print(matrix[i][j]);
            }
            //System.out.println();
        }
        //对角线翻转
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
    }
}
