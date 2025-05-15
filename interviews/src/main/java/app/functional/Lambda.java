package app.functional;
import  java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda {


    // Understanding  Predicate broadly
    public void  predicate_1(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer>   allEven =   ( number ) ->  number %2 ==0;
        numbers.stream().filter( allEven).collect(Collectors.toList()).forEach(System.out::println);
    }


    public  static <T> Boolean  verifyName(List<T> items,  Predicate<List<T>>  condition){
        return  condition.test(items);
    }

    // Predicate checks whether the Poland cities are availaabnle in the Colelctions
    public void  predicate_2(){
        List<String>  cities = new ArrayList<>();
        cities.add("Prague");
        cities.add("Linz");
        cities.add("Vilnius");
        cities.add("Florence");
        cities.add("Krakow");
        cities.add("Warsaw");

        Predicate<List<String>>   plCities =   city -> city.contains("Krakow") && city.contains("Warsaw");
        Boolean isPlCitiesAreThere = verifyName( cities,plCities);
        System.out.println( " Is Poland cities are there in the List :"  + isPlCitiesAreThere);
    }


    public static Boolean isValidEmail(String email ,Predicate<String> emailFormat){
            return emailFormat.test( email);
    }

    // Predicate via Lambda expression  for  Validating Input:
    public void  predicate_3(){
       Boolean isValidEmail =  isValidEmail( "Anastazia.morskiego@gmail.com", (letter) -> letter.length()>0 && letter.contains("@") && letter.contains("."));
       System.out.println( "Is Anastazia.morskiego@gmail.com a valid email : "   + isValidEmail);
    }

    //Predicate for Routing or Decision Making:
    public static void processItem(String item, Predicate<String> isImportant ,Runnable importantAction, Runnable regularAction ){
         if (isImportant.test(item)){
             importantAction.run();
         }
         else {
             regularAction.run();
         }
    }



    public void  predicate_4(){
        String task="Critical";
        String task2="Minor";
        Predicate<String> isCritical = t -> t.equalsIgnoreCase("Critical");
        Predicate<String> isMinor =  t -> t.equalsIgnoreCase("Minor");
        processItem( task  , isCritical, ()->{System.out.println("Critical Task Processing");}, ()-> {System.out.println("Regular Task Processing");});
        processItem(task2 , isMinor , () -> {} , ()->{});
    }

    //Predicate Combiner
    public boolean isEligibleForDiscount(List<Integer> id, Predicate<List<Integer>>  discountRule){
        return discountRule.test( id);
    }
    public void  predicate_5 () {
        Boolean iseligible  =isEligibleForDiscount( List.of( 1,2,3,4,5,6,7) ,  (id) -> id.containsAll( List.of( 1,2,3,4,5)));
        System.out.println( "It is Eligible for Discount :  "  +iseligible);
    }

    public static void main(String args[]){
        Lambda lambda = new Lambda();
        lambda.predicate_1();
        lambda.predicate_2();
        lambda.predicate_3();
        lambda.predicate_4();
        lambda.predicate_5();
    }

}
