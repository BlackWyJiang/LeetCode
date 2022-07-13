//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 865 👎 0

package leetcode.q144.time20220714;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            return stack(root);
        }

        /**
         * 借用栈结构实现二叉树遍历
         * @param root
         * @return
         */
        public List<Integer> stack(TreeNode root) {
            ArrayList<Integer> ret = new ArrayList<>();
            if (root == null) {
                return ret;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                ret.add(pop.val);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
            return ret;
        }


        /**
         * 递归法
         * @param root
         * @return
         */
        public List<Integer> recursion(TreeNode root) {
            ArrayList<Integer> ret = new ArrayList<>();
            recursion(root, ret);
            return ret;
        }

        private void recursion(TreeNode root, List<Integer> ret) {
            if (root == null) {
                return;
            }
            ret.add(root.val);
            recursion(root.left, ret);
            recursion(root.right, ret);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
