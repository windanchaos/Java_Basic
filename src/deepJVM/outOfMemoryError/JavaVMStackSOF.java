package deepJVM.outOfMemoryError;

/**
 * jvm StackOverFlowError
 * 控制 -Xss128k
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -Xss128k -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 */
public class JavaVMStackSOF {
    private int stackLength=1;

    //不停调用自己，记录调用数
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom=new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("Stack 调用次数："+oom.stackLength);
            throw e;
        }
    }
}
