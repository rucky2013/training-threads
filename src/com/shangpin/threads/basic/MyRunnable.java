package com.shangpin.threads.basic;

public class MyRunnable implements Runnable { // 实现Runnable接口，作为线程的实现类

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "运行， i = " + i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
