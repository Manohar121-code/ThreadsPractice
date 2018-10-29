package com.yield;

import java.util.ArrayList;
import java.util.List;

class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println(Thread.currentThread().getName() + " -> " + i);
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
}

public class YieldExample {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread(), "t1");
		t1.setPriority(1);
//		Thread t2 = new Thread(new MyThread(), "t2");
//		t2.setPriority(5);
		Thread t3 = new Thread(new MyThread(), "t3");
		t3.setPriority(10);
		t1.start();
		t1.yield();
//		t2.start();
		t3.start();
	}
}
