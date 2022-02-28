package q53;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 动态规划
     * 思路和算法
     * 假设 nums 数组的长度是 n，下标从 0 到 n-1。
     * 我们用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：
     * max{f(i)} ------ 0 <= i <= n-1
     * 因此我们只需要求出每个位置的 f(i)，然后最大值即可。那么我们如何求 f(i) 呢？
     * 我们可以考虑 nums[i] 单独成为一段还是加入 f(i−1) 对应的那一段，这取决于 nums[i] 和 f(i−1)+nums[i] 的大小，
     * 我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
     * f(i) = max( f(i-1) + nums[i] , nums[i] )
     * f(0) = nums[0]
     * <p>
     * 时间复杂度：O(n)O(n)，其中 n 为 nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
     * 空间复杂度：O(1)O(1)。我们只需要常数空间存放若干变量。
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentEnd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentEnd = Math.max(currentEnd + nums[i], nums[i]);
            max = Math.max(max, currentEnd);
        }
        return max;
    }

    /**
     * 分治
     * 线段树?
     * 
     */
    public int maxSubArray1(int[] nums) {
        // TODO: 2022/2/28  
        return 0;
    }

}
