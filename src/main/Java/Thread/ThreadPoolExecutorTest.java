package Thread;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        new Thread(new Productor(queue)).start();
        new Thread(new Customer(queue)).start();
    }
}

class Productor implements Runnable{
    private BlockingQueue<Integer> queue;

    public Productor(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    int count = 1;

    @Override
    public void run() {
        while (true){
            try {
                queue.put(count);
                System.out.println("生产者正在生产第"+count+"个商品...");
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer implements Runnable{
    private BlockingQueue<Integer> queue;

    public Customer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                Integer count = queue.take();
                System.out.println("消费者正在消费第"+count+"个商品...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}