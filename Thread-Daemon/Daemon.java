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
public class Daemon implements Runnable{

    @Override
    public void run() {
        while(true){
            String name = Thread.currentThread().getName();
            Boolean statusDaemon = Thread.currentThread().isDaemon();
            try{
                Thread.sleep(1000);
            } catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("name thread "+ name +", status : "+ statusDaemon);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
