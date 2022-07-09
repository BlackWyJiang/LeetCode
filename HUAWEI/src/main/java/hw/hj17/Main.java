package hw.hj17;

import java.util.Scanner;

/**
 *
 * 描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * 下面是一个简单的例子 如：
 *
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *
 * 处理过程：
 *
 * 起点（0,0）
 *
 * +   A10   =  （-10,0）
 *
 * +   S20   =  (-10,-20)
 *
 * +   W10  =  (-10,-10)
 *
 * +   D30  =  (20,-10)
 *
 * +   x    =  无效
 *
 * +   A1A   =  无效
 *
 * +   B10A11   =  无效
 *
 * +  一个空 不影响
 *
 * +   A10  =  (10,-10)
 *
 * 结果 （10， -10）
 *
 * 数据范围：每组输入的字符串长度满足 1≤n≤10000  ，坐标保证满足 -2^{31} <= x,y <= 2^{31}-1
 * 且数字部分仅含正数
 * 输入描述：
 * 一行字符串
 *
 * 输出描述：
 * 最终坐标，以逗号分隔
 *
 * 示例1
 * 输入：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *
 * 输出：
 * 10,-10
 *
 * 示例2
 * 输入：
 * ABC;AKL;DA1;
 *
 * 输出：
 * 0,0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] split = input.split(";");

        Coord coord = new Coord(0, 0);
        for (String s : split) {
            Removable removable = parse(s);
            if (removable == null) {
                continue;
            }
            removable.move(coord);
        }

        System.out.println(coord.x + "," + coord.y);

    }

    /**
     *  检查每个输入的正确性
     */
    private static Removable parse(String s) {

        if (s == null || s.length() < 2) {
            return null;
        }
        char c = s.charAt(0);

        if (c == 'A') {
            int offset;
            try {
                offset = Integer.parseInt(s.substring(1));
            } catch (NumberFormatException e) {
                return null;
            }
            return new A(offset);
        }

        if (c == 'D') {
            int offset;
            try {
                offset = Integer.parseInt(s.substring(1));
            } catch (NumberFormatException e) {
                return null;
            }
            return new D(offset);
        }
        if (c == 'W') {
            int offset;
            try {
                offset = Integer.parseInt(s.substring(1));
            } catch (NumberFormatException e) {
                return null;
            }
            return new W(offset);
        }
        if (c == 'S') {
            int offset;
            try {
                offset = Integer.parseInt(s.substring(1));
            } catch (NumberFormatException e) {
                return null;
            }
            return new S(offset);
        }

        return null;
    }

    private static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static interface Removable {
        void move(Coord coord);
    }

    private static class A implements Removable {
        int offset;

        public A(int offset) {
            this.offset = offset;
        }

        @Override
        public void move(Coord coord) {
            coord.x -= offset;
        }
    }

    private static class D implements Removable {
        int offset;

        public D(int offset) {
            this.offset = offset;
        }

        @Override
        public void move(Coord coord) {
            coord.x += offset;
        }
    }

    private static class W implements Removable {
        int offset;

        public W(int offset) {
            this.offset = offset;
        }

        @Override
        public void move(Coord coord) {
            coord.y += offset;
        }
    }

    private static class S implements Removable {
        int offset;

        public S(int offset) {
            this.offset = offset;
        }

        @Override
        public void move(Coord coord) {
            coord.y -= offset;
        }
    }


}
