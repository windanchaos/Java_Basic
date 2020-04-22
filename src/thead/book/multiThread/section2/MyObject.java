package thead.book.multiThread.section2;

/**
 * 校验同一个类不同线程中的实例，是否是线性执行
 */
public class MyObject {
    private Integer count;
    String s = new String("a");

    public MyObject(int i) {
        this.count = i;
    }

    public void objectMethd() {
        System.out.println("进入方法时候的count" + count);
        System.out.println("MyObject objectMethod running ,currentThreand name :" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " objectMethd1 end");
        //校验一个调用自身的case
        synchronized (s) {
            if (count > 0) {
                System.out.println("自己调用了自己，当前调用索引：" + count);
                count = count - 1;
                this.objectMethd();
            }
        }
    }

    public void objectMethd2() {
        System.out.println("MyObject objectMethod running ,currentThreand name :" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "objectMethd2 end");
        //校验一个调用自身的case
        synchronized (s) {
            if (count > 0) {
                System.out.println("自己调用了自己，当前调用索引：" + count);
                count = count - 1;
                this.objectMethd();
            }
        }
    }

    public void methodSynString() {
        synchronized ("hey") {
            if (count > 4) {
                count--;
                System.out.println(Thread.currentThread().getName() + " count is " + count);
                this.methodSynString();
            }
        }
    }

    public void methodSynString2() {
        synchronized ("hey2") {
            if (count > 0) {
                count--;
                System.out.println(Thread.currentThread().getName() + " count is " + count);
                this.methodSynString2();
            }
        }
    }

}
