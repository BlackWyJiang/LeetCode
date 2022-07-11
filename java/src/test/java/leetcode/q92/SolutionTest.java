package q92;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import common.ListNode;

public class SolutionTest {
    Solution solution = new Solution();
    
    @Test
    public void testReverseBetween() {
    
        ListNode head = ListNode.single("[1,2,3,4,5]");
        ListNode ret = solution.reverseBetween(head, 2, 4);
    
        assertArrayEquals(ListNode.toArray(head), ListNode.toArray(ret));

    }
}
