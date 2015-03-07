package com.shangpin.threads.basic;

/**
 * Thread与Runnable之间 的区别<br>
 * 
 * <pre>
 * Thread无法实现共享，而Runnable可以
 * 
 * 
 * </pre>
 * 
 * 
 * @author percy
 *
 */
public class TicketRunnable implements Runnable { // 继承Thead类，作为线程的实现类

	private int ticket = 5; // 表示一共有5张票

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (this.ticket > 0) {
				System.out.println("卖票：ticket = " + ticket--);
			}
		}
	}

}
