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

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        
        // interupt
        mt.start();
        try{
            Thread.sleep(5000);
            mt.interrupt();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        System.out.println("Default Thread : "+ Thread.currentThread().getName());
    }
    
}


class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("akan menjalankan thread : "+ Thread.currentThread().getName());
        try{
            Thread.sleep(20000); // akan di masukkan pada state block selama 20 detik
        } catch(Exception e){e.printStackTrace();}
        System.out.println("MyTread "+Thread.currentThread().getName()+" Selesai");
        //super.run(); //To change body of generated methods, choose Tools | Templates.
    }

    
}