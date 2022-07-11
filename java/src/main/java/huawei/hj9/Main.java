package huawei.hj9;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 *
 * 数据范围： 1 \le n \le 10^{8} \1≤n≤10 
 * 8
 *
 * 输入描述：
 * 输入一个int型整数
 *
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入：
 * 9876673
 *
 * 输出：
 * 37689
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        System.out.println(reverseNum(num));
    }

    private static long reverseNum(long num) {
        if (num < 10) {
            return num;
        }
        LinkedHashSet<Long> set = new LinkedHashSet<>();

        while (num/10>0){
            set.add(num%10);
            num/=10;
        }
        set.add(num);

        long ret = 0;
        int currentBit = set.size();
        for (Long currentNum : set) {
            ret += ((long) Math.pow(10, currentBit - 1)) * currentNum;
            currentBit--;
        }
        return ret;
    }


}
