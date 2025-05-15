package app.sample.interview.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class StreamExecutor {

    public static void main(String[] args) {

        getEuropeCoutries().stream().filter(element -> element.startsWith("P")).forEach( System.out::println);
        UnaryOperator<String>   smallCaseOperator =   String::toLowerCase;

        StreamExecutor.streamSum();
        StreamExecutor obj = new StreamExecutor() ;
        obj.flatten();
        obj.reduce();

    }

    public static  void streamSum(){
        List<String>  result=   List.of("Warsaw","Krakow","Dubai","Cork","Dublin");
        result = result.stream().map(Function.identity()).collect(Collectors.toList());
        System.out.println( " Result  " + result);
    }

    public void normalMap() {
        // making the array list object
        ArrayList<String> fruit = new ArrayList<>();
        fruit.add("Apple");
        fruit.add("mango");
        fruit.add("pineapple");
        fruit.add("kiwi");
        System.out.println("List of fruit-" + fruit);

        fruit.stream().map( e -> e.charAt(0)).collect(Collectors.toList()).forEach(  a ->   System.out.println( a));

    }

    public void flatten () {
        ArrayList<String> fruit = new ArrayList<>();
        fruit.add("Apple");
        fruit.add("mango");
        fruit.add("pineapple");
        fruit.add("kiwi");
        System.out.println("List of fruit-" + fruit);

        List<List<Integer> > number = new ArrayList<>();
        number.add( Arrays.asList( 1 ,2  ));
        number.add( Arrays.asList( 3,4 ));
        number.add( Arrays.asList( 5,12  ));
        number.add( Arrays.asList( 14 ,45  ));

        // using flatmap() to flatten this list
        List<Integer> flatList =    number.stream().flatMap(  list -> list.stream() )
                .collect(Collectors.toList());
        System.out.println( "flat lisT  " +   flatList);

    }

    public void reduce (){
        List<Integer> list = List.of( 1, 2, 3, 4, 5, 6, 7);
        int product =
                list.stream().reduce( 1 , (a,b) -> a*b);
        System.out.println(  " Product : "  +  product);
    }


    public static List<String> getEuropeCoutries() {
        List<String> europeCountries = new ArrayList<>();
        europeCountries.add("Albania");
        europeCountries.add("Andorra");
        europeCountries.add("Armenia");
        europeCountries.add("Austria");
        europeCountries.add("Azerbaijan");
        europeCountries.add("Belarus");
        europeCountries.add("Belgium");
        europeCountries.add("Bosnia and Herzegovina");
        europeCountries.add("Bulgaria");
        europeCountries.add("Croatia");
        europeCountries.add("Cyprus");
        europeCountries.add("Czech Republic");
        europeCountries.add("Denmark");
        europeCountries.add("Estonia");
        europeCountries.add("Finland");
        europeCountries.add("France");
        europeCountries.add("Georgia");
        europeCountries.add("Germany");
        europeCountries.add("Greece");
        europeCountries.add("Hungary");
        europeCountries.add("Iceland");
        europeCountries.add("Ireland");
        europeCountries.add("Italy");
        europeCountries.add("Kazakhstan");
        europeCountries.add("Kosovo");
        europeCountries.add("Latvia");
        europeCountries.add("Liechtenstein");
        europeCountries.add("Lithuania");
        europeCountries.add("Luxembourg");
        europeCountries.add("Malta");
        europeCountries.add("Moldova");
        europeCountries.add("Monaco");
        europeCountries.add("Montenegro");
        europeCountries.add("Netherlands");
        europeCountries.add("North Macedonia");
        europeCountries.add("Norway");
        europeCountries.add("Poland");
        europeCountries.add("Portugal");
        europeCountries.add("Romania");
        europeCountries.add("Russia");
        europeCountries.add("San Marino");
        europeCountries.add("Serbia");
        europeCountries.add("Slovakia");
        europeCountries.add("Slovenia");
        europeCountries.add("Spain");
        europeCountries.add("Sweden");
        europeCountries.add("Switzerland");
        europeCountries.add("Turkey");
        europeCountries.add("Ukraine");
        europeCountries.add("United Kingdom");
        europeCountries.add("Vatican City");
        return europeCountries;
    }



    public List<String> getVisaFreeCountries() {
        List<String> visaFreeCountriesForCitizen = Arrays.asList(
             "Bhutan" ,"Nepal", "thailand"
        );
        return visaFreeCountriesForCitizen;
    }

}
