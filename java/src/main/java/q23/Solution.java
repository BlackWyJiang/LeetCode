package q23;

import common.ListNode;

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

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists2(lists, 0, lists.length - 1);
    }

    /**
     * 使用分治思想,进行归并合并 链表,此方法只能优化 k 因子
     * 时间复杂度分析: k 代表链表的数量, n 代表每个链表的节点数,则有
     * 共需要合并 k/2 +1 次
     * 第 i 次消耗为 (2 * i * n) * ( k/(2^i) ) -> (每组链表长度)*(合并的链表组数)
     *      k/2 +1
     *   ∑         O((2 * i * n) * ( k/(2^i) )) = O( klogk * n )
     *      i=1
     *
     *
     */
    private ListNode mergeKLists2(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            // 空list会走到这
            return null;
        }
        int mid = l + ((r - l) >> 1);
        ListNode left = mergeKLists2(lists, l, mid);
        ListNode right = mergeKLists2(lists, mid + 1, r);
        return mergeTwoList(left, right);
    }


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
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode hair = new ListNode();
        for (int i = 0; i < lists.length; i++) {
            hair.next = mergeTwoList(hair.next, lists[i]);
        }
        return hair.next;
    }


    /**
     * 递归合并两个有序链表
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(1)
     */
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {

        ListNode hair = new ListNode();
        ListNode pre = hair;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return hair.next;
    }

    /**
     * 递归合并两个有序链表
     * 时间复杂度: O(n+m)
     * 空间复杂度: O(n+m)
     */
    private ListNode mergeTwoList1(ListNode l1, ListNode l2) {
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

