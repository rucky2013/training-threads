package com.shangpin.threads.basic.chapter02;

/**
 * 线程的挂起和唤醒
 * 
 * @author percy
 *
 */
class MyThread09 implements Runnable {
	
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			if (i % 3 == 0) {
				try {
					Thread.currentThread().sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "线程：" + i);
		}

	}

}

public class ThreadSuspendDemo {
	public static void main(String[] args) {
		MyThread09 mt = new MyThread09();
		Thread t1 = new Thread(mt, "线程 A ");
		Thread t2 = new Thread(mt, "线程 B ");

		t1.start();
		t2.start();
	}
}
