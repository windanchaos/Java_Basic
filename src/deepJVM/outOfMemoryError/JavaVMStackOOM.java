package deepJVM.outOfMemoryError;

/**
 * 创建线程导致的内存溢出异常
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -Xss2m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * 线程堆栈大小——》进程的最大内存——》操作系统位数
 * 前 KiB Mem : 16376292 total,  4579380 free,  6523316 used,  5273596 buff/cache
 * 后 KiB Mem : 16376292 total,  4445536 free,  6655412 used,  5275344 buff/cache
 * 500多个线程：                  133844         132096 每个线程260多kb，和2M差距太大
 *
 * 第二次实验
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -Xss2048k -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * 前KiB Mem : 16376292 total,  5043448 free,  6048124 used,  5284720 buff/cache
 * 后KiB Mem : 16376292 total,  4552652 free,  6535280 used,  5288360 buff/cache
 * 300多个线程：                 490796         487156  每个线程大概1.6M的样子，排除统计误差，很接近了
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while (true){

        }
    }
    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread((new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }));
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom=new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}

