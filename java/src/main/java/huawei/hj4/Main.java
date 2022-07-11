package huawei.hj4;

import java.util.Scanner;

/**
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * 示例1
 * 输入：
 * abc
 * 复制
 * 输出：
 * abc00000
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int flag = 0;
        for (int i = 0; i +8<= str.length(); i+=8) {
            System.out.println(str.substring(i,i+8));
            flag = i;
        }
        int mod = str.length()%8;
        if (mod == 0){
            return;
        }
        String tail = str.substring(str.length() - mod);
        int pow = (int)Math.pow(10, 8 - mod);
        String supplement = String.valueOf(pow).substring(1);
        String s = tail + supplement;
        System.out.println(s);


    }
}
