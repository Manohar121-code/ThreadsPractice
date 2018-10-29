package com.sample;

public class MyRunnableThread implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				System.out.println(Thread.currentThread().getName()+" - "+i);
				Thread.sleep(1000);
				if (i == 3) {
					this.wait(10000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
