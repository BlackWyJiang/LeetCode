package q1;

import static org.junit.Assert.*;

public class SolutionTest {

    @org.junit.Test
    public void twoSum() {
        Solution solution = new Solution();
        int[] nums = {7, 2, 11, 15};
        int[] ret = solution.twoSum(nums, 9);
        assertArrayEquals(ret,new int []{0,1});

    }
}