package com.siddharth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SpringWithThread {
	public static void main(String[] args) {
		SpringWithThread obj = new SpringWithThread();
		long s1 = System.nanoTime();
		obj.doOperation();
		long e1 = System.nanoTime();
		System.out.println(e1-s1);
//		long s2 = System.nanoTime();
//		obj.doOperation2();
//		long e2 = System.nanoTime();
//		System.out.println(e2-s2);
	}

	private void doOperation() {
		List <String> finalList = new ArrayList<>();
		int numOfThreads = 100, numOfItems = 100;
		for (int i = 1; i <= numOfThreads; i++) {
			Thread t = new Thread(() -> {
				for (int j = 1; j <= numOfItems; j++) {
					synchronized (finalList) {						
						finalList.add("Name : "+Thread.currentThread().getName()+" / j :"+j);
//						try {
//							Thread.currentThread().sleep(1000);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
					}
				}
			}, "t"+i);
			t.start();
		}
		System.out.println();
		for (String string : finalList) {
			System.out.println(string);
		}
	}
	
	private void doOperation2() {
		Map<String, String> finalList = new ConcurrentHashMap<>();
		int numOfThreads = 300, numOfItems = 300;
		for (int i = 1; i <= numOfThreads; i++) {
			for (int j = 1; j <= numOfItems; j++) {
				finalList.put("Name : "+Thread.currentThread().getName()+" -> j :"+j, "");
			}
		}
//		for (String string : finalList) {
//			System.out.println(string);
//		}
	}
}
