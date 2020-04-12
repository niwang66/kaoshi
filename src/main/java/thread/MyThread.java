package thread;

import java.util.ArrayList;
import java.util.List;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunner("t1"));
        t1.start();
        Thread t2 = new Thread(new MyRunner("t2"));
        t2.start();
        List<Thread> l = new ArrayList<>();
        t1.join(10);
        l.forEach(Thread::interrupt);

    }
}

class MyRunner implements Runnable{
    String name;
    public MyRunner(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(name + "-" +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

