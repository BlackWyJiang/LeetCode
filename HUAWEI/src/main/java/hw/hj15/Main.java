package hw.hj15;

import java.util.Scanner;

/**
 *描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 *
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入：
 * 5
 *
 * 输出：
 * 2
 *
 * 示例2
 * 输入：
 * 0
 *
 * 输出：
 * 0
 */
public class Main {
    // 翻转类型可以借用栈的数据结构
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println(findOneNum(num));

    }

    // 位运算
    private static int findOneNum(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }


}
