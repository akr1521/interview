package com.coding;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Generics {



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