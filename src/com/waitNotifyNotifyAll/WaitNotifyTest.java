package com.waitNotifyNotifyAll;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifyTest {

    public static void main(String[] args) {
        Message msg = new Message("process it");
        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1,"waiter1").start();
        
        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "waiter2").start();
        
        Notifier notifier1 = new Notifier(msg);
        new Thread(notifier1, "notifier1").start();
        System.out.println("All the threads are started");
    	
    }
}