package java300.practice;

/*
第十章部分习题
 */
public class MulitThreadDemo {
    /*
    线程创建的几种方式：
        1、通过实现 Runnable 接口；
        2、通过继承 Thread 类本身；
        3、通过 Callable 和 Future 创建线程。
     */
    static int a = 10000, b = 10000;

    public static void main(String[] args) throws InterruptedException {
        //for循环用两种方式创建线程，为了保证线程执行顺序而在第二个线程中调用线程一的join方法。
        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread("threadAAAAAAAA") {
                public void run() {

                    System.out.println("1:" + Thread.currentThread().getName());
                }
            };

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2:" + Thread.currentThread().getName());
                    System.out.println("++++++++++++++++++");
                }
            }, "threadBBBBBBBB");

            t1.start();

            t2.start();
        }

        //线程退出的两种办法：标识值和中断
        //演示中断
        //申明线程
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                System.out.println("i=" + i);
            }
        });
        t3.start();
        //中断线程
        Thread.sleep(100);
        t3.interrupt();

        /*
        手动写个死锁
         */

        Thread threadA = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (a % 2 == 0) {
                        b = b-1;
                        break;
                    }
                    try {
                        sleep(2000);
                        System.out.println("等待a被2整除0");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (b % 2 == 0) {
                        a = a-1;
                        break;
                    }
                    try {
                        sleep(2000);
                        System.out.println("等待b被2整除0");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        threadA.start();
        threadB.start();

    }


}
