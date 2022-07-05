package org.jwy.huawei.hj23;

import java.util.Scanner;

/**
 *
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足 1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入：
 * aabcddd
 *
 * 输出：
 * aaddd
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(deleteMinChar(input));

        }
    }

    private static String deleteMinChar(String input) {
        int[] array = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int index = c - 'a';
            array[index] = array[index] + 1;
        }
        int min = Integer.MAX_VALUE;
        for (int num : array) {
            if (num == 0) {
                continue;
            }
            if (num < min) {
                min = num;
            }
        }

        int i = 0;
        char[] chars = new char[input.length()];
        for (char c : input.toCharArray()) {
            int index = c - 'a';
            if (array[index] == min) {
                continue;
            }
            chars[i] = c;
            i++;
        }
        return String.valueOf(chars, 0, i);

    }


}
