package q236;

import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void lowestCommonAncestor() {
        TreeNode treeNode = TreeNode.of(new int[]{1,2});
        TreeNode treeNode1 = solution.lowestCommonAncestor(treeNode, treeNode.left, new TreeNode(3));
        assertNull(treeNode1);
    }

    @Test
    public void findPath() {
        TreeNode treeNode = TreeNode.of(new int[]{3, 5, 1, 6, 2, 9, 8, 0, 0, 7, 4});
        List<TreeNode> pPath = solution.findPath(treeNode, treeNode.left.right);
        List<TreeNode> qPath = solution.findPath(treeNode, treeNode.right.left);
        assertArrayEquals(pPath.stream().map(item -> item.val).toArray(), new Object[]{3, 5, 2});
        assertArrayEquals(qPath.stream().map(item -> item.val).toArray(), new Object[]{3, 1, 9});
    }
}