/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContohJoin;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author min
 */
public class MainJoin {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());
        Thread thread3 = new Thread(new MyThread());
        
        // execute 
        thread1.start();
        try{
            thread1.join();
        } catch(Exception e){e.printStackTrace();};
        
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MainJoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        thread3.start();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread name : "+ Thread.currentThread().getName());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}