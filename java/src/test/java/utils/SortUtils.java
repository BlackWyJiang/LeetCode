package utils;

/**
 * 测试是否有序工具
 */
public class SortUtils {

    public static boolean isAscSorted(Comparable[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }

        Comparable pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(pre) < 0) {
                return false;
            }
            pre=arr[i];
        }
        return true;
    }

    public static boolean isDescSorted(Comparable[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }

        Comparable pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(pre) > 0) {
                return false;
            }
            pre=arr[i];
        }
        return true;
    }
}
