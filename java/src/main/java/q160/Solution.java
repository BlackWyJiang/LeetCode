package q160;

import common.ListNode;

import java.util.HashSet;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 自定义评测：
 *
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 *
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 *
 *
 *
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *
 *
 * 提示：
 *
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 1 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 *
 *
 * 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * 双指针法
     *
     * 证明:
     *     假设 A链表长度为 m,B链表长度为 n.
     *         情景一: 两个链表没有交点,结果应该返回 null
     *             1. 当 m=n 时:
     *                 A指针走过 m 个节点指向 null
     *                 B指针走过 n 个节点指向 null
     *                 因为 m=n
     *                 满足了 A=B 返回null
     *             2. 当 m!=n 时
     *                 A指针走过 m+n 个节点指向 null
     *                 B指针走过 n+m 个节点指向 null
     *                 满足了 A=B 返回null
     *
     *         情景二: 两个链表有交点
     *             假设交点后的链长度为 c
     *             1. 当 m=n 时:
     *                 A指针走过 m-c 个节点指向 相交点
     *                 B指针走过 n-c 个节点指向 相交点
     *                 因为 m=n
     *                 满足了 A=B 返回相交点
     *             2. 当 m!=n 时:
     *                 A指针走过 m+(n-c) 个节点指向 相交点
     *                 B指针走过 n+(m-c) 个节点指向 相交点
     *                 满足了 A=B 返回相交点
     *
     *     时间复杂度: O(n)
     *     时间复杂度: O(1)
     *
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果有一个链表为空则肯定灭有交点
        if (headA == null || headB == null) {
            return null;
        }
        // 定义两个指针分别指向两个链表的头节点
        ListNode pointA = headA;
        ListNode pointB = headB;

        while (pointA != pointB) {
            if (pointA != null) {
                pointA = pointA.next;
            } else {
                pointA = headB;
            }

            if (pointB != null) {
                pointB = pointB.next;
            } else {
                pointB = headA;
            }
        }
        // 走到这里 两个指针相遇或者都遍历完了两个节点
        return pointA;
    }

    /**
     * hash表记录法，将一个链表的所有节点放入hash表，遍历另外一个链表，判断是否hash表中已经存在
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     *
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
