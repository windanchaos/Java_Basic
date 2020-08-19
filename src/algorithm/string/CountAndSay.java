package algorithm.string;
/*
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(5));

    }
    /*
执行用时 :3 ms, 在所有 Java 提交中击败了94.07%的用户
内存消耗 :34.2 MB, 在所有 Java 提交中击败了90.61%的用户
     */
    public static String solution(int n){
        StringBuffer buffer=new StringBuffer("1");
        for(int i=0;i<n-1;i++){
            buffer=read(buffer);
        }
        return buffer.toString();
    }
    public static StringBuffer read(StringBuffer buffer){
        buffer.append("*");
        StringBuffer newbuffer=new StringBuffer();
        int index=0;
        int count=0;
        if(buffer.length()==1) {
            return newbuffer.append("1").append("1");}
        for(int i=0;i<buffer.length();i++){
            if(buffer.charAt(index)==buffer.charAt(i)){
                count++;
            }else {
                newbuffer.append(count).append(buffer.charAt(index));
                count=1;
                index=i;
            }

        }
        return newbuffer;
    }
}
