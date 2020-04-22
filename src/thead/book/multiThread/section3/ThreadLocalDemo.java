package thead.book.multiThread.section3;

public class ThreadLocalDemo {
    static ThreadLocal local = new ThreadLocal();

    public static void main(String[] args) {

        Thread threadA = new Thread(new ThreadA(local), "threadA");
        Thread threadB = new Thread(new ThreadB(local), "threadB");
        threadA.start();
        threadB.start();
        setValue();
        getValue();
    }

    public static void setValue() {
        for (int i = 0; i < 10; i++) {
            local.set(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void getValue() {
        for (int i = 0; i < 10; i++) {
            System.out.println(local.get());
        }
    }
}

class ThreadA implements Runnable {
    private ThreadLocal local;

    public ThreadA(ThreadLocal local) {
        this.local = local;
    }

    @Override
    public void run() {
        ThreadLocalDemo.setValue();
        ThreadLocalDemo.getValue();
    }
}

class ThreadB implements Runnable {
    private ThreadLocal local;

    public ThreadB(ThreadLocal local) {
        this.local = local;
    }

    @Override
    public void run() {
        ThreadLocalDemo.setValue();
        ThreadLocalDemo.getValue();
    }
}
