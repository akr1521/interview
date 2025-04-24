package com.sample.interview.samples;

public class CacheEntry<K,V>{
    private K key;
    private V value;
    private  int frequency;

    public CacheEntry (K key, V value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }

    public K getKey () {
        return key;
    }

    public void setKey (K key) {
        this.key = key;
    }

    public V getValue () {
        return value;
    }

    public void setValue (V value) {
        this.value = value;
    }

    public int getFrequency () {
        return frequency;
    }

    public int incrementFrequency (){
     return   this.frequency ++;
    }
}
