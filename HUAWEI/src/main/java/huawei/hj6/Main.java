package org.jwy.huawei.hj6;

import java.util.Scanner;

/**
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5,因为 180 = 2*2*3*3*5 ）
 *
 *
 * 数据范围： 1<= n <= 10^9+14
 * 输入描述：
 * 输入一个整数
 *
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 *
 * 示例1
 * 输入：
 * 180
 *
 * 输出：
 * 2 2 3 3 5
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        printPrimeFactor(l);
    }

    /**
     * 短除法
     *
     */
    private static void printPrimeFactor(long num) {
        long factor = 2;
        while (num != 1) {
            if (num % factor == 0) {
                System.out.print(factor + " ");
                num /= factor;
            } else {
                if (factor > num / factor) {
                    // 如果 factor^2 已经大于目标数,那么下一个因子就是num本身了,避免了使用factor++空转
                    factor = num;
                } else {
                    factor++;
                }
            }
        }
    }


    /**
     *     朴素的算法,当输入是巨大无比的素数,这个方法返回比较慢,超时无法通过测试
     *     线性时间复杂度
     */
    private static void printPrimeFactor1(long num) {
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println();
    }
}
