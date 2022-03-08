package q23;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 遍历每一个链表,合并到最终链上
     * 时间复杂度分析: k 代表链表的数量, n 代表每个链表的节点数,则有
     * 第 i 次遍历的时间复杂度为  O(i*n)
     * 则总的时间复杂度为
     *      k
     *    ∑     O(i*n) = O( ((1+k)*k/2)*n ) = O( k^2 *n )
     *      i=1
     *
     * 空间复杂度同上;
     * 所以合并两个有序链表可以采用遍历替换,可以做到单次 时间 O(n), 空间 O(1)复杂度.
     * 总的时间复杂度 O( k^2 *n ) 空间O(1)
     *
     *
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode hair = new ListNode();
        for (int i = 0; i < lists.length; i++) {
            hair.next = mergeTwoList(hair.next, lists[i]);
        }
        return hair.next;
    }

    /**
     * 合并两个有序链表
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(n+m)
     */
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
