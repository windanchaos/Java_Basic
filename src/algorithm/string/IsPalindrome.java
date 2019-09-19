package algorithm.string;
/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true

示例 2:

输入: "race a car"
输出: false


 */
public class IsPalindrome {
    public static void main(String[] args) {
        String s1="A man, a plan, a canal: Panama";
        String s2="race a car";
        String s3="@rar@";
        System.out.println(solution(s3));

    }
    /*
    思路：遍历字符串
    难处理的是非数字和大小写字母
    直接用差值做。
    优秀：
    执行用时 :8 ms, 在所有 Java 提交中击败了88.81% 的用户
    内存消耗 :37.5 MB, 在所有 Java 提交中击败了92.49%的用户
     */
    public static boolean solution(String s){
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<s.length();i++){
            //是处理范围的才处理
            if((s.charAt(i)>47 && s.charAt(i)<58) || (s.charAt(i)>64&& s.charAt(i)<91) || (s.charAt(i)>96 && s.charAt(i)<123) ){
                buffer.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        char[] c=buffer.toString().toCharArray();
        for(int i=0;i<c.length/2;i++){
            if(c[i]!=c[c.length-i-1]){
                return false;
            }
        }
        return true;
    }
}
