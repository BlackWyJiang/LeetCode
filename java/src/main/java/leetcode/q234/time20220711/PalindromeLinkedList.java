//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1438 👎 0

package q234.time20220711;

import common.ListNode;

import java.util.ArrayList;
import java.util.Objects;

public class PalindromeLinkedList {
    public static void main(String[] args) {

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
        /**
         * 需要做到空间复杂度O(1),肯定会破坏原来链表结构
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            return slowFastPoint(head);
        }

        /**
         * 快慢指针方式 实现
         * 快指针走两步,慢指针走一步,当快指针走到末尾,慢指针刚好走到中间
         */
        public boolean slowFastPoint(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode slow = head;
            ListNode fast = head;


            // 移动指针
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null) {
                //总共有奇数个节点,向后移动一步进入下半段
                slow = slow.next;
            }

            ListNode reverse = reverse(slow);
            while (reverse != null) {
                if (head.val != reverse.val) {
                    return false;
                }
                head = head.next;
                reverse = reverse.next;
            }
            return true;
        }

        /**
         * 反转链表
         * @param slow
         * @return
         */
        private ListNode reverse(ListNode slow) {
            if (slow == null || slow.next == null) {
                return slow;
            }
            ListNode hair = new ListNode();
            ListNode current = slow;
            while (current != null) {
                ListNode next = current.next;
                current.next = hair.next;
                hair.next = current;
                current = next;
            }
            return hair.next;
        }

        /**
         *  链表转列表,头尾双指针向中间移动
         *  时间空间复杂度都为O(n)
         */
        public boolean linkNodeToList(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ArrayList<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            int left = 0;
            int right = list.size() - 1;
            while (left < right) {
                if (!Objects.equals(list.get(right), list.get(left))) {
                    return false;
                }

                left++;
                right--;
            }
            return true;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
