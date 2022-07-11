package q215;


import java.util.Random;

import static org.junit.Assert.*;

/**
 *
 */
public class Test {
    @org.junit.Test
    public void test() {
        int[] nums = {3, 2, 1, 5, 4,6};


        int ret = new Solution().findKthLargest2(nums, 2);
        assertEquals(5,ret);

//        for (int j = 0; j < 10000; j++) {
//            int[] arr = new int[50];
////        int[] arr = {3, 2, 1, 5, 6};
//            Random random = new Random();
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = random.nextInt(100);
//            }
//
//            new FastSorter().sort(arr);
//            boolean sorted = isSorted(arr);
//            assertTrue(sorted);
//        }


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
