package com.shangpin.threads.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java 新特征<br>
 * 
 * <pre>
 * 
 * 专门提供了锁对象，利用锁可以方便的实现资源的封锁，
 * 用来控制对竞争资源并发访问的控制，
 * 
 * 
 * 里面有三个重要的接口Condition、Lock、ReadWriteLock。
 * 
 * 
 * Lock实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作。
 * 
 * ReadWriteLock维护了一对相关的锁定，一个用于只读操作，另一个用于写入操作。
 * </pre>
 * 
 * <br>
 * 
 * <pre>
 * 区分一下Lock, synchronized:
 * 
 * Lock
 * Lock的锁定是通过代码实现的，而 synchronized 是在 JVM 层面上实现的
 * synchronized在锁定时如果方法块抛出异常，JVM 会自动将锁释放掉，不会因为出了异常没有释放锁造成线程死锁。
 * 但是 Lock 的话就享受不到 JVM 带来自动的功能，出现异常时必须在 finally 将锁释放掉，否则将会引起死锁。
 * 在资源竞争不是很激烈的情况下，偶尔会有同步的情形下，synchronized是很合适的。
 * 原因在于，编译程序通常会尽可能的进行优化synchronize，
 * 另外可读性非常好，不管用没用过5.0多线程包的程序员都能理解。 
 * 
 * ReentrantLock
 * ReentrantLock提供了多样化的同步，比如有时间限制的同步，
 * 可以被Interrupt的同步（synchronized的同步是不能Interrupt的）等。
 * 在资源竞争不激烈的情形下，性能稍微比synchronized差点点。
 * 但是当同步非常激烈的时候，synchronized的性能一下子能下降好几十倍。而ReentrantLock确还能维持常态。 
 * 
 * Atomic
 * 和上面的类似，不激烈情况下，性能比synchronized略逊，而激烈的时候，也能维持常态。
 * 激烈的时候，Atomic的性能会优于ReentrantLock一倍左右。
 * 但是其有一个缺点，就是只能同步一个值，一段代码中只能出现一个Atomic的变量，多于一个同步无效。
 * 因为他不能在多个Atomic之间同步。 
 * Lock的使用参见下面的代码（把lock换成synchronized的效果是一样的）
 * 
 * </pre>
 * 
 * @author percy
 *
 */
public class LockDemo {

	public static void main(String[] args) {
		// 创建并发访问的账户
		MyCount myCount = new MyCount("95599200901215522", 10000);
		// 创建一个锁对象
		Lock lock = new ReentrantLock();
		// 创建一个线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		// 创建一些并发访问用户，一个信用卡，存的存，取的取，好热闹啊
		User u1 = new User("张三", myCount, -4000, lock);
		User u2 = new User("张三他爹", myCount, 6000, lock);
		User u3 = new User("张三他弟", myCount, -8000, lock);
		User u4 = new User("张三", myCount, 800, lock);
		// 在线程池中执行各个用户的操作
		pool.execute(u1);
		pool.execute(u2);
		pool.execute(u3);
		pool.execute(u4);
		// 关闭线程池
		pool.shutdown();
		
		/*
张三正在操作MyCount{oid='95599200901215522', cash=10000}账户，金额为-4000，当前金额为10000
张三操作MyCount{oid='95599200901215522', cash=6000}账户成功，金额为-4000，当前金额为6000
张三他弟正在操作MyCount{oid='95599200901215522', cash=6000}账户，金额为-8000，当前金额为6000
张三他弟操作MyCount{oid='95599200901215522', cash=-2000}账户成功，金额为-8000，当前金额为-2000
张三他爹正在操作MyCount{oid='95599200901215522', cash=-2000}账户，金额为6000，当前金额为-2000
张三他爹操作MyCount{oid='95599200901215522', cash=4000}账户成功，金额为6000，当前金额为4000
张三正在操作MyCount{oid='95599200901215522', cash=4000}账户，金额为800，当前金额为4000
张三操作MyCount{oid='95599200901215522', cash=4800}账户成功，金额为800，当前金额为4800



从上面的输出可以看到，利用锁对象太方便了，比直接在某个不知情的对象上用锁清晰多了。

但一定要注意的是，在获取了锁对象后，用完后应该尽快释放锁，以便别的等待该锁的线程有机会去执行。
		 */

	}

}

/**
 * 信用卡的用户
 */
class User implements Runnable {
	private String name; // 用户名
	private MyCount myCount; // 所要操作的账户
	private int iocash; // 操作的金额，当然有正负之分了
	private Lock myLock; // 执行操作所需的锁对象

	User(String name, MyCount myCount, int iocash, Lock myLock) {
		this.name = name;
		this.myCount = myCount;
		this.iocash = iocash;
		this.myLock = myLock;
	}

	public void run() {
		// 获取锁
		myLock.lock();
		// 执行现金业务
		System.out.println(name + "正在操作" + myCount + "账户，金额为" + iocash
				+ "，当前金额为" + myCount.getCash());
		myCount.setCash(myCount.getCash() + iocash);
		System.out.println(name + "操作" + myCount + "账户成功，金额为" + iocash
				+ "，当前金额为" + myCount.getCash());
		// 释放锁，否则别的线程没有机会执行了
		myLock.unlock();
	}
}

/**
 * 信用卡账户，可随意透支
 */
class MyCount {
	private String oid; // 账号
	private int cash; // 账户余额

	MyCount(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "MyCount{" + "oid='" + oid + '\'' + ", cash=" + cash + '}';
	}
}
