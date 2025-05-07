import com.coding.AlgoFirst;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AlgoTest {
    AlgoFirst algoFirst = new AlgoFirst();


    @Test
    public void  testMaxAbsoluteSum(){
         int maxAbsoluteSum =algoFirst.maxAbsoluteSum(new int[]{ 1,-3,2,3,-4});
        Assertions.assertEquals( 5, maxAbsoluteSum );
    }

    @Test
    public void testMissingNumber(){
        int missingNumber = algoFirst.missingNumber(new int[] {3,0,1});
        Assertions.assertEquals(2, missingNumber);
    }

    @Test
    public void testTwoSum(){
        int[] actualSumIndex = algoFirst.twoSum( new int[] {2,7,11,15} ,9);
        int[] expected  = new int[]{0,1};
         Assertions.assertEquals( expected,actualSumIndex );
    }

    @Test
    public void testPeakElement(){
         int  peakElement1 =algoFirst.findPeakElement( new int [] {1,2,3,1});
          Assertions.assertEquals( 2,  peakElement1);
          int peakElement2 = algoFirst.findPeakElement(new int[]{1,2,1,3,5,6,4});
          Assertions.assertEquals(5,  peakElement2);
    }

    @Test
    public void testAnagram(){
        algoFirst.groupAnagrams2( new String[]{ "eat","tea","tan","ate","nat","bat" });;
    }

}
