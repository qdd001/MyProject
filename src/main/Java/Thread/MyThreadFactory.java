package Thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = new AtomicInteger();

    //private final ThreadGroup group = new ThreadGroup("TestGroup");

    private String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, poolName + poolNumber.getAndIncrement());
        System.out.println(thread.getName() + "线程已创建");
        return thread;
    }
}
