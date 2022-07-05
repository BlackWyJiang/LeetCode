package q215;

import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 先排序 然后取排序后的的第 k 个元素
     * 使用快速排序实现
     * <p>
     * 执行用时：
     * 34 ms, 在所有 Java 提交中击败了 10.71%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了6.39%的用户
     * 通过测试用例：
     * 32 / 32
     * <p>
     * 快速排序的
     * * 数学期望时间复杂度为 O(nlogn)
     * * 最坏时间复杂度为 O(n^2)
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        new FastSorter().sort(nums);
        return nums[nums.length - k];

    }

    /**
     * 基于堆排序实现
     * <p>
     * 此处不必完全排序,只需要排序前 k-1 个元素即可,利用了堆排序的过程
     * <p>
     * * 数学期望时间复杂度为 O(nlogn)
     * * 最坏时间复杂度为 O(nlogn)
     * <p>
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 83.30%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 37.18%
     * 的用户
     * 通过测试用例：
     * 32 / 32
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        return new HeapSorter().getMaxKNode(nums, k);
    }

    /**
     * 衍生于快速排序的快速选择
     * <p>
     * <p>
     * 数学期望时间复杂度为 O(n)
     * 最坏时间复杂度为 O(n^2)
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        return new FastSorter().fastSelect1(nums, 0, nums.length - 1, nums.length - k+1);

    }


}

/**
 * 堆排序实现
 */
class HeapSorter {
    private int heapSize = 0;

    public void sort(int[] nums) {
        //构建堆
        buildHeap(nums);
        //依次删除堆顶节点,直至最末节点的前一个节点
        while (heapSize != 1) {
            exchange(nums, 0, heapSize - 1);
            heapSize--;
            maxHeapIfy(nums, 0);
        }

    }

    /**
     * 获取第k大的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int getMaxKNode(int[] nums, int k) {
        //构建堆
        buildHeap(nums);

        //获取第k大的元素,则只需要 k-1 次交换后,堆尖即为第 k 大元素
        for (int i = 0; i < k - 1; i++) {
            exchange(nums, 0, heapSize - 1);
            heapSize--;
            maxHeapIfy(nums, 0);
        }
        return nums[0];
    }


    //构建堆
    //      a
    //     / \
    //    a   a
    //   /\   /\
    //  a  a a  a
    // 定理: 当用数组表示一个 n 个节点的堆时,叶子节点的下标为 n/2+1 到 n-1

    /**
     * 构建堆
     * 0
     * / \
     * 1   2
     * /\   /\
     * 3 4 5  6
     * 定理: 当用数组表示一个 n 个节点的堆时,叶子节点的下标为 n/2+1 到 n-1.
     * 换句话说,父亲节点下标为 0 到 n/2
     *
     * @param nums
     */
    private void buildHeap(int[] nums) {
        heapSize = nums.length;
        int lastParent = nums.length / 2;

        while (lastParent >= 0) {
            maxHeapIfy(nums, lastParent--);
        }


    }

    /**
     * 堆中的第 i 个节点的子节点 左边为 2i+1 右边为2i+2
     *
     * @param nums
     * @param i
     */
    private void maxHeapIfy(int[] nums, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largestIndex = i;
        if (left < heapSize && nums[left] > nums[largestIndex]) {
            largestIndex = left;
        }
        if (right < heapSize && nums[right] > nums[largestIndex]) {
            largestIndex = right;
        }
        //找出 i 节点 和他的子节点中最大的那个,如果最大的不是i节点,则交换i节点和那个最大的,并且递归被交换的节点
        if (largestIndex != i) {
            exchange(nums, i, largestIndex);
            maxHeapIfy(nums, largestIndex);
        }

    }

    /**
     * 交换数组中两个索引的位置
     *
     * @param nums
     * @param index1
     * @param index2
     */
    private void exchange(int[] nums, int index1, int index2) {

        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

}

/**
 * 快速排序实现
 */
class FastSorter {
    private Random random = new Random();


