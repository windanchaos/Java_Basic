package thead.book.multiThread.section4;

import java.util.Timer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        lock.readLock().lock();
        Timer timer = new Timer();
    }
}