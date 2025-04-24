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

}
