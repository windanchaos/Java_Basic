package algorithm.string;

import java.util.HashMap;
import java.util.HashSet;

/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
注意事项：您可以假定该字符串只包含小写字母。

 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s1 = "loveleetcode";
        String s2 = "cc";
        String s3 = "aadadaad";
        String s4 = "bd";
        System.out.println(solution2(s4));

    }

    /*
    自己写的
    执行用时 :56 ms, 在所有 Java 提交中击败了50.17% 的用户
    内存消耗 :36.7 MB, 在所有 Java 提交中击败了96.44%的用户

    写法和官方思路一样。唯一的区别是官方用个s.charAt()的方法。
     */
    public static int solution(String s) {
        char[] c = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        //装载string字母和数量统计到map
        for (int i = 0; i < c.length; i++) {
            if (!map.containsKey(c[i])) {
                map.put(c[i], 1);
            } else {
                map.put(c[i], map.get(c[i]) + 1);
            }
        }
        //遍历查找
        for (int i = 0; i < c.length; i++) {
            if (map.get(c[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /*
    再写一个,利用string的substring
    这种思路在处理，开始2位和后两位的特殊情况时，需要考虑的因素很多

    执行用时 :831 ms, 在所有 Java 提交中击败了5.03% 的用户
    内存消耗 :40.9 MB, 在所有 Java 提交中击败了82.37%的用户
     */
    public static int solution2(String s) {
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            //定义查找的字母
            String letter=String.valueOf(c[i]);
            //分别在字母的前半段和后半段查找s
            String head=s.substring(0,i);
            String tail=s.substring(i+1,c.length);
            //首尾查找，找不到就返回
            if("".equals(head)){
                if(!tail.contains(letter)){
                    return 0;
                }
            }
            if("".equals(tail)){
                if(!head.contains(letter)){
                    return i;
                }
            }
            if(!head.contains(letter) && !tail.contains(letter)){
                return i;
            }
        }
        return -1;
    }
}
