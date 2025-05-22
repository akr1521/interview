package app.multithreading;

public class StarvingThread {


    public static void main (String[] args) {
        Runnable lowPriorityTask = () -> {
            while (true) {
                System.out.println("Low priority thread running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        };

        Runnable highPriorityTask = () -> {
            while (true) {
                System.out.println("High priority thread running...");
            }
        };

        Thread low = new Thread(lowPriorityTask);
        Thread high = new Thread(highPriorityTask);

        low.setPriority(Thread.MIN_PRIORITY);   // Priority 1
        high.setPriority(Thread.MAX_PRIORITY);  // Priority 10

        low.start();
        high.start();



    }


}