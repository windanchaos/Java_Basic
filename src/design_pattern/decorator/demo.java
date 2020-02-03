package design_pattern.decorator;


import java.io.FilterInputStream;

public class demo {
    public demo(){}
    public demo(int i,int j){

    }
    public static Integer i = 1000;

    public static void main(String[] args) {
        int j = 50;
        int k = 100;
        int l = j+k+i;
        demo d = new demo();
        d.methode1("asdsdd");

    }
    public void methode1(String s){
        System.out.println(s);
    }
}
