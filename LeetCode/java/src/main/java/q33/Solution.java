package q33;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 *
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 局部有序,二分法
     *
     * 题目前面的条件说明了 nums[0]一定是分割点,即 [0..x]有序,[x+1..n-1]也有序;
     * 也就是说
     * 有个某个值i
     * 如果 i>nums[0],那么 [0..i]有序
     * 反之 [i..n-1]有序
     *
     *
     */
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }


            if (nums[mid] >= nums[l]) {
                // 左边有序
                if (target <= nums[mid] && target >= nums[l]) {
                    //如果target在有序区间,直接在此进行二分查找
                    r = mid - 1;
                } else {
                    //否则继续在另一半 不平衡对称 区间内查找
                    l = mid + 1;
                }
            } else {
                // 右边有序
                if (target >= nums[mid] && target <= nums[r]) {
                    l = mid + 1;

                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }

    /**
     * 暴力遍历
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;

    }
}
