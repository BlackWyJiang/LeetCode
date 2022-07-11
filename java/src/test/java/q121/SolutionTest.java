package q121;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxProfit() {

        Solution solution = new Solution();
        int i = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertEquals(i,5);
        int i2 = solution.maxProfit(new int[]{7,6,4,3,1});
        assertEquals(i2,0);
    }
}