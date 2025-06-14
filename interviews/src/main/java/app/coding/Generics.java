package app.coding;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

// create a Generic Iter tor
interface  BaseIterator<T>{
           boolean hasPrevious();
           boolean hasNext();
           T next();
}

class DataIterator<T> implements  BaseIterator<T>{
    int currentIndex= 0;
    int previousIndex =0;
    T data[];
    public DataIterator ( T data[]){
             this.data = data;
    }

    @Override
    public boolean hasPrevious () {
        if (previousIndex == 0){
            return false;
        }
        return true;
    }

    @Override
    public boolean hasNext () {
        if (data.length-1 == currentIndex){
                 return false;
        }
        return true;
    }

    @Override
    public T next () {
        return  data[currentIndex];
    }
}




public class Generics {

    // Utility  method to create a generic method that converts tandnArray to List
    public static  <T> List<T>  toList (T arr[]){
            List<T> list = new ArrayList<>();
        for ( T   element : arr){
                 list.add(element);
             }
        return list;
    }

    public static void main (String args[]){
        Generics generics = new Generics();
        Generics.toList( new Integer[]{ 10 ,20 , 30 , 40 , 50, 60, 70}).stream().forEach( System.out ::println);

    }


}



interface Encrypt{

    void Encrypt() ;
}

class RSAEncryption implements  Encrypt{

    @Override
    public void Encrypt () {

    }
}

class AesEncryption implements Encrypt{
        String algo ="";

    @Override
    public void Encrypt () {
        try {
            Cipher cipher = Cipher.getInstance(algo);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }
}

class  Encryption<T extends Encrypt>{



}


interface  DataProcessor<T extends Data>{
        void processData ( T data);
}

class UserDataProcessor implements  DataProcessor<UserData>{

    @Override
    public void processData (UserData data) {

        System.out.println( " USer Data : " +   data.getUsername());
    }
}


class ProductDataProcessor implements DataProcessor<ProductData> {
    @Override
    public void processData (ProductData data) {
        System.out.println( " Product  Data : " +   data.getProductName());
    }
}