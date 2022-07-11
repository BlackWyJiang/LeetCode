package q912;

import org.junit.Test;
import utils.SortUtils;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void sortArray() {
//        Random random = new Random();
//
//        for (int i = 0; i < 1000; i++) {
//            int size = random.nextInt(9999);
//
//            int[] ints = new int[size];
//            for (int j = 0; j < size; j++) {
//                ints[j] = random.nextInt(size);
//            }
//
//            Integer[] output = Arrays.stream(
//                    new Solution().sortArray(ints)
//            ).boxed().toArray(Integer[]::new);
//
//            boolean ascSorted = SortUtils.isAscSorted(output);
//            assertTrue(ascSorted);
//
//
//        }

//        int[] ints = {4,2,5,3,1};
        int[] ints = {-4,0,7,4,9,-5,-1,0,-7,-1};
        Integer[] output = Arrays.stream(
                new Solution().sortArray(ints)
        ).boxed().toArray(Integer[]::new);

        boolean ascSorted = SortUtils.isAscSorted(output);
        assertTrue(ascSorted);
    }
}