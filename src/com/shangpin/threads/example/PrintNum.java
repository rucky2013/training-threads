package com.shangpin.threads.example;

public class PrintNum {
	public static Boolean isThreadA = true;
	public static Boolean isThreadB = false;

	public static void main(String[] args) {
		final PrintNum abc = new PrintNum();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i < 31; i++) {
					synchronized (abc) {
						while (!isThreadA) {
							try {
								abc.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if (i % 4 == 0) {
							isThreadA = false;
							isThreadB = true;
							abc.notifyAll();
						} else {
							System.out.println("A" + i);
						}
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i < 31; i++) {
					synchronized (abc) {
						while (!isThreadB) {
							try {
								abc.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if (i % 4 == 0) {
							isThreadA = true ;
							isThreadB = false;
							abc.notifyAll();
						} else {
							System.out.println("B" + i);
						}
					}
				}
			}
		}).start();
	}
}
