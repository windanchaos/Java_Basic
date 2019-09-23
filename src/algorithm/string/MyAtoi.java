package algorithm.string;
/*
请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
 */

public class MyAtoi {
    public static void main(String[] args) {
        String s1 = "words and 987";
        String s2 = "2";
        String s3 = "  --12-";
        String s4 = "91283472332";
        String s5 = "42";
        String s6="2147483648";
        String s7="   -43";
        String s8="         -000000023041";
        String s9="         +10523538441s";
        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
        System.out.println(solution(s5));
        System.out.println(solution(s6));
        System.out.println(solution(s7));
        System.out.println(solution(s8));
        System.out.println(solution(s9));
    }

    /*
    第三遍，把事情简单处理
    符号和数字独立处理
     */
    public static int solution(String s){
        //排除所有空格
        String str=s.trim();
        //空情况
        if(str.length()==0) return 0;
        //符号
        int negative=-1;
        if(str.charAt(0)=='-'){
            str=str.substring(1);
        }else if(str.charAt(0)=='+'){
            negative=1;
            str=str.substring(1);
        }else {
            negative=1;
        }
        //保存数值
        long number=0;
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                break;
            }else {
                number=number*10+(str.charAt(i)-'0');
            }
            //越界直接结束
            if(i>9) {
                if (number * negative > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (number * negative < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
        }

        return (int)number*negative;

    }
    /*
    别人的解法，这个更优雅
     */
    public static int solutionBetter(String str){
        str = str.trim();
        if(str.length() == 0) return 0;

        int sign = 1;
        if(str.charAt(0) == '-'){
            sign = -1;
            str = str.substring(1);
        }else if(str.charAt(0) == '+'){
            sign = 1;
            str = str.substring(1);
        }

        long ans = 0;
        for(int i=0; i<str.length(); i++){
            char val = str.charAt(i);
            if(!Character.isDigit(val))
                break;

            ans = ans * 10 + (val - '0');
            if(ans * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(ans * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }

        return (int)ans* sign;
    }
    /*
    别人的非正则，这里它把“   --2-”认为是不做处理的
    这里对"-0000022"的处理很精巧，用  char-'0'的方式取得。
    对符号的处理也单独出来。像我自己写的话，是混在一起的。

     */
    public static int solutionBetter2(String str) {
        int i = 0, j = 0, len = str.length();
        boolean negative = false;
        for (i = 0; i < len; i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                break;
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                negative = str.charAt(i) == '-';
                i++;
                break;
            } else if (str.charAt(i) != ' ') {
                return 0;
            }
        }
        for (j = i; j < len; j++) {
            if (str.charAt(j) < '0' || '9' < str.charAt(j)) {
                break;
            }
        }
        int ret = 0;
        String num = str.substring(i, j);
        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (negative) {
                //这里判断溢出的情况和第7题一样
                if (ret < Integer.MIN_VALUE / 10|| ret == Integer.MIN_VALUE / 10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 - cur;
            } else {
                if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + cur;
            }
        }
        return ret;
    }

/*
    第二遍
    public static int solution(String s){
        //去空格
        String str=s.trim();
        char[] c=str.toCharArray();
        int start=-1;
        int end=-1;

        for(int i=0;i<c.length;i++){
            if('0'<=c[i] && c[i]<='9'){
                start=i;
                break;
            }
        }
        //找不到数字就返回
        if(start==-1){
            return 0;
        }
        for(int i=start;i<c.length;i++){
            if('0'>c[i] || c[i]>'9'){
                end=i;
                break;
            }
        }
        //找不到非数字，则结尾是数字，直接赋值数组长度
        if(end==-1){
            end=c.length;
        }
        long number;

        if(start>0 && c[start-1]=='-'){
            while(c[start]==0){
                c[start]='-';
                start++;
            }
            number = Long.valueOf(str.substring(start-1,end-start>10?(start+10):end));
        }else if(start>0 && c[start-1]=='+'){
            //排除数字前的不能有非数字
            while(c[start]==0){
                c[start]='+';
                start++;
            }
            number = Long.valueOf(str.substring(start-1,end-start>10?(start+10):end));
        }else if(c[start-1]<'0'||c[start-1]>'9'){
            return 0;
        }else
            number = Long.valueOf(str.substring(start, end - start > 10 ? start + 10 : end));

        if (number > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (number < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) number;

    }

 */
    /*
    第一遍
    思路：遍历 空 到空之间的数字，取得的数字范围检测。

    public static int solution(String s) {

        定义数组来存储下标
        0第一个非空
        1起始数字下标
        2空格或非数字的下标
        测试case：
         “  --123-” ， “1”

        Integer[] memory = new Integer[3];
        //遍历找范围
        //第一个非空下标
        //为空则没有非空。否则有。
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 9 && s.charAt(i) != 32) {
                memory[0] = i;
                break;
            }
        }
        //第一个数字下标或负号
        if (null!=memory[0]) {
            for (int i = memory[0]; i < s.length(); i++) {
                if ((s.charAt(i)) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                    memory[1] = i;
                    break;
                }
            }
        }else {
            for (int i = 0; i < s.length(); i++) {
                if ((s.charAt(i)) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                    memory[1] = i;
                    break;
                }
            }
        }
        //memory[1]是找的数字，找不到就直接返回
        //再找非数字
        if (null != memory[1]) {
            if(memory[1]+1==s.length()){
                memory[2]=s.length()-1;
            }
            for (int i = memory[1]+1 ; i < s.length(); i++) {
                if (s.charAt(i) == 9 || s.charAt(i) == 32 || (s.charAt(i)) < '0' || s.charAt(i) > '9' ||s.charAt(i)!='-') {
                    memory[2] = i-1;
                    break;
                }
                //数字结尾
                memory[2] = i;
            }
        }else {
            return 0;
        }
        //对遍历结果的index做分析
        //空字符、数字负号前不是空（其他字符）
        if (null == memory[0]) {
            return 0;
        }
        //取出数字字符串。要考虑连续--的情况
        String tmp = s.substring(memory[1], memory[2] + 1);
        if(tmp.contains("-")){
            int index=0;
            for(int i=0;i<tmp.length();i++){
                if(tmp.charAt(i)!='-'){
                    index=i-1;
                    break;
                }
            }
            tmp=tmp.substring(index,tmp.length());
        }
        long number = Long.valueOf(tmp.substring(tmp.lastIndexOf('-')==-1?0:tmp.lastIndexOf('-'), tmp.length()));
        if (number > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (number < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) number;
    }
         */
}
