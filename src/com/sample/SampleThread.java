package com.sample;

public class SampleThread {
	public static void main(String[] args) {
		Thread myRunThrd = new Thread(new MyRunnableThread());
		Thread myRunThrd2 = new Thread(new MyRunnableThread());
		myRunThrd.setName("Thread1");
		myRunThrd2.setName("Thread2");
//		MyThread myThrd = new MyThread();
		myRunThrd.start();
		myRunThrd2.start();
//		myThrd.start();
	}
}
