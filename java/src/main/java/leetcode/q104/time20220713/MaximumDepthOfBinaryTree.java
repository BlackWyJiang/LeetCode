//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1292 👎 0

package leetcode.q104.time20220713;

import common.TreeNode;

public class MaximumDepthOfBinaryTree {
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
        int max = 0;

        public int maxDepth(TreeNode root) {
            recursion(root);
            return max;
        }

        public int recursion(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int currentMax = Math.max(recursion(root.left), recursion(root.right)) + 1;
            max = Math.max(max, currentMax);
            return currentMax;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
