package com.shangpin.threads.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread implements Runnable {

	private boolean ta = true;
	private boolean tb = false;
	private Lock lock = new ReentrantLock();
	private volatile int i = 1;
	
	@Override
	public void run() {
		// ta.
		while (true) {
			
			if (i > 30) {
				break;
			}

			lock.lock();
			String str = "";
			if (ta && Thread.currentThread().getName().equals("线程A")) {
				System.out.println("A:" + i ++);
				str = Thread.currentThread().getName();
			}
			if (tb && Thread.currentThread().getName().equals("线程B")) {
				System.out.println("B:" + i ++);
				str = Thread.currentThread().getName();
			}
			if (i % 4 ==0 && str.equals (Thread.currentThread().getName())) {
				ta = !ta;
				tb = !tb;
			}
			lock.unlock();
		}
		//
	}

}

public class Example {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t1 = new Thread(mt,"线程A");
		Thread t2 = new Thread(mt,"线程B");
		t1.start();
		t2.start();
//		ExecutorService pool = Executors.newFixedThreadPool(2);
//		pool.execute(mt);
//		pool.execute(mt);
//		pool.shutdown();
	}
}
