package io.asion.concurrent;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Asion.
 * @since 2017/4/9.
 */
public class TestJoin extends TestCase {
    // 启动两个线程测试
    @Test
    public void testJion() {
        JoinDemo r1 = new JoinDemo("Thread-1");
        Thread thread = new Thread(r1, "Thread-1");
        r1.start(thread);

        JoinDemo r2 = new JoinDemo("Thread-2");
        r2.start();

        r1.join();
        r2.join();

        for (int i = 10; i > 0; i--) {
            System.out.println("Thread: main" + Thread.currentThread().getId() + ", " + i);
        }

        System.out.println("Thread main" + Thread.currentThread().getId() + " finish.");
    }
}

/**
 * 实现Runnable接口的方式，创建线程
 *
 * @author Asion
 * @since 2017/03/24
 */
class JoinDemo implements Runnable {
    // 持有Thread的一个引用
    private Thread t;
    // 线程名称
    private String threadName;

    /**
     * 构造一个Runnable实例
     *
     * @param name 线程名称
     */
    JoinDemo(String name) {
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
        for (int i = 10; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
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
        t.start();
    }

    void join() {
        try {
            this.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
