package app.sample.interview;

public class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean  isEndOfWord = false;

    public TrieNode () {
        isEndOfWord = false;
        child = new TrieNode[26];
    }

    static void insert( TrieNode root, String key){
         TrieNode  curr= root ;
         for(char c:  key.toCharArray()){

         }
    }
}
