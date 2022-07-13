//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2489 👎 0

package leetcode.q136.time20220714;

public class SingleNumber {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用抑或的性质
         *
         * 1.任何数和 00 做异或运算，结果仍然是原来的数，即 a^0=a
         * 2.任何数和其自身做异或运算，结果是 0，即 a^a=0
         * 3.异或运算满足交换律和结合律
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            int ret = 0;
            for (int i = 0; i < nums.length; i++) {
                ret ^= nums[i];
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
