package q25;

import org.junit.Test;
import utils.ReflectUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void reverseKGroup() {
//     输入：head = [1,2,3,4,5], k = 2
//     输出：[2,1,4,3,5]
        int[] input = {1, 2, 3, 4, 5};
        ListNode head = arr2ListNode(input);
        ListNode listNode = new Solution().reverseKGroup(head, 1);
        int[] output = listNode2Arr(listNode);
//        int[] standard = {2, 1, 4, 3, 5};
        int[] standard = {1, 2, 3, 4, 5};

        assertArrayEquals(output, standard);

    }


    @Test
    public void reverse() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
//     输入：head = [1,2,3,4,5], k = 2
//     输出：[2,1,4,3,5]
        int[] input = {1, 2, 3, 4, 5};
        ListNode head = arr2ListNode(input);

        ReflectUtils.invokeMethod(new Solution(), "reverse", head, head.next, head.next.next.next);
        int[] output = listNode2Arr(head);
        int[] standard = {1, 4, 3, 2, 5};

        assertArrayEquals(output, standard);

    }

    /**
     * 数组转链表
     *
     * @param array
     * @return
     */
    private ListNode arr2ListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode listNode = new ListNode(array[0]);
        ListNode tmp = listNode;
        for (int i = 1; i < array.length; i++) {
            ListNode listNode1 = new ListNode(array[i]);
            tmp.next = listNode1;
            tmp = listNode1;
        }
        return listNode;
    }

    private int[] listNode2Arr(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (head.next != null) {
            head = head.next;
            list.add(head.val);
        }


        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}