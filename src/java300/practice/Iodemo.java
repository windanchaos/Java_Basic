package java300.practice;

import java.io.*;
import java.util.Arrays;

public class Iodemo {
    public static void main(String[] args) throws IOException {
        //读取文件内容
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

        //writer stream 联系
        File testfile=new File("D:\\test.txt");
        FileOutputStream outputStream=new FileOutputStream(testfile);
        OutputStreamWriter writer=new OutputStreamWriter(outputStream,"utf-8");
        writer.write("中文输入");
        writer.append("\r\n");
        writer.append("English");
        writer.close();
        outputStream.close();

        //用Stringbuffer接
        FileInputStream inputStream2=new FileInputStream(testfile);
        InputStreamReader reader2=new InputStreamReader(inputStream2);
        StringBuffer stringBuffer=new StringBuffer();
        while(reader2.ready()){
            stringBuffer.append((char) reader2.read());
        }
        System.out.println(stringBuffer.toString());

        FileInputStream inputStream3=new FileInputStream(testfile);
        InputStreamReader reader3=new InputStreamReader(inputStream3);
        //用char数组接
        char[] chars=new char[20];
        while(reader3.ready()){
            reader3.read(chars,0,20);
            System.out.print(String.valueOf(chars));
        }
        inputStream2.close();
        inputStream3.close();

    }


}
