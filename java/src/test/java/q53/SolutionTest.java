package q53;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void maxSubArray() {

        assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(23, solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        assertEquals(1, solution.maxSubArray(new int[]{1}));

    }
}