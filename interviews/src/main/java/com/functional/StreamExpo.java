package com.functional;

import java.util.*;
import java.util.stream.Stream;

public class StreamExpo {


    public static void main (String args[]){
        StreamExpo streamExpo = new StreamExpo();
        streamExpo.usingIterateinStream();

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


}
