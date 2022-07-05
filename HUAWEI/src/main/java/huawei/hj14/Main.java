package org.jwy.huawei.hj14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 *
 * 数据范围： 1≤n≤1000  ，字符串长度满足 1≤len≤100
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入：
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 *
 * 输出：
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class Main {
    // 翻转类型可以借用栈的数据结构
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        ArrayList<String> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            list.add(scanner.next());
        }
        for (String s : sort(list)) {
            System.out.println(s);
        }


    }

    // 字典序排序
    private static List<String> sort(List<String> s) {
        s.sort((s1, s2) -> {

            int i = 0;
            while (i < s1.length() && i < s2.length()) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return (s1.charAt(i) > s2.charAt(i)) ? 1 : -1;
                }
                i++;
            }
            if (s1.length() == s2.length()) {
                return 0;
            } else {
                return (s1.length() > s2.length()) ? 1 : -1;
            }
        });
        return s;
    }


}
