package Thread;

import java.util.List;

public class MyTask implements Runnable {

    private List<Integer> list;

    private String name;

    public MyTask(String name,List<Integer> list) {
        this.name = name;
        this.list = list;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "***************执行完毕!执行时间:"+(end - start)+"ms");
    }
}
