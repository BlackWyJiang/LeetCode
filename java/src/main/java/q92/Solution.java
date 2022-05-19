package q92;

import common.ListNode;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (55.33%)
 * Likes:    1281
 * Dislikes: 0
 * Total Accepted:    295K
 * Total Submissions: 533K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left  。请你反转从位置 left 到位置 right 的链表节点，返回
 * 反转后的链表 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目为 n
 * 1 
 * -500 
 * 1 
 * 
 * 
 * 
 * 
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        int count = 1;

        ListNode pre = null, subHead = null, subTail = null, tmp = null;
        ListNode current = head;
        while (current != null) {
            tmp = current.next;

            if (count == left - 1) {
                pre = current;
            }
            if (count == left) {
                subHead = current;
                subTail = current;
            }

            if (count > left) {
                current.next = subHead;
                subHead = current;
            }
            if (count == right) {
                subTail.next = tmp;
                if (pre == null) {
                    // left = 1
                    return subHead;
                }
                pre.next = subHead;
                // 终止
                break;
            }

            current = tmp;
            count++;
        }
        return head;

    }
}
// @lc code=end
