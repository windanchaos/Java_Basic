package data;

public class BooleanJudage {

    public static void main(String[] args) {
        boolean first = true;

        if (!first | second()) {
            System.out.println("|前面是假，后边是真，进来了");
        }
        if (first | second()) {
            System.out.println("|前面是真，后边是真，进来了");
        }
        if (!first || second()) {
            System.out.println("||前面是假，后边是真，进来了");
        }
        if (first == true || second()) {
            System.out.println("||前面是真，后边是真，进来了");
        }

    }

    public static boolean second() {
        System.out.println("符号后方的方法被执行了，返回真");
        return true;
    }

    ;
}
