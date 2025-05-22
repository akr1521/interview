package app.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {


    public static void main(String[] args) {
      //  SharedResource.threadInit();

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        Future<String> future = executorService.submit(() -> "Task Result");
        try {;

            System.out.println(future.get()); // Fetches result
            if ( future.isDone())
                future.cancel( true);
            System.out.println(" Future is Donee:"   + future.isDone());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown(); // Gracefully shuts down the service
        System.out.println( " is Executor been Shut down: "+ executorService.isShutdown());
    }

    public static  void threadInit(){
        Thread t1 = new Capture();
        Thread t2 = new Capture();
        Thread t3 = new Capture();

        t1.start();
        t2.start();
        t3.start();
    }

}


class Resource{
    private static int counter = 0;

    public static synchronized void incrementCounter() {
        counter++;
        System.out.println("Counter: " + counter);
    }

    public static void incCounter(){

        Lock lock = new ReentrantLock();

        if (lock.tryLock())
        lock.lock();

        counter++;
        System.out.println("Counter :  " + counter);
        lock.unlock();
    }


}

class ShareadResourceWithLock{



}


class  Capture extends Thread{
    @Override
    public void run() {
        Resource.incrementCounter();
    }
}