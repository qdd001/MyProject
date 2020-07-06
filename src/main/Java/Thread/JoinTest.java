package Thread;

public class JoinTest {
    public static void main(String[] args) throws Exception {
        ThreadTest1 t1 = new ThreadTest1("A");
        ThreadTest2 t2 = new ThreadTest2("B");

        t1.start();
        t1.notify();
        t1.wait();
        t1.join();
        t2.start();

    }

}

class ThreadTest1 extends Thread {
    private String name;

    public ThreadTest1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "-->" + i);
        }
    }
}

class ThreadTest2 extends Thread {
    private String name;

    public ThreadTest2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "-->" + i);
        }
    }
}