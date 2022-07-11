package q15;

import org.junit.Test;
import utils.SortUtils;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class SolutionTest {

    private Random random = new Random();
    @Test
    public void testSort(){
        Solution.FastSorter fastSorter = new Solution.FastSorter();

        for (int i = 0; i < 1000; i++) {
            int[] generate = generate(random.nextInt(99));
            fastSorter.sort(generate);
            assertTrue( SortUtils.isAscSorted(generate));
        }
        int[] generate = generate(1);
        fastSorter.sort(generate);
        assertTrue( SortUtils.isAscSorted(generate));

    }

    private int[] generate(int len){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = random.nextInt(99);
        }
        return arr;
    }

    @Test
    public void threeSum() {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new Solution().threeSum1(arr);

        System.out.println(lists);
    }
}