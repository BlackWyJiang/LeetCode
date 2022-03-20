package common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * [1,2,3,4,5,6,7,8,9]
     *
     */
    public static TreeNode of(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        buildNode(root, 0, nums);
        return root;
    }

    private static void buildNode(TreeNode parent, int i, int[] nums) {
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        if (leftIndex < nums.length) {
            TreeNode leftNode = new TreeNode(nums[leftIndex]);
            buildNode(leftNode,leftIndex,nums);
            parent.left=leftNode;
        }
        if (rightIndex < nums.length) {
            TreeNode rightNode = new TreeNode(nums[rightIndex]);
            buildNode(rightNode,rightIndex,nums);
            parent.right=rightNode;
        }
    }
}
