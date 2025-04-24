package com.sample.interview;

public class ThreadApp {

    public static void main(String args[]){
    Score score = new Score();
    ThreadApp threadApp= new ThreadApp();
    threadApp.scorePush( score);

    }




    public void scorePush( Score score){
        Thread  first  = new Thread(
                () -> {
                    for ( int i=  0 ; i<  10 ;i++ ) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        int updatedScore =     score.incrementCounter();
                        System.out.println(  "Score incremented by :" +  Thread.currentThread().getName() + " " +
                                "updoated  score:  "+  updatedScore );
                    }
                }
        );
        Thread  second  = new Thread(
                () -> {
                    for ( int i=  0 ; i<  10 ;i++ ) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                         int updatedScore = score.incrementCounter();
                        System.out.println(  "Score incremented by :" +  Thread.currentThread().getName() + " " +
                                "updoated  score:  "+  updatedScore );
                    }
                }
        );
        first.setName("First");  second.setName("second");
        first.start();
        second.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}

class Score{

    private static final Object lock = new Object();
    private static int score = 0;

    public   int incrementCounter() {
      // the lock
            return ++score;

    }

}


class SharedList<T>{
    private final int defaultCapacity = 10;
    private transient Object[]  data = {};
    public SharedList(int capacity, int loadFactor){
        if ( capacity >  0){
                 data = new Object[ capacity];
        }

    }

    void add (  T   element){

    }


}