package java300.practice;

import java.io.*;
import java.util.Arrays;

public class Iodemo {
    public static void main(String[] args) throws IOException {
        File file=new File("H:\\history.txt");
        InputStream inputStream=new FileInputStream(file);

        int m=0;
        int num=0;
        byte[] b=new byte[255];
        while ((m=inputStream.read(b))!=-1){
            System.out.print(Arrays.toString(b));
            num=num+1;
        }
        inputStream.close();
        System.out.println("\n"+num);

    }


}
