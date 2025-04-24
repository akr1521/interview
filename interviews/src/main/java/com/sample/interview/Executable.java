package com.sample.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import io.netty.buffer.ByteBufAllocator;

public class Executable {



    boolean canJump (int arr[]){
        int finalP =  arr.length -1;
        for ( int index =  arr.length-2  ;   index >= 0 ; index -- ){

        }

        return  finalP == 0;
    }

    //Leetcode 110
    public  boolean isBalanced( Node node){
        int lHeight = 0, rHeight= 0 ;
        Node leftTree = node.left ;
        Node rightTree = node.right ;
        while  ( leftTree != null ){
                lHeight ++  ;
                leftTree  = leftTree.left;
        }
        while(  rightTree != null){
                rHeight  ++  ;
                rightTree =  rightTree.right;
        }
        return   Math.abs( lHeight- rHeight) ==1;
    }

    public int[]  findDissapearingNumbers( int  nums[ ]){
        for  (  int counter =  0; counter <  nums.length  ; counter++ ){

        }

        return null;
    }


    //leetcode 1254

    public  boolean isPalindrome( String s) {
        StringBuilder  result = new StringBuilder();
        if ( s.length() == 0) return true;
        for (  int  i= 0 ; i< s.length() ; i++ ){
            if ( Character.isLetterOrDigit( s.charAt( i))){
                 result.append( s.charAt( i));
            }
        }

        for  (  int  i =  0 , j= result.length() -1  ;  i < result.length()  &&  j >= 0 ; i++ , j--  ){
                if ( result.charAt( i) != result.charAt( j)) {
                        return false;
                }
        }
        return true;
    }


    //Leetcode  1100
    public int numKLenSubstrNoRepeats(String s, int k) {
        char[] arr =  new char[s.length()];
        for  ( int  i = 0; i<  s.length() ; i++ ){

        }

        return  -1 ;
    }

    static int height ( Node root){
        if ( root == null ) return -1;
        int lHeight =  height (root.left);
        int rHeight=  height ( root.right );
        return -1;
    }
    //Leetcodee 242
    public boolean isAnagram(String s, String t) {
        int []   count  = new int[26] ;
        if  (s.length() != t.length() ) { return  false ;}

        for  (int i  =  0  ;i  < s.length()  ; i++ ) {
              count[ s.charAt(i) -'a'] ++;
        }
        for ( int i  =  0  ;i  < s.length()  ; i++  ){
                if (count[i] == 1){
                    System.out.println(   " Elemennt at : " + i  + " : " +    count[i] ) ;
                        return false;
                }
        }

        return true;
    }


    // Leetcode 438
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>  result =  new ArrayList<>( );
        if ( s == null  || p == null || s.length() < p.length()) {
                return  result;
        }
        int[] sCharCounts = new int[26];
        int[] pCharCounts = new int[26];
        for ( int i= 0 ; i < p.length() ; i++ ){

            sCharCounts[ s.charAt(i) -  'a']++ ;
            System.out.println(  "S char count : at " + i +  " :" +  sCharCounts[ s.charAt(i) -  'a']);
            pCharCounts[ p.charAt(i) - 'a']++;
            System.out.println(  "P char count : at " + i +  " :" +  pCharCounts[ s.charAt(i) -  'a']);
        }
       int left = 0;
        for (int right = p.length(); right < s.length(); right++) {
            // Check if current window is an anagram
            if (Arrays.equals(sCharCounts, pCharCounts)) {
                result.add(left);
            }

            // Slide the window: remove leftmost character and add the new rightmost character
            sCharCounts[s.charAt(left) - 'a']--;
            sCharCounts[s.charAt(right) - 'a']++;
            left++;
        }

        // Check the last possible window
        if (Arrays.equals(sCharCounts, pCharCounts)) {
            result.add(left);
        }

        return result;
    }
    public  static void main(String args[]){

        Executable executable = new Executable();
        Node root = executable.createTree();
        executable.getLevel( root.left , 5, 1);
        System.out.println(   "Is PAlindrome :  "  +   executable.isPalindrome( "Priya Paruls") ) ;
        Boolean isBalanced= executable.isBalanced( executable.createTree ());
        System.out.println(  "  Is balancne d: "  +  isBalanced) ;

        MutexCounte  mutexCounte  = new MutexCounte(  10);
        System.out.println( "Total Number of Seats Before Thread  Start0 :"  + mutexCounte.getTotalSeats());
        Thread  first =  new Thread(  ()-> {
                 mutexCounte.seatAllocation(3);
            System.out.println( "Total Number of Seats After Thread first Start0 :"  + mutexCounte.getTotalSeats());

        } );
        first.start();

        Thread second  = new Thread(  ()  -> {
             mutexCounte.seatAllocation( 5);
            System.out.println( "Total Number of Seats AFter Thread second Start :"  + mutexCounte.getTotalSeats());

        });
        second.start();
        executable.findAnagrams("cbaebabacd","abc").stream().forEach(  System.out::println);
        System.out.println ( " Is anagram :  "  +executable.isAnagram( "anagram", "nagaram"));
        executable.allFuncApproach();

    }
    public int getLevel(Node  root, int target, int level){
        if ( root == null){
            return -1;
        }
        if ( root.data == target){
            return level;
        }
        int leftLevel = getLevel( root.left  ,  target , level +1);
        System.out.println( "Level Out :" +  leftLevel);
        if ( leftLevel !=-1) return  leftLevel;
        return getLevel( root.right, target ,level +1 );
    }

    public Node createTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    //    root.left.left.left = new Node( 8);
        //   root.left.left.right = new Node(9);
        return  root ;
    }

    public  void  allFuncApproach() {
        MutexCounte mutexCounte ;
        Consumer<List<MutexCounte>>  list =   l ->{
             for (int i =0 ; i< l.size() ; i++ ){
                     l.set( i , l.get(i));
             }
        };
        Consumer<MutexCounte>  consumer = ( e) -> {
              e.seatAllocation(50);
              System.out.println(" Total SeatS: "   + e.getTotalSeats());
        };
        mutexCounte= new MutexCounte(100);
        consumer.accept( mutexCounte);
    }
}


class  MutexCounte{
    private int  totSeats;
    private ReentrantLock  lock  =  new ReentrantLock();

    public MutexCounte(  int totSeats)  {
                this.totSeats =  totSeats   ;
    }

    public void  seatAllocation ( int  seats){
         lock.lock();
        {
               this.totSeats--;
        }
        if (lock.isLocked() ){
            System.out.println( "  Is currently locked");
        }
        lock.unlock();
        System.out.println( "  Is currently locked ?  Status  :"   +  lock.isLocked());

    }
    public  int getTotalSeats() {
            return  this.totSeats;
    }
}

