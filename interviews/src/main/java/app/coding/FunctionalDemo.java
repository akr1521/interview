package app.coding;

import java.util.stream.Stream;
import java.util.Map;
import java.util.*;
public class FunctionalDemo {


    public static void main(String  args[]){
        FunctionalDemo functionalDemo = new FunctionalDemo();
        functionalDemo.hashCodeGen();
    }

    public void hashCodeGen(){
        // Create a List of Maps
        List<Map<String, Integer>> listOfMaps = new ArrayList<>();

        // Create the first map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);

        // Create the second map
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("c", 3);
        map2.put("d", 4);

        // Add the maps to the list
        listOfMaps.add(map1);
        listOfMaps.add(map2);

        // Get the hashCode of the list of maps
        int hashCode = listOfMaps.hashCode();
        System.out.println("HashCode of listOfMaps: " + hashCode);

        //Demonstrate that changing the order of the map changes the hashcode.
        List<Map<String, Integer>> listOfMaps2 = new ArrayList<>();
        listOfMaps2.add(map2);
        listOfMaps2.add(map1);
        int hashCode2 = listOfMaps2.hashCode();
        System.out.println("HashCode of listOfMaps2: " + hashCode2); //This will be different from hashCode

        //Demonstrate that changing the contents of a map changes the hashcode
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("a", 1);
        map3.put("b", 2);
        map3.put("c", 5); // Changed value here
        List<Map<String, Integer>> listOfMaps3 = new ArrayList<>();
        listOfMaps3.add(map3);
        listOfMaps3.add(map2);
        int hashCode3 = listOfMaps3.hashCode();
        System.out.println("HashCode of listOfMaps3: " + hashCode3); //This will be different from hashCode


    }

    public void biFunctionalDemo() {
        Stream<String>  stream = Stream.of(  "Hello " , " World");
         stream.reduce("",  (a ,b) -> b+"-" +a);
    }
}
