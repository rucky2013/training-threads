package com.shangpin.threads.basic.chapter02;

/**
 * 判断线程是否启动
 * 
 * @author percy
 *
 */
class MyThread02 implements Runnable { // 实现Runnable接口

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "运行， i = "
					+ i);
		}

	}
}

public class ThreadAliveDemo {
	public static void main(String[] args) {
		MyThread02 mt = new MyThread02();
		Thread t = new Thread(mt, "线程");
		System.out.println("线程开始执行之前 --> " + t.isAlive()); // 判断线程是否启动
		t.start();// 启动线程
		System.out.println("线程开始执行之后 --> " + t.isAlive());

		for (int i = 0; i < 3; i++) {
			System.out.println("Main 运行 --> " + i);
		}
		// 以下的输出结果不确定
		System.out.println("代码执行之后 --> " + t.isAlive());
		
		/*

线程开始执行之前 --> false
线程开始执行之后 --> true
Main 运行 --> 0
Main 运行 --> 1
Main 运行 --> 2
代码执行之后 --> true
线程运行， i = 0
线程运行， i = 1
线程运行， i = 2


		 */
	}
}
