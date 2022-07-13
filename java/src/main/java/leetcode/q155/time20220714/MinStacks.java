//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
// Related Topics 栈 设计 👍 1347 👎 0

package leetcode.q155.time20220714;

public class MinStacks {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private Node min = new Node(Integer.MAX_VALUE);
        private Node head = new Node();

        public MinStack() {

        }

        public void push(int val) {
            Node node = new Node(val);
            node.next = head.next;
            head.next = node;
            Node minNode = new Node(Math.min(min.val, val));
            minNode.next = min;
            min= minNode;
        }

        public void pop() {
            head.next = head.next.next;
            min = min.next;
        }

        public int top() {
            return head.next.val;
        }

        public int getMin() {
            return min.val;
        }

        class Node {
            int val;
            Node next;

            public Node() {
            }

            public Node(int val) {
                this.val = val;
            }
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
