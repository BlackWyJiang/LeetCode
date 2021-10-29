package q3;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 */
public class Solution {

    /**
     * 滑动窗口
     * <p>
     * 执行用时：
     * 28 ms
     * , 在所有 Java 提交中击败了
     * 14.77%
     * 的用户
     * 内存消耗：
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 99.52%
     * 的用户
     * 通过测试用例：
     * 987 / 987
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int len = s.length();
        int left = 0, right = 0;

        //保存已经走过的字符
        HashSet<Character> set = new HashSet<>();
        while (right < len) {
            Character rightC = s.charAt(right);

            //如果窗口内不包含已经重复的字符,窗口右指针往右移动一位
            if (!set.contains(rightC)) {
                set.add(rightC);

            } else {
                //如果包含,则移动窗口左指针到重复过的下一位
                for (int i = left; i < right; i++) {
                    if (rightC.equals(s.charAt(i))) {
                        left = i + 1;
                    }

                }
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }

        return ret;
    }

    /**
     * 对上面的一些优化,依然是滑动窗口,只是窗口左指针,不通过遍历了,
     * 实质上是一种空间换时间的方案
     *
     * 执行用时：
     * 6 ms
     * , 在所有 Java 提交中击败了
     * 72.66%
     * 的用户
     * 内存消耗：
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 98.83%
     * 的用户
     * 通过测试用例：
     * 987 / 987
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int ret = 0;
        int len = s.length();
        int left = 0, right = 0;

//        HashSet<Character> set = new HashSet<>();
        //保存已经走过的字符和所在的索引
        Map<Character, Integer> map = new HashMap();
        while (right < len) {
            Character rightC = s.charAt(right);

            if (map.containsKey(rightC)){
                //如果包含,则移动窗口左指针到重复过的下一位
//                for (int i = left; i < right; i++) {
//                    if (rightC.equals(s.charAt(i))) {
//                        left = i + 1;
//                    }
//
//                }
                //通过使用map存储索引的方式来减少左指针的遍历
                left = Math.max(map.get(rightC) + 1,left);
            }
            map.put(rightC, right);
            ret = Math.max(ret, right - left + 1);
            right++;
        }

        return ret;
    }

    /**
     * 动态规划实现
     * TODO 待理解动态规划后再补充
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {

        return  0;
    }

    public static void main(String[] args) {
        int abcabcbb = new Solution().lengthOfLongestSubstring1("abba");
        System.out.println(abcabcbb);

    }
}
