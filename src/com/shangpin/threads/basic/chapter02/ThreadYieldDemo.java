package com.shangpin.threads.basic.chapter02;

/**
 * 线程礼让
 * 
 * @author percy
 *
 */
class MyThread08 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "运行， i = "
					+ i);// 取得当前线程的名称
			if (i % 3 == 0) {
				System.out.println("线程礼让：");
				Thread.yield();
			}
		}
	}

}

public class ThreadYieldDemo {
	public static void main(String[] args) {
		MyThread08 mt = new MyThread08();
		Thread t1 = new Thread(mt, "线程 A ");
		Thread t2 = new Thread(mt, "线程 B ");
		t1.start();
		t2.start();
	}
}
