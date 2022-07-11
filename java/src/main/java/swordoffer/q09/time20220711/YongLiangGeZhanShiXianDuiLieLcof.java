//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计 队列 👍 565 👎 0

package swordoffer.q09.time20220711;


public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {

        private MyStack<Integer> in = new MyStack<>();
        private MyStack<Integer> out = new MyStack<>();

        public CQueue() {
        }

        /**
         * 增加队列时候要保证输出栈是空的,才能保证顺序
         * @param value
         */
        public void appendTail(int value) {

            in.push(value);
        }

        /**
         * 当删除头节点时候输出栈为空则从输入转移过来
         * @return
         */
        public int deleteHead() {

            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
                if (out.isEmpty()) {
                    return -1;
                }
            }
            return out.pop();

        }
    }

    class MyStack<T> {
        Node head = null;
        Node tail = null;


        public boolean isEmpty() {
            return head == null;
        }

        public void push(T value) {
            if (head == null) {
                head = tail = new Node(value);

            } else {
                tail.next = new Node(value);
                tail = tail.next;
            }

        }

        public T pop() {
            if (head == null) {
                return null;
            }
            Node tmp = head;
            head = head.next;
            return tmp.value;
        }

        class Node {
            T value;
            Node next;

            public Node(T value) {
                this.value = value;
            }

            public Node() {
            }
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
