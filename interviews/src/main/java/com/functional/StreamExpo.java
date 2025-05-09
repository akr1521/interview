package com.functional;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExpo {


    public static void main (String args[]){
        StreamExpo streamExpo = new StreamExpo();
        streamExpo.usingIterateinStream();
        streamExpo.usingPeekOperations();
        streamExpo.usingStreamGenerate();
        streamExpo.usingGroupingBy();
        combineAdjacent(Arrays.asList("1", "2", "3", "4")).forEach(System.out::println);
    }


    public void StreamMethodsTakeWhile(){

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 3, 2, 1);

        // Take elements while they are less than 5
        Stream<Integer> lessThanFiveStream = numbers.stream().takeWhile(n -> n < 5);
        lessThanFiveStream.forEach(System.out::println); // Output: 1 2 3 4
    }

    public void  usingDropWhileInStream(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 3, 2, 1);

        // Drop elements while they are less than 5
        Stream<Integer> remainingStream = numbers.stream().dropWhile(n -> n < 5);
        remainingStream.forEach(System.out::println); // Output: 5 3 2 1

        List<String> words = List.of("apple", "banana", "apricot", "kiwi", "avocado");
        // Drop words while they start with 'a'
        Stream<String> afterAStream = words.stream().dropWhile(s -> s.startsWith("a"));
        afterAStream.forEach(System.out::println); // Output: kiwi avocado
    }


    public void usingIterateinStream(){
        Stream<Integer> powersOfTwo = Stream.iterate(1, n -> n < 100, n -> n * 2);
        powersOfTwo.forEach(System.out::println); // Output: 1 2 4 8 16 32 64

        // Generate Fibonacci sequence starting with 0, while the number is less than 50
        Stream<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, pair -> pair[0] < 50,
                        pair -> new int[]{pair[1], pair[0] + pair[1]})
                .map(pair -> pair[0]); // Extract the first element of the pair
        fibonacci.forEach(System.out::println); // Output: 0 1 1 2 3 5 8 13 21 34

    }

    public void usingPeekOperations() {
        Stream<String> nameStream = Stream.of("Alex", "Agnieszka", "Billy");
        Consumer<String> consumer =    name-> System.out.println(name);
        List<String>  formattedList =nameStream.filter(   name-> name.startsWith("A")).peek( consumer).collect(Collectors.toList());

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> peekedList = new ArrayList<>();
        List<Integer> result = integers.stream().filter( element-> element%2 == 0 ).map (  element -> element*2 )
                .peek(peekedList::add)
                .collect(Collectors.toList());
        peekedList.stream().forEach( a  -> System.out.println(a));

    }


    // Strema Generate using supplier
    public void usingStreamGenerate(){
        Random random = new Random();
        Supplier<Integer> randomIntSupplier = random::nextInt;
        Stream<Integer> randomIntStream = Stream.generate(randomIntSupplier);
        //start the Stream
        randomIntStream.limit(20).map( number-> Math.abs(number)).forEach(  number ->  System.out.println( number));
    }


    //  Grouping cities on the basis of an Input
    public void usingGroupingBy(){
        List<Person> people = Arrays.asList(
                new Person("Alice", "New York"),
                new Person("Bob", "London"),
                new Person("Charlie", "New York"),
                new Person("David", "Paris"),
                new Person("Eve", "London")
        );
        Function<Person, String> cityfiltered =   ( person) -> person.getCity();
        Map<String, List<Person>> cityAndName = people.stream().collect(Collectors.groupingBy(  cityfiltered));
        System.out.println( "City:"  + cityAndName );

        Map
                <String,
                        Long>  p =    people.stream().collect(Collectors.groupingBy(  cityfiltered ,Collectors.counting()));
        System.out.println( p);
    }

    public  void   usingStreamJoining(){
        // Creating a character list
        List<Character> ch=Arrays.asList(
        'G','e','e','k','s','f','o','r','G',
        'e','e','k','s');


        }

        //Conbine adjacent
        public static List<String> combineAdjacent(List<String> list) {
            if (list.size() < 2) {
                return new ArrayList<>(); // Cannot form pairs
            }

            return java.util.stream.IntStream.range(0, list.size() - 1)
                    .mapToObj(i -> list.get(i) + list.get(i + 1))
                    .collect(Collectors.toList());
        }



}


class Person {
    String name;
    String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', city='" + city + "'}";
    }
}