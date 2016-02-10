/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContohDaemon;

/**
 *
 * @author min
 */
public class MainTest {
    
    public static void main(String[] args) {
        Daemon daemon = new Daemon();
        Thread th = new Thread(daemon);
        th.setDaemon(true);
        th.start();
        
        try{
            System.out.println("Thread name : "+ Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch(Exception e){e.printStackTrace();}
    }
    
}
