package q215;


import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class Test {
    @org.junit.Test
    public void test() {


        for (int j = 0; j < 10000; j++) {
            int[] arr = new int[5];
//        int[] arr = {3, 2, 1, 5, 6};
            Random random = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(100);
            }

            new HeapSorter().sort(arr);
            boolean sorted = isSorted(arr);
            assertTrue(sorted);
        }



    }

    private boolean isSorted(int[] arr) {
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < pre) {
                return false;
            }
        }
        return true;
    }
}
