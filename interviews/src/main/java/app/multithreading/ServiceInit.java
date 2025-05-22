package app.multithreading;

import com.sun.jdi.event.ExceptionEvent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServiceInit  implements Runnable{
    private final String serviceName;
    private final CountDownLatch latch;


    public ServiceInit (String serviceName, CountDownLatch latch) {
        this.serviceName = serviceName;
        this.latch = latch;
    }

    @Override
    public void run () {
        System.out.println("Starting " + serviceName + "...");

        try {
            TimeUnit.SECONDS.sleep( (long) Math.random() *5);
            System.out.println(serviceName + " started successfully.");
            latch.countDown();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println( serviceName +  "  failed to start.");
            throw new RuntimeException(e);
        }
    }




    public static void main(String[] args) throws InterruptedException {
        int numberOfServices = 3;
        CountDownLatch startupLatch = new CountDownLatch(numberOfServices);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);

    }

}


class OrderProducerForArray implements Runnable{
    private final BlockingQueue<String> orderQueue;
    private final String producerId;
    private final Random random = new Random();
    public OrderProducerForArray(BlockingQueue<String> orderQueue, String producerId) {
        this.orderQueue = orderQueue;
        this.producerId = producerId;
    }


    @Override
    public void run () {

    }
}