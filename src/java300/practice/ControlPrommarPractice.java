package java300.practice;
/*
98.	【上机】使用递归算法完成阶乘算法
99.	【上机】根据随机生成的的月份，打出该月份的天数.（不考虑闰年、闰月）
100.	【上机】用while和for循环分别计算100以内奇数和偶数的和，并输出。
101.	【上机】用while和for循环输出1-1000之间能被5整除的数，且每行输出3个。
102.	【上机】打印出九九乘法表
103.	【上机】编程求：∑1+∑2+……+∑100
104.	【上机】生成0-100随机数，直到生成88为止，停止循环！
105.	【上机】把100~150之间不能被3整除的数输出
106.	【上机】打印出实心10*10正方形、空心10*10正方形
107.	【上机】打印出实习10*10菱形， 空心10*10菱形
108.	【上机】将如上所有上机相关算法的作业，封装成方法，便于重用。
 */
public class ControlPrommarPractice {
    public static void main(String[] args) {
        ControlPrommarPractice c=new ControlPrommarPractice();
        //98 使用递归算法完成阶乘算法
        System.out.println("98题");
        System.out.println(c.factorial(3));
        //99 根据随机生成的的月份，打出该月份的天数.（不考虑闰年、闰月）
        System.out.println("99题");
        int randomMonth=c.randomMonth();
        c.getMonthLongth(randomMonth);
        //100 用while和for循环分别计算100以内奇数和偶数的和，并输出。
        System.out.println("100题");
        c.hundredPlus();
        //101 用while和for循环输出1-1000之间能被5整除的数，且每行输出3个
        System.out.println("101题");
        c.exactDivisionBy5();
        //102 打印出九九乘法表
        System.out.println("102题");
        c.multiplicationTable();
        //103 编程求：∑1+∑2+……+∑100
        System.out.println("103题");
        c.sigma(100);
        //104 生成0-100随机数，直到生成88为止，停止循环！
        System.out.println("104题");
        c.stopWhen88();
        //106 打印出实心10*10正方形、空心10*10正方形
        System.out.println("106题");
        c.printSquares();
        //107 打印出实习10*10菱形， 空心10*10菱形
        System.out.println("107题");
        c.printRhombus();

    }

    /*
    使用递归算法完成阶乘算法
     */
    public long factorial(long number){
        long result=1;
        if(number==1)
            return result;
        else
            result=number*factorial(number-1);
        return result;
    }
    /*
    根据随机生成的的月份，打出该月份的天数.（不考虑闰年、闰月）
    不考虑闰年闰月的情况就是明确的，用switch
     */
    public void getMonthLongth(int month){
        switch (month){
            case 1:
                System.out.println(month+"月有31天");
                break;
            case 2:
                System.out.println(month+"月有29天");
                break;
            case 3:
                System.out.println(month+"月有31天");
                break;
            case 4:
                System.out.println(month+"月有30天");
                break;
            case 5:
                System.out.println(month+"月有31天");
                break;
            case 6:
                System.out.println(month+"月有30天");
                break;
            case 7:
                System.out.println(month+"月有31天");
                break;
            case 8:
                System.out.println(month+"月有31天");
                break;
            case 9:
                System.out.println(month+"月有30天");
                break;
            case 10:
                System.out.println(month+"月有31天");
                break;
            case 11:
                System.out.println(month+"月有30天");
                break;
            case 12:
                System.out.println(month+"月有31天");
                break;
            default:
                System.out.println(month+"不合法");
                break;
        }

    }
    /*
    随机返回月份
     */
    public int randomMonth(){
        return (int)(Math.random()*13);
    }
    /*
    用while和for循环分别计算100以内奇数和偶数的和，并输出。
     */
    public void hundredPlus(){
        //for循环
        int forSumOdd=0;
        int forSumEven=0;
        for(int i=1;i<=100;i++){
            if((i&1)==1){
                forSumOdd=forSumOdd+i;
            }else
            {
                forSumEven=forSumEven+i;
            }
        }
        int whileSumOdd=0;
        int whileSumEven=0;
        int i=1;
        while(i<101){
            if((i&1)==1){
                whileSumOdd=whileSumOdd+i;
            }else
            {
                whileSumEven=whileSumEven+i;
            }
            i=i+1;
        }
        System.out.println("forSumOdd:"+forSumOdd);
        System.out.println("forSumEven:"+forSumEven);
        System.out.println("whileSumOdd:"+whileSumOdd);
        System.out.println("whileSumEven:"+whileSumEven);
    }
    /*
    用while和for循环输出1-1000之间能被5整除的数，且每行输出3个
    只用for了
     */
    public void exactDivisionBy5(){
        int j=1;
        for(int i=1;i<1001;i++){
            if(i%5==0){
                System.out.print(i+"\t");
                if(j%3==0){
                    System.out.println();
                }
                j++;
            }

        }
    }
    /*
    99 乘法表
     */
    public void multiplicationTable(){
        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                System.out.print(i+" x "+j+" = "+i*j+'\t');
                if(j%i==0){
                    System.out.println();
                    break;
                }
            }
        }
    }
    /*
    103.	【上机】编程求：∑1+∑2+……+∑100
    这里输入最大数100作为参数
     */
    public void sigma(int num){
        //数组下标等于数字，数组index为0的丢弃
        int[] array_tmp=new int[num+1];
        int sum=0;
        for(int i=1;i<num+1;i++){
            array_tmp[i]=array_tmp[i-1]+i;
            sum=sum+array_tmp[i];
        }
        System.out.println("∑1+∑2+……+∑"+num+"的和为："+sum);
    }
    /*
    104.	【上机】生成0-100随机数，直到生成88为止，停止循环！
     */
    public void stopWhen88(){
        int i=1;
        while(((int)(Math.random()*100))!=88){
            i++;
        }
        System.out.println("循环了"+i+"次，取得了88");
    }
    /*
    打印出实心10*10正方形、空心10*10正方形
     */
    public void printSquares(){
        System.out.println("实心正方形");
        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("空心正方形");
        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if(i==0||i==9||j==0||j==9)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    /*
    打印出实习10*10菱形， 空心10*10菱形
     */
    public void printRhombus(){
        System.out.println("实心菱形");
        for(int a=0;a<10;a++){
            for(int t=0;t<a;t++){
                System.out.print(" ");
            }
            for(int b=0;b<10;b++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("空心菱形");
        for(int a=0;a<10;a++){
            for(int t=0;t<a;t++){
                System.out.print(" ");
            }
            for(int b=0;b<10;b++){
                if(a==0||a==9||b==0||b==9){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

}
