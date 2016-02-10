/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContohInterupt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author min
 */
public class MyInterupt extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("MyThread dimulai");
            System.out.println("MyThread: silahkan tunggu 5 detik...");
            Thread.sleep(5000);
            System.out.println("MyThread selesai");
        } catch (InterruptedException ex) {
            System.out.println("MyThread diinterrupt!");
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread dimulai");
        Thread myThread = new MyInterupt();
        myThread.start();
        System.out.println("Main thread: silahkan tunggu 1 detik...");
        Thread.sleep(1000);
        myThread.interrupt();
        System.out.println("Main thread selesai");
    }
}
