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
public class ThreadDemo02 {

	public static void main(String[] args) {
		MyThread mt1 = new MyThread("线程 A ");// 实例化对象
		MyThread mt2 = new MyThread("线程 B ");// 实例化对象
		
		mt1.start();// 调用线程主体
		mt2.start();// 调用线程主体
		/*
线程 A 运行， i = 0
线程 B 运行， i = 0
线程 A 运行， i = 1
线程 B 运行， i = 1
线程 B 运行， i = 2
线程 A 运行， i = 2
线程 A 运行， i = 3
线程 B 运行， i = 3
线程 A 运行， i = 4
线程 B 运行， i = 4
线程 A 运行， i = 5
线程 B 运行， i = 5
线程 A 运行， i = 6
线程 B 运行， i = 6
线程 A 运行， i = 7
线程 B 运行， i = 7
线程 A 运行， i = 8
线程 B 运行， i = 8
线程 A 运行， i = 9
线程 B 运行， i = 9

从结果来看：并没有实现达到所谓的并发执行的效果。
		 */
	}

}
