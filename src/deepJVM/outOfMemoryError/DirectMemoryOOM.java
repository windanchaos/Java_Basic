package deepJVM.outOfMemoryError;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出
 * 使用unsafe分配本机内存
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=10m  -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 */
public class DirectMemoryOOM {
    private static final int _1MB=1024*1024;
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField= Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe=(Unsafe) unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }

    }
}
