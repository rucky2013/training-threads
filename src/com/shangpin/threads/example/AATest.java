package com.shangpin.threads.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class MyThread implements Runnable {
	private PrintNumInner printNumInner = new PrintNumInner(10); // 账户
	@Override
	public void run() {
		printNumInner.print();
	}
	
}

class PrintNumInner {
	private int num;
	private Lock lock = new ReentrantLock(); // 锁
	private Condition _change = lock.newCondition(); // 条件
	
	public PrintNumInner(int num) {
		this.num = num;
	}
	
	public void print() {

		lock.lock();
		for (int i = 0; i < 30; i++) {
			System.out.println(Thread.currentThread().getName() + "==========" + i ) ;
		}
		lock.unlock();

	}
	
}
public class AATest {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.execute(mt);
		pool.execute(mt);
		pool.shutdown();
	}
}
