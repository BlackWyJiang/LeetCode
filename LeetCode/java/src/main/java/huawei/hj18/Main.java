package huawei.hj18;

import java.util.Scanner;

/**
 *描述
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 *
 * 所有的IP地址划分为 A,B,C,D,E五类
 *
 * A类地址从1.0.0.0到126.255.255.255;
 *
 * B类地址从128.0.0.0到191.255.255.255;
 *
 * C类地址从192.0.0.0到223.255.255.255;
 *
 * D类地址从224.0.0.0到239.255.255.255；
 *
 * E类地址从240.0.0.0到255.255.255.255
 *
 *
 * 私网IP范围是：
 *
 * 从10.0.0.0到10.255.255.255
 *
 * 从172.16.0.0到172.31.255.255
 *
 * 从192.168.0.0到192.168.255.255
 *
 *
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * （注意二进制下全是1或者全是0均为非法子网掩码）
 *
 * 注意：
 * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 *
 * 输入描述：
 * 多行字符串。每行一个IP地址和掩码用~隔开。
 *
 * 请参考帖子https://www.nowcoder.com/discuss/276处理循环输入的问题。
 * 输出描述：
 * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 *
 * 示例1
 * 输入：
 * 10.70.44.68~255.254.255.0
 * 1.0.0.1~255.0.0.0
 * 192.168.0.2~255.255.255.0
 * 19..0.~255.255.255.0
 *
 * 输出：
 * 1 0 1 0 0 2 1
 *
 * 说明：
 * 10.70.44.68~255.254.255.0的子网掩码非法，19..0.~255.255.255.0的IP地址非法，所以错误IP地址或错误掩码的计数为2；
 * 1.0.0.1~255.0.0.0是无误的A类地址；
 * 192.168.0.2~255.255.255.0是无误的C类地址且是私有IP；
 * 所以最终的结果为1 0 1 0 0 2 1        
 * 示例2
 * 输入：
 * 0.201.56.50~255.255.111.255
 * 127.201.56.50~255.255.111.255
 *
 * 输出：
 * 0 0 0 0 0 0 0
 *
 * 说明：
 * 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略     
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0, b = 0, c = 0, d = 0, e = 0, err = 0, pri = 0;
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] split = input.split("~");
            if (split.length != 2) {
                err++;
                continue;
            }
            String ip = split[0];
            String mask = split[1];

            int bIp;
            int bMask;
            try {
                bIp = parse(ip);
                bMask = parse(mask);
            } catch (NumberFormatException ex) {
                err++;
                continue;
            }
            // 先排除 127.*.*.* 和 0.*.*.*
            int first = bIp >>> 24;
            if (first == 127 || first == 0) {
                continue;
            }

            if (!checkMask(bMask)) {
                err++;
                continue;
            }
            // 执行到这已经说明格式合法

            if (first <= 126) {
                a++;
                if (first == 10) {
                    pri++;
                }
                continue;
            } else if (first <= 191) {
                b++;
                if (first == 172) {
                    int second = bIp << 8 >>> 24;
                    if (second >= 16 && second <= 31) {
                        pri++;
                    }
                }
                continue;
            } else if (first <= 223) {
                c++;
                if (first == 192) {
                    int second = bIp << 8 >>> 24;
                    if (second == 168) {
                        pri++;
                    }
                }
                continue;

            } else if (first <= 239) {
                d++;
                continue;
            } else {
                e++;
            }

        }

        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + err + " " + pri);


    }

    /**
     * 位运算校验掩码
     */
    private static boolean checkMask(int bMask) {
        return bMask >>> 31 == 1 && bMask << 31 == 0 && (bMask | bMask - 1) == 0b11111111_11111111_11111111_11111111;
    }

    private static int parse(String s) throws NumberFormatException {
        if (s == null) {
            throw new NumberFormatException("null");
        }
        String[] split = s.split("\\.");
        if (split.length != 4) {
            throw new NumberFormatException();
        }
        int first = Integer.parseUnsignedInt(split[0]);
        if (first > 255) {
            throw new NumberFormatException(">255");
        }
        int second = Integer.parseUnsignedInt(split[1]);
        if (second > 255) {
            throw new NumberFormatException(">255");
        }
        int third = Integer.parseUnsignedInt(split[2]);
        if (third > 255) {
            throw new NumberFormatException(">255");
        }
        int fourth = Integer.parseUnsignedInt(split[3]);
        if (fourth > 255) {
            throw new NumberFormatException(">255");
        }
        return first << 24 | second << 16 | third << 8 | fourth;

    }


}
