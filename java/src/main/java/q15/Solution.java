package q15;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 暴力破解法
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        List<int[]> all = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < nums.length; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        ret.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        all.add(new int[]{nums[i], nums[j], nums[k]});
                    }
                }

            }
        }

        //去掉重复的
        List<List<Integer>> ret = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int[] ii : all) {
            fastSorter.sort(ii);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < ii.length; i++) {
                stringBuilder.append(ii[i]);
            }
            String s = stringBuilder.toString();
            if (!set.contains(s)) {
                set.add(s);
                ret.add(Arrays.asList(ii[0], ii[1], ii[2]));
            }

        }

        return ret;
    }

    /**
     * 排序+双指针
     * <p>
     * 为了避免重复,要保证查询到的结果(a,b,c)中a<b<c,自然想到了要对数组进行排序;
     * 三变量维度太高,需要降维.假设a已经确定,则需要在剩下的有序元素中找到 b+c =-a 的元素对;
     * 因为是有序的,使用双指针同时向中间移动的办法可以解决
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        // 排序避免重复
        sort(nums);
        int n = nums.length;

        //遍历所有元素轮流做a
        for (int aIndex = 0; aIndex < n; aIndex++) {
            // a去重
            if (aIndex > 0 && nums[aIndex] == nums[aIndex - 1]) {
                continue;
            }
            List<int[]> ints = twoSum(nums, aIndex + 1, -nums[aIndex]);
            if (!ints.isEmpty()) {
                for (int[] item :
                        ints) {
                    ret.add(Arrays.asList(nums[aIndex], item[0], item[1]));
                }
            }

        }
        return ret;
    }

    private List<int[]> twoSum(int[] nums, int start, int sum) {
        int n = nums.length;
        int cIndex = n - 1;
        List<int[]> ret = new ArrayList<>();
        for (int bIndex = start; bIndex < cIndex; bIndex++) {

            if (bIndex > start && nums[bIndex] == nums[bIndex - 1]) {
                continue;
            }
            while (nums[bIndex] + nums[cIndex] > sum && bIndex < cIndex) {
                cIndex--;
            }
            if (bIndex == cIndex) {
                break;
            }
            if (nums[bIndex] + nums[cIndex] == sum) {
                ret.add(new int[]{nums[bIndex], nums[cIndex]});
            }
        }

        return ret;

    }

    FastSorter fastSorter = new FastSorter();

    private void sort(int[] nums) {
        fastSorter.sort(nums);
    }

    static class FastSorter {

        private Random random = new Random();

        public void sort(int[] nums) {
            if (nums.length < 2) {
                return;
            }

            sort(nums, 0, nums.length - 1);
        }


        private void sort(int[] nums, int l, int r) {
            if (r <= l) {
                return;
            }
            int i = partition(nums, l, r);
            sort(nums, l, i - 1);
            sort(nums, i + 1, r);
        }

        /**
         * 左指针为基准,右指针先移动
         */
        private int partition(int[] nums, int l, int r) {

            int standard = l;
            int leftPoint = l;
            int rightPoint = r;

            while (leftPoint < rightPoint) {

                while (nums[rightPoint] >= nums[standard] && leftPoint < rightPoint) {
                    rightPoint--;
                }
                while (nums[leftPoint] <= nums[standard] && leftPoint < rightPoint) {
                    leftPoint++;
                }

                swap(nums, leftPoint, rightPoint);
            }
            swap(nums, standard, leftPoint);
            return leftPoint;
        }

        private void swap(int[] nums, int i1, int i2) {
            int tmp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = tmp;
        }


    }
}
