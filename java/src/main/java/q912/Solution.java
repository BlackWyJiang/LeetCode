package q912;

import java.util.Random;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 */
public class Solution {
    public int[] sortArray(int[] nums) {

//        new FastSort().sort(nums);
//        new HeapSort().sort(nums);
        new MergeSort().sort(nums);
        return nums;
    }


}

/**
 * 快速排序
 * <p>
 * 基于随机选取主元的快速排序时间复杂度为期望 时间复杂度：O(nlogn) 最差为 O(n^2)
 * 空间复杂度：O(h),h为递归的层数,所以最差情况(partition都是边界)为O(n),最优情况(刚好两等分)为O(logn)
 */
class FastSort {
    private Random random = new Random();

    public void sort(int[] nums) {
        randomSort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        //找到一个值 并且返回这个值的index 使左边小于这个值,右边大于这个值
        int partition = partition(nums, start, end);
        sort(nums, start, partition - 1);
        sort(nums, partition + 1, end);

    }

    public void randomSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        //在start-end中随机一个值和 start 交换
        int randIndex = start + random.nextInt(end - start);
        exchange(nums, start, randIndex);
        //找到一个值 并且返回这个值的index 使左边小于这个值,右边大于这个值
        int partition = partition(nums, start, end);
        randomSort(nums, start, partition - 1);
        randomSort(nums, partition + 1, end);

    }

    private int partition(int[] nums, int start, int end) {

        int standard = start;

        int leftPoint = start;
        int rightPoint = end;

        while (leftPoint != rightPoint) {

            while (rightPoint != leftPoint && nums[rightPoint] >= nums[standard]) {
                rightPoint--;
            }

            while (rightPoint != leftPoint && nums[leftPoint] <= nums[standard]) {
                leftPoint++;
            }
            exchange(nums, leftPoint, rightPoint);

        }
        exchange(nums, standard, leftPoint);
        return leftPoint;

    }


    private void exchange(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}

/**
 * 堆排序
 * <p>
 * 将目标数组建成最大堆,这样就可以保证堆尖的元素一定是最大的,然后将堆尖上的元素依次换到最后面,直到换完,数组就是有序的了
 * 反之如果降序排序只需要建最小堆即可
 * <p>
 * * 时间复杂度：O(nlogn)
 * * 空间复杂度：O(1)
 */
class HeapSort {
    private int size = 0;

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        //建堆
        buildHeap(nums);

        while (size > 1) {
            exchange(nums, 0, size - 1);
            size--;
            maxHeap(nums, 0);
        }


    }

    private void buildHeap(int[] nums) {

        size = nums.length;
        //此处为什么是 size / 2 -1 ?
        //          0
        //       1     2
        //     3   4 5   6
        // 因为 size/2 到 结尾的为叶子节点,在对他们的父节点做平衡的时候已经做过了,maxHeap方法内
        //此处一定是从下至上进行上浮.
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeap(nums, i);
        }

    }

    /**
     * 此方法保证了最大堆属性,即 父节点 大于等于子节点即可
     * <p>
     * //             0
     * //          1     2
     * //        3   4 5   6
     */
    private void maxHeap(int[] nums, int index) {
        int leftChild = index * 2 + 1;
        int max = index;

        if (leftChild < size) {
            max = nums[max] >= nums[leftChild] ? max : leftChild;

            int rightChild = index * 2 + 2;
            if (rightChild < size) {
                max = nums[max] >= nums[rightChild] ? max : rightChild;
            }
        }


        if (max != index) {
            exchange(nums, index, max);
            maxHeap(nums, max);
        }

    }

    private void exchange(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}

/**
 * 归并排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
class MergeSort {

    private int[] tmp;

    public void sort(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            //递归的返回条件, 相当于被分割为单个数组时候,开始做回归
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        //此时mid 左边也是有序的 ,mid右边也是有序的, 把左边和右边合并成一个完整有序的
        for (int i = start; i <= end; i++) {
            tmp[i] = nums[i];
        }

        int leftPoint = start;
        int rightPoint = mid + 1;


        for (int i = start; i <= end; i++) {

            if (leftPoint > mid) {
                nums[i] = tmp[rightPoint++];
                continue;
            }

            if (rightPoint > end) {
                nums[i] = tmp[leftPoint++];
                continue;
            }

            if (tmp[leftPoint] > tmp[rightPoint]) {
                nums[i] = tmp[rightPoint++];
            } else {
                nums[i] = tmp[leftPoint++];
            }

        }


    }
}

/**
 * 桶排序
 */
class BucketSort {
    public void sort(int nums) {

        //todo
    }
}