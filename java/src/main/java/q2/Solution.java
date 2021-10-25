package q2;


/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class Solution {

    /**
     * 比较占用内存
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 95.83%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 19.66%
     * 的用户
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryFlag = 0;
        ListNode head = null, tail = null;

        int v1 = 0;
        int v2 = 0;
        int add = 0;
        while (l1 != null || l2 != null) {
            v1 = l1 == null ? 0 : l1.val;
            v2 = l2 == null ? 0 : l2.val;
            add = v1 + v2 + carryFlag;
            carryFlag = add / 10;
            int nodeVal = add % 10;
            if (tail == null) {
                head = new ListNode(nodeVal);
                tail = head;
            } else {
                tail.next = new ListNode(nodeVal);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carryFlag != 0) {
            tail.next = new ListNode(carryFlag);
            tail = tail.next;
        }
        return head;

    }

    /**
     * 修改上面内存占用太高问题
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int carryFlag = 0;
        ListNode head = null, tail = null;

        int v1 = 0;
        int v2 = 0;
        int add = 0;
        while (l1 != null || l2 != null) {
            v1 = l1 == null ? 0 : l1.val;
            v2 = l2 == null ? 0 : l2.val;
            add = v1 + v2 + carryFlag;
            carryFlag = add / 10;
            int nodeVal = add % 10;
            if (tail == null) {
                head = new ListNode(nodeVal);
                tail = head;
            } else {
                tail.next = new ListNode(nodeVal);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carryFlag != 0) {
            tail.next = new ListNode(carryFlag);
            //只需要将此代码注释掉,不再给tail.next赋值,内存占用会掉下来
//            tail = tail.next;
        }
        return head;
    }

    static class ListNode {
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

}
