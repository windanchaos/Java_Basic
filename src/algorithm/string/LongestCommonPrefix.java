package algorithm.string;

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = {"a", "ac"};
        System.out.println(solution2(s));
    }

    /*
    第二种，直接来
    执行用时 :1 ms, 在所有 Java 提交中击败了99.92%的用户
    内存消耗 :37.4 MB, 在所有 Java 提交中击败了77.46%的用户
    可见：算法优劣的一个兴奋点，就是少步骤多做事，步骤保证高性能。
     */
    public static String solution2(String[] strs) {
        if (null == strs || strs.length == 0) return "";
        //初始化 并找到最短字符串的长度
        int minlength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            //检测空字符串
            if (strs.length == 0 || null == strs[i]) return "";
            if (minlength > strs[i].length()) minlength = strs[i].length();
        }
        //i做列扫描
        int i=0;
        for (; i < minlength; i++) {
            char reslut = strs[0].charAt(i);
            for (int j=0; j < strs.length; j++) {
                if (reslut != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }

        }
        return strs[0].substring(0, i);
    }

    /*
    第一种思路：用char[][]数组来保存，难点是在于最小长度不知道，需要花时间去找。---其实不用找，随便用一个长度都可以。只是存在空间上的浪费。

     */
    public static String solution(String[] strs) {
        if (null == strs || strs.length == 0) return "";
        char[][] strsChar = new char[strs.length][];
        //初始化 并找到最短字符串的长度
        int minlength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            //检测空字符串
            if (strs.length == 0 || null == strs[i]) return "";
            strsChar[i] = strs[i].toCharArray();
            if (minlength > strs[i].length()) minlength = strs[i].length();
        }
        //遍历列
        int index = 0;
        for (int x = 0; x < minlength; x++) {
            //记录值
            int reslut = strsChar[0][x];
            for (int y = 0; y < strsChar.length; y++) {
                if (reslut != strsChar[y][x]) {
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
        return strs[0].substring(0, index);

    }
}
