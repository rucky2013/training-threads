package com.shangpin.threads.basic.chapter02;

/**
 * 线程的强制执行
 * 
 * @author percy
 *
 */
class MyThread03 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out
					.println(Thread.currentThread().getName() + "运行，i = " + i);// 取得当前线程名字
		}
	}

}

public class ThreadJoinDemo {
	public static void main(String[] args) {
		MyThread03 mt = new MyThread03(); // 实例化Runnable子类对象
		Thread t = new Thread(mt, "线程");// 实例化Thread对象
		t.start(); // 启动线程
		for (int i = 0; i < 50; i++) {
			if (i > 10) {
				try {
					t.join(); // 线程强制执行
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Main 线程运行 --> " + i);
		}

	}
}
