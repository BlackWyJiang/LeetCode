//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2612 👎 0

package q206.time20220710;

import common.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = ListNode.of(new int[]{1, 2, 4});
        ListNode listNode = new ReverseLinkedList().reverseList(head);
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print("\t");
            listNode = listNode.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        return new Solution().iteration(head);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {

            return reverse(head);

        }

        public ListNode reverse(ListNode head) {
            // 空链表或单节点链表
            if (head == null || head.next == null) {
                return head;
            }

            ListNode node = reverse(head.next);
            head.next.next = head;
            // 不置空就会变成环形链表
            head.next = null;
            return node;
        }

        /**
         * 迭代
         */
        public ListNode iteration(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = null;
            ListNode next = null;
            ListNode current = head;

            while (current.next != null) {
                next = current.next;
                current.next = pre;
                pre = current;
                current = next;


            }

            current.next = pre;
            return current;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