    /**
     * 快速排序
     *
     * @param nums
     */
    public void sort(int[] nums) {

        _sort(nums, 0, nums.length - 1);

    }

    private void _sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
//        int partition = partition(nums, start, end);
        int partition = randomizedPartition(nums, start, end);
        _sort(nums, start, partition - 1);
        _sort(nums, partition + 1, end);
    }

    /**
     * 快速选择算法
     * * 快速排序大致思想为: 将数组分割成 大于某个值的一块 和 小于某个值的一块 递归重复处理这两块,不断的找到这两块的分割点
     * * 对于此案例可以应用其思想,只需要找到以 第k个 元素为分割点的时候,已经达到目标,至于 分割点两边是否有序则不再关心
     * * 所以只需要处理第k个元素所在的那一块即可.
     * *
     * * 在此处曾经有个疑问,会不会出现排完了,都不会出现"以 第k个 元素为分割点"的情况,其实不会的,快速排序的每次切割本质上是确定切割点
     * * 所在的排序后的位置,所以 "第k个元素"在整个过程中肯定会出现在切割点
     *
     * @param nums
     * @param start
     * @param end
     * @param k
     * @return
     */
    public int fastSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int partition = randomizedPartition(nums, start, end);
        if (partition == k) {
            return nums[partition];
        } else if (partition > k) {
            return fastSelect(nums, start, partition - 1, k);

        } else {
            return fastSelect(nums, partition + 1, end, k);
        }

    }

    /**
     * 这种快速选择会更容易理解和解释,来源于算法导论
     *
     * @param nums
     * @param start
     * @param end
     * @param k
     * @return
     */
    public int fastSelect1(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int partition = randomizedPartition(nums, start, end);

        //第几个
        int order = partition - start + 1;
        if (order == k) {
            //如果刚好是第k个直接返回
            return nums[partition];
        } else if (order > k) {
            //在0-order中找第k个
            return fastSelect1(nums, start, partition - 1, k);
        } else {
            //在已经找到了order个比k小的,在右边再找k-order个
            return fastSelect1(nums, partition + 1, end, k - order);
        }

    }

    /**
     * 增加随机性,降低出现最差情况下的概率
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int randomizedPartition(int[] nums, int start, int end) {
        int bound = end - start + 1;
        int r = random.nextInt(bound);

        exchange(nums, end, start + r);
        return partition(nums, start, end);

    }

    /**
     * 寻找切分点 start - end 的分割点
     *
     * @return
     */
    private int partition(int[] nums, int start, int end) {

        //算法导论实现方式
        int x = nums[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (nums[j] <= x) {
                i++;
                exchange(nums, i, j);
            }

        }
        exchange(nums, i + 1, end);
        return i + 1;


       /* int standard = nums[start];
        int left = start, right = end;
        while (left < right) {

            *//*
         * 很神奇的现象,下面两个 while块 交换位置后就出现错误
         *
         * 究其原因:是因为基准值是取得最左边,最后要吧 找到的 i 的值 与最左边值进行交换,
         * 如果换了顺序,i 的值 有可能大于 基准值,再做交换就会出现问题,
         *
         *
         *//*

            while (left < right && nums[right] >= standard) {
                right--;
            }
            while (left < right && nums[left] <= standard) {
                left++;
            }


            if (left < right) {
                exchange(nums, left, right);
            }

        }
        exchange(nums, left, start);
        return left;*/

       /*
       网上搜的
        int key = nums[start];
        int i = start, j = end;
        while (i < j) {
            while (nums[j]>=key && i<j){
                j--;
            }
            while(nums[i]<=key && i<j){
                i++;
            }

            if (i<j){
                exchange(nums,i,j);
            }
        }
        exchange(nums,i,start);

        return i;
        */

    }

    /**
     * 交换数组中两个索引的位置
     *
     * @param nums
     * @param index1
     * @param index2
     */
    private void exchange(int[] nums, int index1, int index2) {

        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}