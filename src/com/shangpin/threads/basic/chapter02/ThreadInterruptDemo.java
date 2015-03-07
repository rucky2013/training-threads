package com.shangpin.threads.basic.chapter02;

/**
 * 线程中断<br>
 * 
 * 一个线程可以被另外一个线程中断
 * 
 * 
 * @author percy
 *
 */
class MyThread05 implements Runnable {

	@Override
	public void run() {// 覆写run()方法
		System.out.println("1、进入run()方法");
		try {
			Thread.sleep(10000);// 线程休眠10秒
			System.out.println("2、已经完成了休眠");
		} catch (InterruptedException e) {
			System.out.println("3、休眠被终止");
			e.printStackTrace();
			return;
		}

		System.out.println("4、run()方法正常结束");

	}

}

public class ThreadInterruptDemo {
	
	public static void main(String[] args) {
		MyThread05 mt = new MyThread05();
		Thread t = new Thread(mt, "线程");
		t.start(); // 启动线程
		
		try {
			Thread.sleep(2000); //线程休眠2秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt();
	}

}
