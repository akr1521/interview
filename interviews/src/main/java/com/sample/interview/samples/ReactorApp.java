package com.sample.interview.samples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ReactorApp {

    public static void main (String args[]){
        double[] nums = new double[5000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double)(((i % 2) == 0) ? i : -1);
        }
        Sum task=  new Sum(  nums  , 0 , nums.length  ) ;
        ForkJoinPool forkJoinPool  = new ForkJoinPool( ) ;
        double summation =  forkJoinPool.invoke( task);
        System.out.println("Summation " + summation);
        ReactorApp reactorApp = new ReactorApp();
        reactorApp.execThread();
        reactorApp.threadLocalDemo();
    }


    public void threadLocalDemo() {
        ThreadLocal<Counter>  threadLocal = new ThreadLocal<>();

        Thread thread1 =  new Thread( ()->{
            Counter counter = new Counter();
            counter.setCount(10);
            threadLocal.set( counter);
            System.out.println( " Thread 1  : Counter value :" +  threadLocal.get().getCount());
        });

        Thread thread2 =  new Thread( ()->{
            Counter counter = new Counter();
            counter.setCount(15);
            threadLocal.set( counter);

            System.out.println( " Thread 2  : Counter value :" +  threadLocal.get().getCount());
        });
        thread1.setName( "Emirates");
        thread2.setName(" Etihad");
        thread1.start();
        thread2.start();

        System.out.println("Main Thread: " + threadLocal.get().getCount()); // Will be null
    }

    public void  execThread () {
        ExecutorService executorService = Executors.newFixedThreadPool(  3);
      for ( int i = 0;  i<=5 ; i ++){
           int taskId  =  i ;
           executorService.execute( () ->{
                System.out.println( " Task " + taskId +  "  Executed by " + Thread.currentThread().getName());
           });
      }
       executorService.shutdown();
      System.out.println( " executor servcivce Running Status : " + executorService.isShutdown()  + " : Thread name: "  +  Thread.currentThread().getName());
    }
}
