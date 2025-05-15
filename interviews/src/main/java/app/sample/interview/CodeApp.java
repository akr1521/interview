package app.sample.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;


record Profile (String name, String salary ) { }


class  ProfileExecutor{

     public void perFormAction() {
         Profile profile = new Profile( "Akasjh", " bacekd");
         profile.name();
         profile.salary() ;
        Thread  vThread = Thread.startVirtualThread(new Runnable() {
             @Override
             public void run () {
                 System.out.println( " NAme of Thread :  "  +  Thread.currentThread().getName());
             }
         });
         if ( vThread.isAlive()){
             vThread.interrupt();
         }
         System.out.println( "ClassLoader NAme : :  "  +  vThread.getContextClassLoader().getParent().getName());

     }

}


class TreeNode{
     int val ;
     TreeNode left;
     TreeNode right ;

     public TreeNode(){

     }
     public TreeNode(int val){
         this.val = val;
     }

     public TreeNode( int val, TreeNode left, TreeNode right){
         this.val = val;
         this.left = left;
         this.right  = right;
     }

    public int getVal () {
        return val;
    }

    public void setVal (int val) {
        this.val = val;
    }

    public TreeNode getLeft () {
        return left;
    }

    public void setLeft (TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight () {
        return right;
    }

    public void setRight (TreeNode right) {
        this.right = right;
    }
}
class Counter{
    private int  count = 0;

    public int getCount () {
        return count;
    }

    public void setCount (int count) {
        this.count = count;
    }
}


class ArrayProcessorAction extends RecursiveAction{
    private static final int threshold = 1000;
    private final int[] data;
    private final int start;
    private final int end;
     ArrayProcessorAction (int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end =  end;
    }

    @Override
    protected void compute () {
         int length =  end - start;
         if ( length <= threshold){
              for ( int i = start ; i < end; i++){
                    data[i] =  data[i] *2;
              }
         }
         else{
             int middle =  start +  length/2;
             ArrayProcessorAction leftTask = new ArrayProcessorAction( data,start,middle);
             System.out.println(  "Left Task :" +  " Start : " + leftTask.start  +
                     "  middle Task :" +  leftTask.end + "  Data :" + leftTask.data);
             ArrayProcessorAction rightTask = new ArrayProcessorAction( data, middle , end);
             System.out.println( "Right Task :" + " Start :" +  rightTask.start +  " end :"  +   rightTask.end
             + "  Data :" +  rightTask.data[start]  +  "  : end :" +  rightTask.data[end-1]);
             invokeAll(leftTask, rightTask);
         }
    }
}


public class CodeApp {

     public void streamDemo() {

         List<List<Integer>> listOfLists = Arrays.asList(
                 Arrays.asList(1, 2, 3),
                 Arrays.asList(4, 5),
                 Arrays.asList(6, 7, 8, 9)
         );
          List<Integer> sl =listOfLists.stream().flatMap(s ->s.stream() ).collect(Collectors.toList());
          sl.forEach(System.out::println);
     }

    public int removeStones(int[][] stones , int row, int column) {
        int[][]   stone = {{ 0,0} , {0,1}, {1,0}, {1,2} ,{2,1} , {2,2}};

        for ( int  i = 0 ; i <   stone[i].length ; i ++){
            for (  int  j= 0  ; j < stone.length ; j++   ) {
                     System.out.println(  "Stones : "  + i   +  "   J :" + j);
            }
        }
        return -1;
    }


    public int lastStoneWeight( int[] stones){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(  (a,b)->
        a.compareTo(b));
        for ( int stone :  stones){
            maxHeap.add( stone);
        }
        while ( maxHeap.size() >1 ){
        int stone1=  maxHeap.poll();
        int stone2=  maxHeap.poll();
        if(  stone1!=stone2) {
            maxHeap.add(stone1 - stone2);
        }
        }
        return maxHeap.isEmpty() ?  0 : maxHeap.poll();
    }





