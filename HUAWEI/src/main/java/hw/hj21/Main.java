package hw.hj21;

import java.util.Scanner;

/**
 * 描述
 * 现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足 1≤n≤100
 * 输入描述：
 * 输入一组密码，长度不超过100个字符。
 *
 * 输出描述：
 * 输出密码变换后的字符串
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            String transfer = transfer(input);
            System.out.println(transfer);

        }


    }

    private static String transfer(String input) {
        char[] chars = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            chars[i] = transfer(c);
        }
        return String.valueOf(chars);
    }

    private static char transfer(char c) {
        if (c >= 'a' && c <= 'z') {
            int ret = transfer2Nine(c);
            return (char) (ret + 49);
        }
        if (c >= 'A' && c <= 'Z') {
            c = toLower(c);
            c = next(c);
        }
        return c;
    }

    private static char next(char c) {
        if ('z' == c) {
            return 'a';
        }
        return ++c;
    }

    /**
     * 大写转小写并且后移一位
     * @param c
     * @return
     */
    private static char toLower(char c) {

        return (char) (c + 32);
    }

    /**
     * 转换九宫格输入法
     * @param c
     * @return
     */
    private static int transfer2Nine(char c) {
        int dif = c - 'a';
        if (dif >= 15 && dif < 19) {
            return 6;
        }
        if (dif >= 19 && dif < 22) {
            return 7;
        }
        if (dif >= 23) {
            return 8;
        }
        int ret = dif / 3;
        return ret + 1;
    }


}
