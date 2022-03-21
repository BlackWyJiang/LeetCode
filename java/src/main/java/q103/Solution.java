package q103;

import common.TreeNode;

import java.lang.reflect.WildcardType;
import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *
 *
 * 示例 1：
 *
 *      3
 *     /\
 *    9  20
 *       /\
 *      15 7
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 双端队列法
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        // 构建双端队列
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);

        // 标记是第几层
        int flag = 1;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            while (levelNum > 0) {
                TreeNode polled;
                if (flag % 2 == 1) {
                    // 奇数层从左到右
                    polled = queue.pollFirst();
                    if (polled.left!=null){
                        queue.offerLast(polled.left);
                    }
                    if (polled.right!=null){
                        queue.offerLast(polled.right);
                    }
                } else {
                    polled = queue.pollLast();
                    if (polled.right!=null){
                        queue.offerFirst(polled.right);
                    }
                    if (polled.left!=null){
                        queue.offerFirst(polled.left);
                    }

                }

                level.add(polled.val);
                levelNum--;
            }
            ret.add(level);
            flag++;

        }
        return ret;

    }

    /**
     * 双栈法
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<TreeNode> stack1 = new Stack<>();

        while (!stack.isEmpty() || !stack1.isEmpty()) {
            if (!stack.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<>();
                while (!stack.isEmpty()) {
                    TreeNode pop = stack.pop();
                    if (pop.left != null) {
                        stack1.push(pop.left);
                    }
                    if (pop.right != null) {
                        stack1.push(pop.right);
                    }
                    level.add(pop.val);
                }
                ret.add(level);
            }

            if (!stack1.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode pop = stack1.pop();
                    if (pop.right != null) {
                        stack.push(pop.right);
                    }
                    if (pop.left != null) {
                        stack.push(pop.left);
                    }
                    level.add(pop.val);
                }
                ret.add(level);
            }

        }
        return ret;
    }

    /**
     * 二叉树前序遍历
     * 父节点 ->  左节点 -> 右节点的顺序
     *                  1
     *                /   \
     *               2     3
     *              / \   / \
     *             4  5  6   7
     *               /   \
     *              8     9
     *
     *           应该输出 124583697
     *
     *
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        preOrderRecursion(root, ret);
        return ret;
    }

    private void preOrderRecursion(TreeNode node, List<Integer> context) {
        if (node == null) {
            return;
        }
        context.add(node.val);
        preOrderRecursion(node.left, context);
        preOrderRecursion(node.right, context);
    }

    /**
     * 二叉树中序遍历
     * 左节点 -> 父节点 ->  右节点的顺序
     *                  1
     *                /   \
     *               2     3
     *              / \   / \
     *             4  5  6   7
     *               /   \
     *              8     9
     *
     *           应该输出 428516937
     *
     */
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inOrderRecursion(root, ret);
        return ret;


    }

    private void inOrderRecursion(TreeNode node, List<Integer> context) {
        if (node == null) {
            return;
        }
        inOrderRecursion(node.left, context);
        context.add(node.val);
        inOrderRecursion(node.right, context);
    }

    /**
     * 二叉树后序遍历
     * 左节点 ->  右节点 -> 父节点 的顺序
     *
     *                  1
     *                /   \
     *               2     3
     *              / \   / \
     *             4  5  6   7
     *               /   \
     *              8     9
     *
     *           应该输出 485296731
     */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        postOrderRecursion(root, ret);
        return ret;


    }

    private void postOrderRecursion(TreeNode node, List<Integer> context) {
        if (node == null) {
            return;
        }
        postOrderRecursion(node.left, context);
        postOrderRecursion(node.right, context);
        context.add(node.val);

    }

    /**
     * 层序遍历
     *                  1
     *                /   \
     *               2     3
     *              / \   / \
     *             4  5  6   7
     *               /   \
     *              8     9
     *
     *           应该输出 123456789
     */
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            ret.add(poll.val);
        }
        return ret;
    }

    /**
     * 区分层序遍历
     * 分层遍历,返回每一层内容
     *
     *                  1
     *                /   \
     *               2     3
     *              / \   / \
     *             4  5  6   7
     *               /   \
     *              8     9
     *
     *           应该输出 1 23 4567 89
     */
    public List<List<Integer>> splitLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            // 当前层的数量
            int levelNum = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>(levelNum);
            while (levelNum > 0) {
                TreeNode polled = queue.poll();
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
                currentLevel.add(polled.val);
                levelNum--;
            }
            ret.add(currentLevel);
        }

        return ret;
    }


}
