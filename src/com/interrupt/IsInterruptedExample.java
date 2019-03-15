package com.interrupt;

class SampleThread extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			//if (Thread.interrupted()) { // it will make current thread interrupted state to false if it is true, after this check
			if (isInterrupted()) { // it will give true or false according to condition
				System.out.println(Thread.currentThread().getName() + " is interrupted!!! " + i);
			} else {
				System.out.println(Thread.currentThread().getName() + " is Not!!! " + i);
			}
		}
	}
}

public class IsInterruptedExample {
	public static void main(String[] args) {
		SampleThread t1 = new SampleThread();
		SampleThread t2 = new SampleThread();
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		t1.interrupt();
		
		t2.start();
	}
}
