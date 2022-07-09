package hw.hj20;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 描述
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 *
 * 数据范围：输入的字符串长度满足 1≤n≤100
 * 输入描述：
 * 一组字符串。
 *
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 *
 * 输出：
 * OK
 * NG
 * NG
 * OK
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (check(input)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }

        }


    }

    private static boolean check(String input) {
        if (input.length() < 8) {
            return false;
        }
        boolean upper = false;
        boolean lower = false;
        boolean number = false;
        boolean symbol = false;
        int n = 0;
        HashSet<String> subSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!upper && c >= 'A' && c <= 'Z') {
                upper = true;
                n++;
            }
            if (!lower && c >= 'a' && c <= 'z') {
                lower = true;
                n++;
            }
            if (!number && c >= '0' && c <= '9') {
                number = true;
                n++;
            }
            if (!symbol
                    && !(c >= 'A' && c <= 'Z')
                    && !(c >= 'a' && c <= 'z')
                    && !(c >= '0' && c <= '9')
            ) {
                symbol = true;
                n++;
            }
            if (i > 1) {

                String sub = input.substring(i - 2, i + 1);
                if (subSet.contains(sub)) {
                    return false;
                }
                subSet.add(sub);
            }
        }
        return n > 2;

    }


}
