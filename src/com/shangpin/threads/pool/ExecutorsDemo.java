package com.shangpin.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池练习<br>
 * 
 * <pre>
 * 线程池分为多种：
 * 固定尺寸的线程池、可变尺寸的线程池
 * </pre>
 * @author percy
 *
 */
class MyThread extends Thread{
	
	public MyThread(String name) {
		super(name);
	}
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName()+"正在执行。。。");
    }
}

public class ExecutorsDemo {
	public static void main(String[] args) {
		//创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread("AAA");
        Thread t2 = new MyThread("BBB");
        Thread t3 = new MyThread("CCC");
        Thread t4 = new MyThread("DDD");
        Thread t5 = new MyThread("EEE");
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown(); 
	}
}
