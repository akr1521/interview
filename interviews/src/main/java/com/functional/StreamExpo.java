package com.functional;

import java.util.*;
import java.util.stream.Stream;

public class StreamExpo {


    public static void main (String args[]){


    }


    public void StreamMethodsTakeWhile(){

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 3, 2, 1);

        // Take elements while they are less than 5
        Stream<Integer> lessThanFiveStream = numbers.stream().takeWhile(n -> n < 5);
        lessThanFiveStream.forEach(System.out::println); // Output: 1 2 3 4
    }
}
