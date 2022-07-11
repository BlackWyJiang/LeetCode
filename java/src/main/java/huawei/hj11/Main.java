package huawei.hj11;

import java.util.Scanner;

/**
 * 描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 数据范围： 0 \le n \le 2^{30}-1 \0≤n≤2 
 * 30
 *  −1 
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入：
 * 1516000
 *
 * 输出：
 * 0006151
 *
 * 示例2
 * 输入：
 * 0
 *
 * 输出：
 * 0
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
    }


}
