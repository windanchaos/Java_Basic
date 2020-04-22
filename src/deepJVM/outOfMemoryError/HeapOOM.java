package deepJVM.outOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 * 执行前提，修改jvm启动参数
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 *
 * -Xms 为jvm启动时分配的堆内存
 * -Xmx 为jvm运行过程中分配的最大堆内存
 * -Xss 为jvm启动的每个线程分配的内存大小
 * -Xmn 设置年轻代大小。整个堆大小=年轻代大小 + 年老代大小 + 持久代大小？？？？？？（不确定）。
 */
public class HeapOOM {
    static class OOMOject{

    }

    public static void main(String[] args) {
        List<OOMOject> list=new ArrayList<>();
        while(true){
            list.add(new OOMOject());
        }
    }
}
