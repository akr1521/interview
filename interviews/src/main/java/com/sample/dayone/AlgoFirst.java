package com.sample.dayone;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class AlgoFirst {



    // https://leetcode.com/problems/insert-interval/?envType=problem-list-v2&envId=oizxjoit

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = newInterval;
        for ( int[] interval: intervals){

            System.out.println( interval[0]);
        }


        return null;
    }

//https://leetcode.com/problems/coin-change/description/
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;


        return  -1 ;
    }


    //


    public static void main(String args[]){
         AlgoFirst algoFirst= new AlgoFirst();
         algoFirst.insert( new int[][] {{1,3},{6,9}},  new int[]{2,5});
    }

}
