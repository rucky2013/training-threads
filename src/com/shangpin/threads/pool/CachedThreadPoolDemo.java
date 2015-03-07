package com.shangpin.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread02 extends Thread{
	
	public MyThread02(String name) {
		super(name);
	}
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName()+"正在执行。。。");
    }
}

public class CachedThreadPoolDemo {
	
	public static void main(String[] args) {
		//创建一个可重用固定线程数的线程池
	    ExecutorService pool2 = Executors.newCachedThreadPool();
	   
	    //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
	    Thread t1 = new MyThread02("AAA");
	    Thread t2 = new MyThread02("BBB");
	    Thread t3 = new MyThread02("CCC");
	    Thread t4 = new MyThread02("DDD");
	    Thread t5 = new MyThread02("EEE");
	    
	    //将线程放入池中进行执行
	    pool2.execute(t1);
	    pool2.execute(t2);
	    pool2.execute(t3);
	    pool2.execute(t4);
	    pool2.execute(t5);
	    //关闭线程池
	    pool2.shutdown();
	}
	
}
