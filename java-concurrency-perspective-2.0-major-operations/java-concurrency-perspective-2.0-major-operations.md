---
title: Java Concurrency Perspective Major Operations (二)  </br> Java 并发透视之主要操作（二）
date: 2017-03-24 12:07:01
categories: [java, concurrency]
tags: [java, concurrency]
---

# Java 并发透视之主要操作（二）


## java 多线程的主要操作

|方法|简介|
|:----:|:----|
|**sleep(long)**|该方法使当前线程睡眠一定时间，单位为毫秒（ms）|
|**getPriority()**|该方法可以获取线程的优先级|
|**setPriority(int)**|该方法设置线程的优先级，但是并不能保证按这个优先级优先运行|
|**yield()**|该方法让出CUP资源，让其他线程先执行|
|**join()**|该方法合并一个线程到当前线程|
|**wait()**|当前线程等待其他线程调用notify()后才会继续运行|
|**notify()**|该方法唤醒一个等待中的线程|
|**notifyAll()**|该方法所有正在等待的线程|

## sleep()
还是上一级的例子，但是我们在run()方法的循环体中添加了 Thread.sleep(50); 语句。
每当循环一次，线程就睡眠50毫秒；这样输出的结果就是，Thread-1：

```java
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
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

```

## setPriority(int) & getPriority()

## yield()

## join()

## wait()

## notify()

## notifyAll()

    