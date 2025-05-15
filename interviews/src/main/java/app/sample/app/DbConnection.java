package app.sample.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DbConnection {
    private final Semaphore semaphore;
    int counter = 0;

    public  DbConnection(){
             semaphore =  new Semaphore( 10);
    }


    public  void connect(){
        try {
            if  (semaphore.tryAcquire()){
                System.out.println( " Semaphore  : Acquire is  working" );
            }

            semaphore.acquire();
            counter++;
            System.out.println(   " counter Value : " + counter + "  Thread nane: " +  Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
        }

    }



    public static void main( String  args[]){
        DbConnection dbConnection = new DbConnection() ;
       Runnable runnable  = new Runnable() {
           @Override
           public void run () {
               dbConnection.connect();
           }
       };

        Thread f  =new Thread(   runnable);
        f.setName( " First");
        f.start();
        Thread  s  = new Thread(  runnable);
        s.setName("second");
        s.start();
        try {
            f.join();
            Thread.sleep( 2000);
            s.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void  futureDemo() {
        ExecutorService executor =  Executors.newFixedThreadPool(5);

    }



}

