/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContohSleep;

/**
 *
 * @author min
 */
public class MainSleep {
    public static void main(String[] args) {
        MySleep sleep = new MySleep();
        sleep.start();
    }
}

class MySleep extends Thread{

    @Override
    public void run() {
        
        for(int a = 0 ; a <= 20; a++){
        
            try{
                Thread.sleep(2000);
                System.out.println("name thread "+ Thread.currentThread().getName());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        //super.run(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
