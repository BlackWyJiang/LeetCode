package huawei.hj5;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 数据范围：保证结果在 1<= n <= 2^31-1
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * 示例1
 * 输入：
 * 0xAA
 *
 * 输出：
 * 170
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().substring(2);
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int currentBit = 0;
            if (c >= '0' && c <= '9') {
                currentBit = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                currentBit = c - 'a' + 10;
            } else if (c >= 'A' && c <= 'F') {
                currentBit = c - 'A' + 10;
            }

            ret += Math.pow(16, str.length() - 1 - i) * currentBit;
        }
        System.out.println(ret);

    }
}
