package q206;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Solution {
    /**
     * 遍历 并且需要两个临时指针 保存 当前遍历到的节点 和 前一个节点
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //空链表或者只有单个节点链表
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp;
        ListNode tmp1 = null;
        while (head.next!=null){
            tmp = head;
            head= head.next;
            tmp.next = tmp1;
            tmp1 = tmp;
        }
        head.next = tmp1;
        return head;


    }

    /**
     * 递归的方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        //空链表或者只有单个节点链表
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reverseList1(head.next);

        //将下一个节点的下一个节点指向自己,翻转
        head.next.next = head;

        //将头节点指向null,否则会变成环形链表
        head.next = null;
        return newNode;


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
