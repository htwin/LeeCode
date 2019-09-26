package com.ht.leetcode;

import java.util.Scanner;

public class Main implements Runnable {

    public static StringBuffer inStr = new StringBuffer();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        inStr.append(str);

        Main m = new Main();
        try {
            Thread thread1 = new Thread(m, inStr + "1");
            Thread thread2 = new Thread(m, inStr + "2");
            Thread thread3 = new Thread(m, inStr + "3");
            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();

            thread3.start();
            thread3.join();
            System.out.println(inStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        if(name.endsWith("1")){
            inStr.append("_A");
        }
        if(name.endsWith("2")){
            inStr.append("_B");
        }
        if(name.endsWith("3")){
            inStr.append("_C");
        }


    }
}
