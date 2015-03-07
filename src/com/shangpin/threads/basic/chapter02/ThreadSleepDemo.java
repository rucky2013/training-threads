package com.shangpin.threads.basic.chapter02;

/**
 * 线程的休眠
 * 
 * @author percy
 *
 */
class MyThread04 implements Runnable {

	@Override
	public void run() { // 覆写run()方法
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "运行, i = "
					+ i);
		}
	}

}

public class ThreadSleepDemo {
	public static void main(String[] args) {
		MyThread04 mt = new MyThread04();
		Thread t = new Thread(mt, "线程");
		t.start();
		
	}
}
