package com.coding;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.*;

public class AlgoFirst {

    //Leetcode 70

    public int climbStairs(int n) {
        int first = 0 , second =1;


        return -1;
    }


    //find anagrams
    public List<Integer> findAnagrams( String s,String p   ){

        char[]  pattern  = p.toCharArray();


        return null ;
    }



// group anagrams

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>>  store=  new HashMap<>();
        List<List<String>> answer = new ArrayList<> ();
        for( final String s: strs ) {
            String    dummy  = s;
            char[] arr =  dummy.toCharArray();

            Arrays.sort(  arr);
            dummy = new String (arr);

            System.out.println(  " dummy after Sort :"   +  dummy);
            if  (store.containsKey(dummy)){
                List<String>  l = store.get(dummy );
                l.add(s);
                store.put( dummy, l);
            }else{
                List<String> list=  new ArrayList<>();
                list.add(s);
                store.put(dummy, list );
            }

        }
        for ( List<String>  ls : store.values()){
            answer.add( ls);
        }

        return  answer;
    }



    // Leetcode 128
    public int longestConsecutive(int[] nums) {
        int count = 0 ;
        Set<Integer> set = Arrays.stream( nums).boxed().collect(Collectors.toSet());

        for (int num: set){
            if (  set.contains( num -1)){

            }
        }
        return -1;
    }


    //solution of  #268

    public int missingNumber(int[] nums) {
        int n =  nums.length ;
        int expectedsum =  n* ( n+1) /2;
        int partialSum= 0;
        for (int a :nums){
            partialSum =  partialSum + a;
        }
        return expectedsum - partialSum;
    }


    // Solution of #1749
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum= 0;
        int maxAbsoluteSum= 0;

        for ( int i= 0 ; i <  nums.length ; i++){
            maxSum  = Math.max(nums[i],(nums[i]+ maxSum));
            minSum =  Math.min( nums[i], (nums[i]+ minSum));
            maxAbsoluteSum=  Math.max( maxAbsoluteSum, Math.max(maxSum,-minSum));
        }
        return maxAbsoluteSum;
    }


    // Solution of #53
    public int maxSubArray(int[] nums) {
        int[] store = new int[nums.length ];

        store[0] = nums[0];
        for (int i = 1 ; i< nums.length ; i++){
                store[i] = Math.max(  nums[i], nums[i]+ store[i-1]);
        }
        return  Arrays.stream(  store).max().getAsInt();
    }


    //#49
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>  store = new LinkedHashMap<>();
        for( final String s: strs ) {
                Arrays.sort( s.toCharArray());
            if (  store.containsKey(  s)){
               //TBD

            }
            else {

            }

        }
        return  null;

    }



    //solution of #1

    public int[] twoSum(int[] nums, int target) {
        int left = 0 ;
        int right =nums.length -1;
        while( left<right){
            if ( nums[left]+ nums[right] == target){
                return new int[]{left,right};
            }

            if ( target > nums[left]  ){
                if ( target - (nums[left]) >  (nums[right]- target)){
                    left++;
                }
                else{
                    right--;
                }
            }

        }
        return new int[]{-1,-1};
    }


    // Solution of #162
    public int findPeakElement(int[] nums) {
        int peak = Integer.MIN_VALUE;
        int index=0;
        for (  int i =  0 ; i <   nums.length; i ++ ){
            if  ( nums[ i]>peak){
                peak = nums[i] ;
                index =i;

            }
        }
        return index;
    }

 //    #852

    public int peakIndexInMountainArray(int[] arr) {
        int peakIndex = 0 ;
        for (  int i = 1 ; i <  arr.length ; i++ ){
            if (arr[ i -1]<arr[i]) {
                continue;
            }
            else{
                peakIndex = i-1 ;
                return peakIndex;
            }
        }
        return  peakIndex;
    }

}
