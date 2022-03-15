package q23;

import common.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void mergeKLists() {
//        [[],[-1,5,11],[],[6,10]]

        ListNode[] listNodes = ListNode.doublee("[[],[-1,5,11],[],[6,10]]");
        ListNode listNode = new Solution().mergeKLists(listNodes);
        int[] ints = ListNode.toArray(listNode);
        assertArrayEquals(ints,new int[]{-1,5,6,10,11});
    }
}