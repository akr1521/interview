package app.sample.interview.samples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Double> {
    final int seqThreshold = 500 ;
    double data[];
    int start , end ;

    public Sum (double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute () {
        double sum = 0 ;
        if ( (end -start) < seqThreshold ){
            for  ( int i = start ; i < end  ; i++){
                sum += data[i];
            }
        }
        else{
            int middle = (start  + end) /2 ;
            Sum  sum1= new Sum(   data,start,  middle);
            Sum sum2 = new Sum ( data, middle , end);
            System.out.println(  " FOrk 1 ");
            ForkJoinTask subtask =sum1.fork();
            try {
                System.out.println(  "after  fork of Taask 1:  Value  :  " +  (double) subtask.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" fork2 ");
            ForkJoinTask subtask2=   sum2.fork() ;

            try {
                System.out.println(  "after  fork of Taask 2:  Value  :  " +  (double) subtask2.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            sum =  sum  + sum1.join() + sum2.join();

        }
        return sum;
    }
}


