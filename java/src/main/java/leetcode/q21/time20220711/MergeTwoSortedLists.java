//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2523 👎 0

package q21.time20220711;

import common.ListNode;

public class MergeTwoSortedLists {
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            return reverse(list1, list2);
        }

        /**
         * 递归法
         */
        private ListNode reverse(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            if (list1.val <= list2.val) {
                list1.next = reverse(list1.next, list2);
                return list1;
            } else {
                list2.next = reverse(list1, list2.next);
                return list2;
            }
        }

        /**
         * 双指针迭代法
         */
        public ListNode iteration(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode hair = new ListNode();
            ListNode point1 = list1;
            ListNode point2 = list2;
            ListNode tail = hair;

            while (point1 != null && point2 != null) {
                if (point1.val <= point2.val) {
                    tail.next = point1;
                    point1 = point1.next;

                } else {
                    tail.next = point2;
                    point2 = point2.next;
                }
                tail = tail.next;
            }
            if (point1 != null) {
                tail.next = point1;
            }
            if (point2 != null) {
                tail.next = point2;
            }

            return hair.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
