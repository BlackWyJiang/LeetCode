package q236;

import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 暴力解法
     * 找到 root -> p 的路径 和 root -> q 的路径
     * 然后取路径中最深的相同值
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        List<TreeNode> pPath = findPath(root, p);
        List<TreeNode> qPath = findPath(root, q);
        if (pPath.isEmpty() || qPath.isEmpty()) {
            // 有一条路径没找到,说明没有公共父节点
            return null;
        }

        int point = 0;
        while (point < pPath.size() && point < qPath.size()) {
            if (pPath.get(point).equals(qPath.get(point))) {
                point++;
            } else {
                break;
            }
        }
        return pPath.get(point-1);

    }

    /**
     *  查找根节点到目标节点的路径
     */
    public List<TreeNode> findPath(TreeNode root, TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        boolean find = findPathRecursion(root, node, stack);
        if (find){
            return new ArrayList<>(stack);
        }else {
            return Collections.emptyList();
        }
    }

    public boolean findPathRecursion(TreeNode root, TreeNode node ,Stack<TreeNode> stack ){
        stack.push(root);
        if (root == node){
            return true;
        }

        if (root.left!=null){
            boolean find = findPathRecursion(root.left, node, stack);
            if (find){
                return true;
            }
        }
        if (root.right!=null){
            boolean find = findPathRecursion(root.right, node, stack);
            if (find){
                return true;
            }
        }
        stack.pop();
        return false;
    }


}
