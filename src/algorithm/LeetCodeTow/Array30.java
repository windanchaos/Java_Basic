package algorithm.LeetCodeTow;

import org.junit.Test;

/*
https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/

判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

数独部分空格内已填入了数字，空白格用 '.' 表示。

// 将1右移numbers[i]位，然后与flag进行按位与运算
// 若flag上的第numbers[i]已为1，说明该位已被占用，数字重复了，运算的结果大于0,返回false
if(((1 << numbers[i]) & flag) > 0)
    return false;

// 通过“或操作”填充flag中不同的二进制位
flag |= (1 << numbers[i]);

 */
public class Array30 {

    public static boolean solution(char[][] board){
        //数组记录是否被设置过值，为true设置过，则重复。返回false。否则函数返回true。
        boolean[][] rows=new boolean[9][9];
        boolean[][] colums=new boolean[9][9];
        boolean[][] boxes=new boolean[9][9];

        for(int r=0;r<9;r++){
            for (int c=0;c<9;c++){
                if(board[r][c]!='.'){
                    int value=board[r][c]-'1';
                    //计算是第几个box
                    int boxIndex=c / 3 * 3 + r / 3;
                    if(rows[r][value] || colums[c][value] || boxes[boxIndex][value] ){
                        return false;
                    }
                    rows[r][value] = true;
                    colums[c][value] = true;
                    boxes[boxIndex][value] = true;
                }

            }
        }
        return true;
    }
}
