package com.functional;

import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.function.Consumer;


public class FunctionalExpo {


/* All about Supplier

 */

    // Getting default value in conditions;
    public String  supplier_1(String name, Supplier<String> defaultNameSupplier){
            return Optional.ofNullable(name).orElseGet(defaultNameSupplier);
    }

    // Geenrating random value fro Suppliert
    public Supplier<Integer>  supplier_2 (){
        Supplier<Integer> getRandomNumber =  () -> new Random().nextInt(100);
        return getRandomNumber;
    }

    // Suplier for Laxy Initialization
    private static Supplier<ExpensiveObject> expensiveObjectSupplier = () -> {
        System.out.println("Creating ExpensiveObject...");
        return new ExpensiveObject();
    };

    private static ExpensiveObject getExpensiveObject() {
        return expensiveObjectSupplier.get();
    }

    // USing Stream with Supplier
    public  void supplier_WithStream(){
        Supplier<Integer>  randomDoubleSupplier = () ->  new Random().nextInt();
        Stream.generate(randomDoubleSupplier).limit(5).forEach( System.out::println);

        Supplier<? extends String> counterSupplier = new Supplier<String>() {
            int count = 0;
        @Override
        public String get() {
            return "Counter Value -" + ++count;
        }
    };
        Supplier<? extends String> counterSupplier1 =  () -> {   int count= 0; ++ count; return "Coutner value" + count; };
        Stream.generate(counterSupplier1).limit(5).forEach(System.out::println);
    }



    public static void main (String args[]){
        FunctionalExpo  functionalExpo = new FunctionalExpo();
        String supplier1=  functionalExpo.supplier_1( null, ()-> "Guest");
        System.out.println( "Supplier 1:  "  +  supplier1);

        System.out.println( " Get Random Number: "  +  functionalExpo.supplier_2().get());
        System.out.println( " Get Random Number:  "  +  functionalExpo.supplier_2().get());
        System.out.println( " Get Random Number:  "  +  functionalExpo.supplier_2().get());

        // Expensive object is not created yet
        System.out.println("First time accessing:");
        ExpensiveObject obj1 = getExpensiveObject(); // Creation happens here
        obj1.processing();

        System.out.println("Second time accessing:");
        ExpensiveObject obj2 = getExpensiveObject(); // New instance created each time
        obj2.processing();

        functionalExpo.supplier_WithStream();
        consumerOperations();

    }

    // calling all Cosnuemr based operations from here
    public static void  consumerOperations (){
        consumer_expo1();


    }


    public  static void consumer_expo1(){
        ScoreManager  scoreManager = new ScoreManager();
        Consumer<ScoreManager>  scoreManagerConsumer = ScoreManager::boundary;
        scoreManagerConsumer.accept(scoreManager);
        System.out.println( " Score :" +  scoreManager.score);
    }


}


class ExpensiveObject {
    public ExpensiveObject () {
        // Simulate expensive operation
        try {
            Thread.sleep(1000);
            System.out.println("Sleep time");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("ExpensiveObject created.");
    }

    public void processing() {
        System.out.println("ExpensiveObject ready Process....");
    }

}


class ScoreManager{
    int score;
    public   int  boundary()
    {
        score=  score+ 4;
        return score;
    }

    public int six( ){
        score = score + 6;
        return score;
    }

}

interface NotificationService {
    void sendNotification(String message);
}

class EmailService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}
