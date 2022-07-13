//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//  2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 321 👎 0

package swordoffer.qJianZhiOffer54.time20220713;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {

    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int kthLargest(TreeNode root, int k) {
            TreeNode treeNode = infixOrder(root, k);
            return treeNode.val;
        }

        /**
         * 中序遍历
         * 逆序的中序遍历
         * LinkedList 代替 Stack 速度快很多,因为Stack 是线程安全的
         *
         */
        public TreeNode infixOrder(TreeNode root, int k) {
            int count = 0;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode current = root;
            while (current != null || !stack.isEmpty()) {
                // 将最右侧节点入栈
                while (current != null) {
                    stack.push(current);
                    current = current.right;
                }
                current = stack.pop();
                count++;
                if (count == k) {
                    return current;
                }
                current = current.left;
            }
            return null;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
