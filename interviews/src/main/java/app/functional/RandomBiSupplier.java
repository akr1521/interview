package app.functional;
import java.util.Random;
import java.util.function.Supplier;
public class RandomBiSupplier {


    public static void main(String[] args) {
        RandomBiSupplier randomBiSupplier =  new RandomBiSupplier();
        randomBiSupplier.validateAge();


    }

    public  void  validateAge(){
        Boolean eligible = false;
        Supplier<Pair<String,Integer>> nameSupplier =  ( ) -> new Pair<>( "Alexander",30);
        if (  nameSupplier.get().getSecond() > 20){
            eligible= true;
        }
    }


    private static class Pair<T,U>{
        T first ;
        U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }
}
