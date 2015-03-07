package com.shangpin.threads.basic;

/**
 * 介绍＜br>
 * 
 * <pre>
 * 
 * 进程是程序的一次动态执行过程，它经历了从代码加载、执行到执行完毕
 * 的一个完整的过程，这个过程是进程本身从产生、发展到最终消亡的过程。
 * 
 * 多线程是实现并发机制的一种有效手段。进程和线程一样，都是实现并发的
 * 一个并发单位。
 * 
 * 在Java中想实现多线程可以采用两种方式：
 * 继承Thread类
 * 实现Runnable接口
 * 
 * 
 * </pre>
 * 
 * @author percy
 *
 */
public class ThreadDemo03 {

	public static void main(String[] args) {
		TicketThread mt1 = new TicketThread();// 实例化对象
		TicketThread mt2 = new TicketThread();// 实例化对象
		TicketThread mt3 = new TicketThread();// 实例化对象
		mt1.start();// 调用线程主体
		mt2.start();// 调用线程主体
		mt3.start();// 调用线程主体
		/*
卖票：ticket = 5
卖票：ticket = 4
卖票：ticket = 3
卖票：ticket = 2
卖票：ticket = 1
卖票：ticket = 5
卖票：ticket = 4
卖票：ticket = 3
卖票：ticket = 2
卖票：ticket = 1
卖票：ticket = 5
卖票：ticket = 4
卖票：ticket = 3
卖票：ticket = 2
卖票：ticket = 1


从结果来看：一共卖出15张票
		 */
	}

}
