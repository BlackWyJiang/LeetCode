package q2;


import static org.junit.Assert.*;

public class SolutionTest {
    @org.junit.Test
    public void twoSum() {
        Solution solution = new Solution();
        Solution.ListNode l1 = new Solution.ListNode(2, new Solution.ListNode(4, new Solution.ListNode(3)));
        Solution.ListNode l2 = new Solution.ListNode(5, new Solution.ListNode(6, new Solution.ListNode(4)));
        Solution.ListNode listNode = solution.addTwoNumbers(l1, l2);

        int[] ret = {7, 0, 8};
        for (int i = 0; i < 3; i++) {
            assertEquals(listNode.val, ret[i]);
            listNode = listNode.next;
        }


    }
}