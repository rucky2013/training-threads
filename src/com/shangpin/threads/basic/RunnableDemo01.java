package com.shangpin.threads.basic;

public class RunnableDemo01 {
	
	public static void main(String[] args) {
		MyRunnable mr1 = new MyRunnable(); // 实例化对象
//		MyRunnable mr2 = new MyRunnable("线程 B ");// 实例化对象
		
		Thread t1 = new Thread(mr1, "线程 A ");// 实例化Thread对象
		Thread t2 = new Thread(mr1, "线程 B ");// 实例化Thread对象
		
		t1.start();
		t2.start();
	}

}
