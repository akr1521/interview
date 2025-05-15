package app.sample.interview.samples;

public class HackerRank {

    //leetcode: InOrder traversal

    //leetcode 1029

    public int twoCitySchedCost(int[][] costs) {


        return -1 ;
    }

    int fib(  int  n) {
        if (  n <=1 ) return  n;
        int dp[]  = new int[ 31] ;
        dp[n]  =  fib( n-2  )  + fib( n-1);
        return dp[n];
    }


    //decode ways

    public int numDecodings(String s) {
        if (s == null )  return  0  ;
        int len  = s.length() ;
        int dp[] =  new int[ len +1 ];


        return  -1;
    }

    //leetcode 2161

    public int[] pivotArray(int[] nums, int pivot) {
        int prevIndex = 0 ;
        int nextIndex = nums.length -1 ;

        for ( int counter = 0 ; counter < nums.length ; counter++) {
            if ( nums[counter] <  pivot)
            {
                prevIndex ++ ;
            }
            else if ( nums[counter] == pivot)
            {
                int swap =  nums[counter];

            }
        }
        return null;
    }

    //Leetcode 1749
    public int maxAbsoluteSum(int[] nums) {

        int maxSum =  0;

        return  -1;
    }



    public int binSearch ( int[] arr, int low,int   high, int key){
        while ( low < high) {
            int  mid = low +  ( (high - low /2 ));
            if ( arr[mid] <   key)  {
                low =  mid  +1  ;
            }else   {
                high =  mid  -1;
            }
        }

        return  -1;
    }
}
