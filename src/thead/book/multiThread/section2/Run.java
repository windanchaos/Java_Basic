package thead.book.multiThread.section2;

/**
 * 校验同一个类不同线程中的实例，是否是线性执行
 */
public class Run {
    public static void main(String[] args) {
        MyObject myObject = new MyObject(5);
        MyThreadA threadA = new MyThreadA(myObject);
        MyThreadB threadB = new MyThreadB(myObject);
        threadA.start();
        threadB.start();
    }
}

class MyThreadA extends Thread {
    MyObject myObject;

    public MyThreadA(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.objectMethd();
    }
}

class MyThreadB extends Thread {
    MyObject myObject;

    public MyThreadB(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.objectMethd2();
    }
}