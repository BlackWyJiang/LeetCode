package hw.hj13;

import java.util.Scanner;
import java.util.Stack;

/**
 * 描述
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 *
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * 数据范围：输入的字符串长度满足 1≤n≤1000
 *
 * 注意本题有多组输入
 * 输入描述：
 * 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
 *
 * 输出描述：
 * 得到逆序的句子
 *
 * 示例1
 * 输入：
 * I am a boy
 *
 * 输出：
 * boy a am I
 *
 * 示例2
 * 输入：
 * nowcoder
 *
 * 输出：
 * nowcoder
 *
 */
public class Main {
    // 翻转类型可以借用栈的数据结构
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        reverseSentence(s);
    }

    // 反转句子
    private static void reverseSentence(String s) {
        Stack<String> stack = new Stack<>();
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            stack.push(s2);
        }

        while (!stack.isEmpty()){
            String s2 = stack.pop();
            System.out.print(s2 + " ");
        }

    }


}
