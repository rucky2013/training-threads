package com.shangpin.threads.basic.chapter02;

/**
 * 线程的优先级
 * 
 * @author percy
 *
 */
class MyThread07 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000); // 线程休眠
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "运行， i = "
					+ i); // 取得当前线程的
		}
	}

}

public class ThreadPriorityDemo {
	public static void main(String[] args) {
//		MyThread07 mt = new MyThread07();
		Thread t1 = new Thread(new MyThread07(), "线程 A ");
		Thread t2 = new Thread(new MyThread07(), "线程 B ");
		Thread t3 = new Thread(new MyThread07(), "线程 C ");
		t1.setPriority(Thread.MIN_PRIORITY); // 最低优先级
		t2.setPriority(Thread.MAX_PRIORITY);// 最高优先级
		t3.setPriority(Thread.NORM_PRIORITY);// 普通优先级

		t1.start();
		t2.start();
		t3.start();
	}
}
