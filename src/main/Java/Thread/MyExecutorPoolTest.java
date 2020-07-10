package Thread;

import Utils.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 */
public class MyExecutorPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                3, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10),
                new MyThreadFactory("TestPool"),
                new MyRejectedExecutionHandler());
        //分成若干组个任务
        List<List<Integer>> lists = ListUtils.averageDistribution(getList(1000), 12);
        for (int i = 0; i < lists.size(); i++) {
            executor.execute(new MyTask("Task"+i,lists.get(i)));
        }
            executor.shutdown();
    }

    public static List<Integer> getList(int size){
        ArrayList<Integer> integers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            integers.add(i);
        }
        return integers;
    }
}