    public List<Integer> preOrder ( TreeNode  node) {
            if ( node  == null ) return  new ArrayList<>( ) ;

            List<Integer> ans  = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push( node);
            while ( !stack.isEmpty()){
                node =   stack.poll();
                ans.add( node.val);
                if ( node.right != null){
                    stack.push( node.right);
                }
                if ( node.left != null){
                    stack.push( node.left);
                }
            }

        return ans ;
    }
    public static void main (String args[]){
         CodeApp codeAppe = new CodeApp();
         codeAppe.streamDemo();
         int steps = codeAppe.climbStairs( 5);
         System.out.println( "  Steps : " + steps);
          codeAppe.removeStones(   null , 3, 3);
          codeAppe.groupAnagrams( new String[] { "eat","tea","tan","ate","nat","bat"});
          int lastWeight = codeAppe.lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1 });

          System.out.println( " Last Weight:  " + lastWeight);

          int size = 100000;
          int[] numbers  = new int[size];
          Random random = new Random();
          for( int i=  0 ; i< size ; i++){
                 numbers[i] = random.nextInt(100);
          }
          long startTtime =  System.nanoTime();
        ForkJoinPool  forkJoinPool  = new ForkJoinPool();
        ArrayProcessorAction arrayProcessorAction  = new ArrayProcessorAction( numbers, 0 ,size);
        forkJoinPool.invoke( arrayProcessorAction);
        System.out.println( " Steal Count: " +forkJoinPool.getStealCount());
        ProfileExecutor profileExecutor  =  new ProfileExecutor();
        profileExecutor.perFormAction();
    }

public int search ( int[] nums, int target){
        int l = 0 ;
        int r = nums.length  -1 ;
        while  ( l <= r){
            final int m = (l +r )/2 ;
            if( nums[m] == target)  return m ;
            if ( nums[l] <   nums[m]  ) {
                if (nums[l] < nums[m] && nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            else{
                if (nums[m] < target){
                    l =  m +1;
                }else{
                      r=  m -1 ;
                }

            }

        }
        return -1 ;
}
//Leetcode 155

    class MinStack{

        int  elements[] ;
        int curreentIndex= 0 ;
        int top =    elements.length -1 ;
        public MinStack(){
            elements = new int[ 10 ];
        }

        public void  push (int val){
             elements[ curreentIndex++ ] =  val;
        }
    }


//Leetcode 107
public List<List<Integer>> levelOrderBottom(TreeNode root) {

        return null;
}

public void  sortMatrix( int[][] matrix) {


}

    public String gcdOfStrings(String str1, String str2) {
        String remaining = "";
        for (  int  index =  0;  index < str1.length(); index ++ ){
               Boolean  res = str1.contentEquals(str2);
                if (!res){
                         str1.indexOf(index );
                }
        }

        return null;
    }

// Leetcode 49
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String,List<String>>   map = new HashMap<>();
        for (  String data :  strs) {
            System.out.println( " Sorted value: " + data);
            char[] toBeSortedData = data.toCharArray();
         Arrays.sort( toBeSortedData);
         String sortedData =  new String( toBeSortedData);
         if (!map.containsKey(sortedData)){
                List<String>  list=   new ArrayList<>();
                list.add(data);
              map.put( sortedData, list);
         }
         else{
            List<String>  anagram =  map.get(sortedData);
            anagram.add(data);
            map.put( sortedData,anagram);
         }
        }
        map.values().stream().forEach(System.out::println);

        return  null;
}


//Leetcode 2244
public int minimumRounds(int[] tasks) {
            return  -1;
}


    public int  climbStairs( int num ){
        if ( num  <=1 ) {
        return 1 ;
        }
        int[] dp  = new int[num  + 1];
        dp[0] = 0;
        dp[1] = 1;
        for ( int i = 2 ; i <= num ; i++ ){
            dp[i] = dp[ i-1] + dp [i -2];
        }
        return  dp[num];
    }

    public int[] intersection(int[] nums1, int[] nums2) {


        return null ;
    }

}
