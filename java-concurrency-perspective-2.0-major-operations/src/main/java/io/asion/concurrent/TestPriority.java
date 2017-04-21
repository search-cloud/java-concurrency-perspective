package io.asion.concurrent;

import org.junit.Test;

/**
 * 实现Runnable接口的方式，创建线程
 *
 * @author Asion
 * @since 2017/03/24
 */
class PriorityDemo implements Runnable {
    // 持有Thread的一个引用
    private Thread t;
    // 线程名称
    private String threadName;

    /**
     * 构造一个Runnable实例
     *
     * @param name 线程名称
     */
    PriorityDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    /**
     * 重写run()方法
     * 从100倒数到1。
     */
    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 100; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    /**
     * 普通start()方法
     */
    void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            // 真正调用线程类的start()方法，启动线程
            t.start();
        }
    }

    void start(Thread t) {
        this.t = t;
        this.t.start();
    }

}

public class TestPriority {
    // 启动两个线程测试
    @Test
    public void testPriority() {
        PriorityDemo r1 = new PriorityDemo("Thread-1");
        Thread thread = new Thread(r1, "Thread-1");
        thread.setPriority(Thread.MIN_PRIORITY);
        r1.start(thread);

        PriorityDemo r2 = new PriorityDemo("Thread-2");
        Thread thread1 = new Thread(r1, "Thread-2");
        System.out.println(thread1.getPriority());
        r2.start();
    }
}