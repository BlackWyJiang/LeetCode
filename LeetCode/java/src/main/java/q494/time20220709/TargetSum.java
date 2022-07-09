//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 1289 👎 0

package q494.time20220709;

public class TargetSum {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {

            return new DP().findTargetSumWays(nums, target);
        }

    }

    /**
     * 动态规划
     *
     * 假设 数组中 中所有元素和为 sum ,为'-'的元素之和为 negative ,则为'+'的元素之和为 (sum- negative);
     * 则有 (sum- negative) - negative =  target;
     * 则有 negative = (sum-target)/2
     * 又因为 negative 为非负整数
     * 所以 sum-target 必须为非负偶数才可以满足条件,即 sum-target 不为非负偶数的方案数量肯定为0;
     * 到此问题演变为在nums中找到几个数之和为 negative ,则变成了经典的0-1背包问题
     */
    class DP {
        public int findTargetSumWays(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }

            /**
             * 假设 数组中 中所有元素和为 sum ,为'-'的元素之和为 negative ,则为'+'的元素之和为 (sum- negative);
             * 则有 (sum- negative) - negative =  target;
             * 则有 negative = (sum-target)/2
             * 又因为 negative 为非负整数
             * 所以 sum-target 必须为非负偶数才可以满足条件,即 sum-target 不为非负偶数的方案数量肯定为0;
             */
            if (sum - target < 0 || (sum - target) % 2 != 0) {
                return 0;
            }
            int negative = (sum - target) / 2;

            //到此问题演变为在nums中找到几个数之和为 negative ,则变成了经典的0-1背包问题
            int[][] dp = new int[nums.length + 1][negative + 1];

            dp[0][0] = 1;
            for (int i = 1; i <= nums.length; i++) {
                int num = nums[i - 1];
                for (int j = 0; j <= negative; j++) {
                    if (j < num) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                    }

                }
            }
            return dp[nums.length][negative];
        }
    }

    /**
     * 回溯法
     * 时间复杂度 O(2^n)
     * 空间复杂度 O(n)
     */
    class Backtrack {
        private int count = 0;

        private void backtrack(int[] nums, int target, int index, int sum) {
            if (index == nums.length) {
                if (target == sum) {
                    count++;
                }
                return;
            }

            backtrack(nums, target, index + 1, sum - nums[index]);
            backtrack(nums, target, index + 1, sum + nums[index]);
        }

        public int findTargetSumWays(int[] nums, int target) {
            backtrack(nums, target, 0, 0);
            return count;
        }


    }


//leetcode submit region end(Prohibit modification and deletion)

}
