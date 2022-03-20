package q103;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return null;
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
        inOrderRecursion(root,ret);
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
        postOrderRecursion(root,ret);
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
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        return null;


    }


}
