package com.shangpin.threads.basic.chapter02;

/**
 * 后台线程<br>
 * 
 * <pre>
 * 我们知道，在Java程序中，只要有一个线程在运行，那么整个Java进程就
 * 不会消失。所以此时可以设置一个后台线程。
 * </pre>
 * @author percy
 *
 */
class MyThread06 implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + "在运行。");
		}
	}
	
}

public class ThreadDaemonDemo {
	public static void main(String[] args) {
		MyThread06 mt = new MyThread06();
		Thread t = new Thread(mt, "线程");
		t.setDaemon(true);// 此线程在后台运行
		t.start(); // 启动线程
	}
}
