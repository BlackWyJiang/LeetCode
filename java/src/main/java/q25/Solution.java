package q25;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 每找到k个节点便翻转这 k 个链表,依次遍历
     *
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 38.8 MB, 在所有 Java 提交中击败了21.94%的用户
     * 通过测试用例：
     * 62 / 62
     *
     * 内存消耗有点问题,猜测原因因为栈内临时变量较多问题,看是否有可以重用的临时变量
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        //在最前面增加一个虚拟头,就可以避免处理边界问题
        ListNode constHead = new ListNode();
        constHead.next = head;
        ListNode currentHead = head;
        ListNode currentTail = head;
        ListNode preTail = constHead;


        int counter = 1;

        while (currentTail.next != null) {

            if (counter == k) {
                reverse(preTail, currentHead, currentTail);
                preTail = currentHead;
                currentTail = currentHead.next;
                currentHead = currentHead.next;
                counter = 1;


            } else {
                counter++;
                currentTail = currentTail.next;
            }

        }
        if (counter == k) {
            reverse(preTail, currentHead, currentTail);
        }


        return constHead.next;
    }

    /**
     * 翻转 head-tail 段的链表
     *
     * @param parent head的父节点
     * @param head
     * @param tail
     */
    private void reverse(ListNode parent, ListNode head, ListNode tail) {
        if (head == tail){
            return;
        }
        ListNode pre = tail.next;
        ListNode current = head;

        while (current.next != tail) {
            ListNode tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        current.next = pre;
        tail.next = current;
        parent.next = tail;


    }
}

//Definition for singly-linked list.
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
