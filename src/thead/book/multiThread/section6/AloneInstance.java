package thead.book.multiThread.section6;

import java.io.*;

public class AloneInstance {
    private static AloneInstance instance;

    private AloneInstance() {
    }

    public static AloneInstance getInstance() {
        if (instance == null) {
            System.out.println("somethine init need to do");
            synchronized (AloneInstance.class) {
                if (instance == null)
                    instance = new AloneInstance();
            }
        }
        return instance;
    }
}

class Singleton implements Serializable {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //防止序列化破坏单例模式
    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
