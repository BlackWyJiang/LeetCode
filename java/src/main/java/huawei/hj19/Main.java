package huawei.hj19;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Scanner;

/**
 *描述
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *
 *
 * 处理：
 *
 *
 * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。
 *     最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是“相同”的错误记录。
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
 * 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
 *
 * 数据范围：错误记录数量满足 1≤n≤100  ，每条记录长度满足 1≤len≤100
 * 输入描述：
 * 每组只包含一个测试用例。一个测试用例包含一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 * 输出描述：
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 *
 * 示例1
 * 输入：
 * D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
 * E:\je\rzuwnjvnuz 633
 * C:\km\tgjwpb\gy\atl 637
 * F:\weioj\hadd\connsh\rwyfvzsopsuiqjnr 647
 * E:\ns\mfwj\wqkoki\eez 648
 * D:\cfmwafhhgeyawnool 649
 * E:\czt\opwip\osnll\c 637
 * G:\nt\f 633
 * F:\fop\ywzqaop 631
 * F:\yay\jc\ywzqaop 631
 * D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645
 *
 * 输出：
 * rzuwnjvnuz 633 1
 * atl 637 1
 * rwyfvzsopsuiqjnr 647 1
 * eez 648 1
 * fmwafhhgeyawnool 649 1
 * c 637 1
 * f 633 1
 * ywzqaop 631 2
 *
 * 说明：
 * 由于D:\cfmwafhhgeyawnool 649的文件名长度超过了16个字符，达到了17，所以第一个字符'c'应该被忽略。
 * 记录F:\fop\ywzqaop 631和F:\yay\jc\ywzqaop 631由于文件名和行号相同，因此被视为同一个错误记录，哪怕它们的路径是不同的。
 * 由于循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准，所以D:\zwtymj\xccb\ljj\cqzlyaszjvlsjmkwoqijggmybr 645不会被记录。       
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        CircularList<String> circularList = new CircularList<>(String.class, 8);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] s = input.split(" ");
            int i = s[0].lastIndexOf('\\');
            String fileName = s[0].substring(i + 1);
            fileName = fileName.length() > 16 ? fileName.substring(fileName.length() - 16) : fileName;
            String lineNum = s[1];
            String key = fileName.concat(" ").concat(lineNum);
            Integer count = map.get(key);
            if (count != null) {
                map.put(key, count + 1);
            } else {
                map.put(key, 1);
                circularList.write(key);
            }
        }
        while (circularList.readable()) {
            String key = circularList.read();
            System.out.println(key.concat(" ").concat(String.valueOf(map.get(key))));
        }


    }


    /**
     * 环形链表
     * @param <T>
     */
    public static class CircularList<T> {
        private final T[] arr;
        private transient int rIndex = -1;
        private transient int wIndex = 0;

        @SuppressWarnings("unchecked")
        public CircularList(Class<? extends T> clazz, int size) {
            this.arr = (T[]) Array.newInstance(clazz, size);
        }


        private void write(T value) {
            arr[wIndex] = value;
            if (rIndex == -1) {
                rIndex = wIndex;
            } else if (wIndex == rIndex) {
                rIndex = plusRIndex();
            }

            wIndex = plusWIndex();
        }

        private T read() {
            T value = arr[rIndex];
            if (plusRIndex() == wIndex) {
                rIndex = -1;
            } else {
                rIndex = plusRIndex();
            }

            return value;
        }

        private boolean readable() {
            return rIndex != -1;
        }

        private int plusRIndex() {
            if (rIndex == arr.length - 1) {
                return 0;
            } else {
                return rIndex + 1;
            }
        }

        private int plusWIndex() {
            if (wIndex == arr.length - 1) {
                return 0;
            } else {
                return wIndex + 1;
            }
        }
    }


}
