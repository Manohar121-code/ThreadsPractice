package com.standAloneWaitNotify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Customer {
	int amount = 10000;

	synchronized void withdraw(int amount, Thread thread) {
		System.out.println("going to withdraw...");

		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
				thread.sleep(3000);
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("withdraw completed...");
	}

	synchronized void deposit(int amount, Thread thread) {
		System.out.println("going to deposit...");
		this.amount += amount;
		System.out.println("deposit completed... ");
		notify();
	}
}

class StandAloneWaitNotify {
	public static void main(String args[]) {
		final Customer c = new Customer();
		new Thread() {
			public void run() {
				c.withdraw(15000,this);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(10000,this);
			}
		}.start();

	}
}
