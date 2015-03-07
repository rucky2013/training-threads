package com.shangpin.threads.basic.chapter02;

/**
 * 测试线程名字<br>
 * 
 * <pre>
 * 一个人在出生的时候给一个名字，但是这个人活到60岁，
 * 开始想改名字了。
 * 这样肯定很麻烦。
 * 线程名字在线程启动之前设置，避免重复
 * 
 * </pre>
 * 
 * @author percy
 *
 */

class MyThread implements Runnable { // 实现Runnable接口

	@Override
	public void run() {// 覆写run()方法
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "运行， i = "
					+ i);
		}
	}

}

public class ThreadNameDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread(); // 实例化Runnable子类对象
		new Thread(mt).start();
		new Thread(mt, "线程-A").start();
		new Thread(mt, "线程-B").start();
		new Thread(mt).start();
		new Thread(mt).start();
	}
}
