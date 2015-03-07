package com.shangpin.threads.basic;

public class RunnableDemo02 {
	
	public static void main(String[] args) {
		TicketRunnable mr1 = new TicketRunnable(); // 实例化对象
		
		Thread t1 = new Thread(mr1, "线程 A ");// 实例化Thread对象
		Thread t2 = new Thread(mr1, "线程 B ");// 实例化Thread对象
		Thread t3  = new Thread(mr1, "线程 B ");// 实例化Thread对象
		t1.start();
		t2.start();
		t3.start();
		
		/*
卖票：ticket = 5
卖票：ticket = 4
卖票：ticket = 3
卖票：ticket = 2
卖票：ticket = 1


资源共享
		 */
	}

}
