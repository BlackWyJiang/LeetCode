package common;

import java.util.ArrayList;

/**
 * 简单的单链表
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     *
     * 初始化链表
     *
     */
    public static ListNode of(int[] input) {
        if (input == null || input.length == 0) {
            return null;
        }
        ListNode head = new ListNode(input[0]);
        ListNode pre = head;

        for (int i = 1; i < input.length; i++) {
            pre.next = new ListNode(input[i]);
            pre = pre.next;
        }

        return head;
    }

    /**
     * 单链表
     */
    public static ListNode single(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        int i = input.indexOf("[");
        if (i == -1) {
            return null;
        }
        int j = input.indexOf("]", i + 1);
        if (j == -1) {
            return null;
        }

        String substring = input.substring(i + 1, j);
        substring = substring.replace(";", ",");
        substring = substring.replace("；", ",");
        substring = substring.replace(":", ",");
        substring = substring.replace("：", ",");
        substring = substring.replace("，", ",");
        String[] split = substring.split(",");
        int[] ret = new int[split.length];
        for (int k = 0; k < ret.length; k++) {
            String s = split[k];
            try {
                int i1 = Integer.parseInt(s);
                ret[k] = i1;
            } catch (NumberFormatException e) {
                return null;
            }

        }
        return of(ret);
    }

    /**
     * 多条单链表
     *
     * @param input
     * @return
     */
    public static ListNode[] doublee(String input) {
        ArrayList<ListNode> ret = new ArrayList<>();
        if (input == null) {
            return new ListNode[0];
        }

        int i = input.indexOf("[");
        if (i == -1) {
            return new ListNode[0];
        }
        int j = input.lastIndexOf("]");
        if (j == -1) {
            return new ListNode[0];
        }
        input = input.substring(i + 1, j);
        while (input.length() != 0) {
            int ii = input.indexOf("[");
            if (ii == -1) {
                input = "";
                break;
            }
            int jj = input.indexOf("]");
            if (jj == -1) {
                input = "";
                break;
            }
            String substring = input.substring(ii, jj + 1);
            input = input.substring(jj + 1);

            ret.add(single(substring));
        }
        ListNode[] listNodes = new ListNode[ret.size()];
        return ret.toArray(listNodes);
    }

    /**
     * 链表转数组
     * @param list
     * @return
     */
    public static int[] toArray(ListNode list) {
        ArrayList<Integer> retList = new ArrayList<>();
        while (list != null) {
            retList.add(list.val);
            list = list.next;
        }
        int[] ret = new int[retList.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = retList.get(i);
        }
        return ret;
    }

    public static String toString(ListNode node) {
        if (node == null) {
            return "null";
        }
        ArrayList<String> list = new ArrayList<>();
        while (node.next != null) {
            list.add(String.valueOf(node.val));
            node = node.next;
        }
        list.add(String.valueOf(node.val));
        return String.join(" -> ", list);
    }
}
