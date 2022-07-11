//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 585 👎 0

package q415.time20220711;

public class AddStrings {
    public static void main(String[] args) {

        System.out.println(new Solution().addStrings("456", "77"));
        ;
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            if (num1 == null) {
                return num2;
            }
            if (num2 == null) {
                return num1;
            }
            int len1 = num1.length();
            int len2 = num2.length();
            int len = Math.max(len1, len2) + 1;
            int lastMod = 0;
            char[] chars = new char[len];
            for (int i = 0; i < len; i++) {

                int index1 = len1 - 1 - i;
                int item1 = index1 < 0 ? 0 : num1.charAt(index1) - '0';
                int index2 = len2 - 1 - i;
                int item2 = index2 < 0 ? 0 : num2.charAt(index2) - '0';
                int sum = item1 + item2 + lastMod;
                lastMod = sum / 10;
                int ret = sum % 10;
                chars[len - 1 - i] = (char) (ret + '0');

            }
            if (chars[0] == '0') {
                return new String(chars, 1, chars.length - 1);
            } else {
                return new String(chars);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
