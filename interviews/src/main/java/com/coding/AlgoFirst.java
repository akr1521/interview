package com.coding;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class AlgoFirst {

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

        return  0;
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


}
