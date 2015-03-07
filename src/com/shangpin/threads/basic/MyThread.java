package com.shangpin.threads.basic;

public class MyThread extends Thread { // 继承Thread类，作为线程的实现类
	private String name; // 标识线程的名称

	public MyThread(String name) {
		this.name = name; // 通过构造方法配置name属性
	}

	@Override
	public void run() { // 覆写run()方法，作为线程的操作主体
		for (int i = 0; i < 10; i++) {
			System.out.println(name + "运行， i = " + i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
