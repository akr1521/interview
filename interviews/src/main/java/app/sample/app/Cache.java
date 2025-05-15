package app.sample.app;

import java.util.Optional;

public interface Cache<K,V>{
         Optional<V> get  (K key);
         boolean isEmpty();
         void clear();

         Boolean set( K key,  V value);
}
