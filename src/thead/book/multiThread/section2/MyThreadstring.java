package thead.book.multiThread.section2;

public class MyThreadstring {
    public static void main(String[] args) {
        MyObject myObject = new MyObject(10);
        Thread threadA = new Thread(new A(myObject), "A");
        Thread threadB = new Thread(new B(myObject), "B");
        threadA.start();
        threadB.start();
    }
}

class A implements Runnable {
    MyObject myObject;

    public A(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.methodSynString();
    }
}

class B implements Runnable {
    MyObject myObject;

    public B(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.methodSynString2();
    }
}