//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2522 👎 0

package leetcode.q70.time20220712;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            return dpOptimize(n);
        }

        /**
         * 斐波那契数列通项公式 1/5^(1/2) * [( (1 + 5^(1/2)/2 ) )^n - ( (1 - 5^(1/2)/2 ) )^n]
         * @param n
         * @return
         */
        public int generalTerm(int n) {
            double sqrt5 = Math.sqrt(5);
            double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
            return (int) Math.round(fibn / sqrt5);
        }

        /**
         * 本质是一个斐波那契数列
         * 递归方式暴力计算,会超时
         */
        public int recursion(int n) {
            if (n == 0 || n == 1 || n == 2) {
                return n;
            }
            return climbStairs(n - 1) + climbStairs(n - 2);
        }

        /**
         * 动态规划
         * 空间复杂度: O(n)
         * 空间复杂度: O(n)
         *
         */
        public int dp(int n) {

            int[] dp = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                if (i <= 2) {
                    dp[i] = i;
                    continue;
                }
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        /**
         * 上面是通俗的dp,实际上dp中只用到了i的前两项,dp可以进行降维,只保留前两项即可
         * 空间复杂度: O(n)
         * 空间复杂度: O(1)
         */
        public int dpOptimize(int n) {
            int pre = 0;
            int prepre = 0;
            int current = 0;
            for (int i = 0; i <= n; i++) {
                if (i == 1) {
                    current = 1;
                } else if (i == 2) {
                    current = 2;
                } else {
                    current = pre + prepre;
                }
                prepre = pre;
                pre = current;
            }
            return current;
        }

        /**
         * 矩阵快速幂 看不懂
         */
        public int multiply(int n) {

            // TODO: 2022/7/12
            return n;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
