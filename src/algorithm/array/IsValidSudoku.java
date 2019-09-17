package algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:

输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true

示例 2:

输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。

说明:

    一个有效的数独（部分已被填充）不一定是可解的。
    只需要根据以上规则，验证已经填入的数字是否有效即可。
    给定数独序列只包含数字 1-9 和字符 '.' 。
    给定数独永远是 9x9 形式的。

 */
public class IsValidSudoku {
    public static void main(String[] args) {
        char[][] borad={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        char[][] borad2={{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        char[][] borad3={{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
        //System.out.println(solution(borad));
//        for (int i = 0; i < borad.length; i++) {
//            for(int j=0;j<borad[i].length;j++) {
//                System.out.print(borad[i][j]+" | ");
//            }
//            System.out.println();
//        }
        System.out.println(godLike(borad));
    }

    public static boolean solution(char[][] board) {
        /*
        思考分析：如果只是9的规模，暴力算应该可以，但是如果考虑N*N的规模，就需要控制算法的时间复杂度。
        设想一个N/3*3*2的数组记录列、行校验的结果。
        设想把这种方式转成二进制运算。
        还学过一个动态规划法看看能不能用得上。
         */
        /*
        暴力破解方法。遍历数组3次，复杂度3N的2次方
        执行用时 :17 ms, 在所有 Java 提交中击败了13.50% 的用户
        内存消耗 :45.2 MB, 在所有 Java 提交中击败了67.62%的用户

        优化：
        遍历数组2次。
        执行用时 :16 ms, 在所有 Java 提交中击败了19.06% 的用户
        内存消耗 :47.1 MB, 在所有 Java 提交中击败了59.79%的用户

        在优化：
        遍历数组1次。不能优化了。

        学习：
        别人用的Hashset,把hashmap改成hashset
        执行用时 :15 ms, 在所有 Java 提交中击败了26.24% 的用户
        内存消耗 :41.2 MB, 在所有 Java 提交中击败了86.42%的用户

         */

        if(!checkNplusN(board,3)){
            return false;
        }
//        if(!checkX(board)){
//            return false;
//        }
//        if(!checkY(board)){
//            return false;
//        }
        if(!checkXY(board)){
            return false;
        }
        return true;
    }

    /*
    讲格子分成3*3的方式遍历
    startIndeX/Y，开始的索引位置
    使用map来遍历，判定是否格子重复
     */
    public static boolean checkNplusN(char[][] board,int step) {
        boolean b = true;
        HashSet<Character> set = new HashSet<Character>();
        for (int i=0;i<board.length;i=i+step){
            for(int j=0;j<board[i].length;j=j+step){
                //小方格处理完清空
                set.clear();
                for(int m=i;m<i+step;m++){
                    for(int n=j;n<j+step;n++){
                        if ('.'!=board[m][n]) {
                            if (!set.add(board[m][n])) {
                                //只要重复就停止比较
                                System.out.println("checkNplusN");
                                System.out.print(board[m][n]);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return b;
    }

    /*
    检查行
     */
    public static boolean checkX(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        boolean b = true;
        for (int i = 0; i < board.length; i++) {
            //处理完就清空
            set.clear();
            for(int j=0;j<board[i].length;j++) {
                if ('.'!=board[i][j]) {
                    if (!set.add(board[i][j])) {
                        //只要重复就停止比较
                        System.out.println("checkX");
                        System.out.print(board[i][j]);
                        return false;
                    }
                }

            }
        }
        return b;
    }
    /*
    检查列
     */
    public static boolean checkY(char[][] board) {
        boolean b = true;
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ('.'!=board[j][i]) {
                    if (!set.add(board[j][i])) {
                        //只要重复就停止比较
                        return false;
                    }
                }
            }
            //一列完成就清空
            set.clear();
        }
        return b;
    }

    /*
    优化遍历XY到一个方法
     */
    public static boolean checkXY(char[][] board) {
        HashSet<Character> setX = new HashSet<Character>();
        HashSet<Character> setY = new HashSet<Character>();
        for (int i = 0; i < board.length; i++) {
            //处理完就清空
            setX.clear();
            setY.clear();
            for(int j=0;j<board[i].length;j++) {
                if ('.'!=board[i][j]) {
                    if (!setX.add(board[i][j])) {
                        //只要重复就停止比较
                        return false;
                    }
                }
                if ('.'!=board[j][i]) {
                    if (!setY.add(board[j][i])) {
                        //只要重复就停止比较
                        return false;
                    }
                }
            }

        }
        return true;
    }

    /*
    大神算法.
    非常巧妙的使用了3个数组来记录行、列、方格内的累计值，而且任一一个为假就退出。
     */
    public static boolean godLike(char[][] board){
        int[] row = new int[9];
        int[] col = new int[9];
        int[] block = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = 1 << (board[i][j] - '1');
                    int blc = i / 3 * 3 + j / 3;
                    if ((num & (row[i] | col[j] | block[blc])) != 0) {
                        return false;
                    }
                    row[i] |= num;
                    col[j] |= num;
                    block[blc] |= num;
                }
            }
        }
        return true;
    }

}
