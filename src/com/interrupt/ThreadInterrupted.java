package com.interrupt;

class Thread1 extends Thread {
	public Thread1(String string) {
		super(string);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(100);
				System.out.println("Current Thread: " + Thread.currentThread().getName());
			} catch (Exception ex) {
				System.out.println("Exception has" + " been caught for "+ Thread.currentThread().getName() + " " + ex);
			}
			System.out.println(Thread.currentThread().getName() + " -> " + i);
		}
	}
}

public class ThreadInterrupted {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1("t1");
		Thread1 t2 = new Thread1("t2");
		
		t1.start();
		t1.interrupt();
		
		t2.start();
	}
}
