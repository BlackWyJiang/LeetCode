package hw.hj16;

import java.util.Scanner;

/**
 *描述
 * 王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件，且每件物品只能购买一次。
 * 每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。
 * 王强查到了每件物品的价格（都是 10 元的整数倍），而他只有 N 元的预算。除此之外，他给每件物品规定了一个重要度，用整数 1 ~ 5 表示。他希望在花费不超过 N 元的前提下，使自己的满意度达到最大。
 * 满意度是指所购买的每件物品的价格与重要度的乘积的总和，假设设第i件物品的价格为v[i]，重要度为w[i]，共选中了kk件物品，编号依次为j_1,j_2,...,j_k.
 * 则满意度为：v[j_1]*w[j_1]+v[j_2]*w[j_2]+ … +v[j_k]*w[j_k].（其中 * 为乘号）
 * 请你帮助王强计算可获得的最大的满意度。
 *
 *
 * 输入描述：
 * 输入的第 1 行，为两个正整数N，m，用一个空格隔开：
 *
 * （其中 N （ N<32000 ）表示总钱数， m （m <60 ）为可购买的物品的个数。）
 *
 *
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 *
 *
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 *
 *
 *
 *
 * 输出描述：
 *  输出一个正整数，为张强可以获得的最大的满意度。
 * 示例1
 * 输入：
 * 1000 5
 * 800 2 0
 * 400 5 1
 * 300 5 1
 * 400 3 0
 * 500 2 0
 *
 * 输出：
 * 2200
 *
 * 示例2
 * 输入：
 * 50 5
 * 20 3 5
 * 20 3 5
 * 10 3 0
 * 10 2 0
 * 10 1 0
 *
 * 输出：
 * 130
 *
 * 说明：
 * 由第1行可知总钱数N为50以及希望购买的物品个数m为5；
 * 第2和第3行的q为5，说明它们都是编号为5的物品的附件；
 * 第4~6行的q都为0，说明它们都是主件，它们的编号依次为3~5；
 * 所以物品的价格与重要度乘积的总和的最大值为10*1+20*3+20*3=130   
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalMoney = scanner.nextInt();
        int goodsCount = scanner.nextInt();


        Good[] goods = new Good[goodsCount];


        for (int i = 1; i <= goodsCount; i++) {
            int price = scanner.nextInt();
            int importance = scanner.nextInt();
            int mainNo = scanner.nextInt();
            Good good = new Good(i, price, importance, mainNo);
            goods[i - 1] = good;

        }
        for (Good good : goods) {
            if (!good.isMain()) {
                Good mainGood = goods[good.mainNo - 1];
                if (mainGood.appendix1 == 0) {
                    mainGood.appendix1 = good.no;
                } else if (mainGood.appendix2 == 0) {
                    mainGood.appendix2 = good.no;
                }
            }
        }

        System.out.println(getMaxImpantance(totalMoney, goods));


    }

    /**
     * 优化空间
     * org.jwy.huawei.hj16.Main#getMaxImpantance1(int, org.jwy.huawei.hj16.Main.Good[])
     * 上面方法中用了二维数组来来存储dp
     * 而实际上j那个维度只用到了 j-1,所以j那一列不用全部存,只需要一列存 j-1 即可
     * 可优化为下面这种情况
     */
    private static int getMaxImpantance(int totalMoney, Good[] goods) {
        // TODO: 2022/6/17
        return 0;
    }

    /**
     * 最朴素的 dp
     * @param totalMoney
     * @param goods
     * @return
     */
    private static int getMaxImpantance1(int totalMoney, Good[] goods) {
        int[][] dp = new int[totalMoney + 1][goods.length + 1];
        for (int i = 1; i <= totalMoney; i++) {
            for (int j = 1; j <= goods.length; j++) {
                Good good = goods[j - 1];
                if (!good.isMain()) {
                    // 不是主商品无法单独购买
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                int importance0, importance1, importance2 = 0, importance3 = 0, importance4 = 0;
                // 如果不取当前商品
                importance0 = dp[i][j - 1];
                // 只买主商品
                if (i - good.price < 0) {
                    // 价格小于商品价格
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                importance1 = dp[i - good.price][j - 1] + good.importance * good.price;

                // 买主商品和附件1
                if (good.appendix1 != 0) {
                    // 附件1存在
                    Good appendix1 = goods[good.appendix1 - 1];
                    // 价格足够买主商品和附件1
                    if (i - good.price - appendix1.price >= 0) {
                        importance2 = dp[i - good.price - appendix1.price][j - 1] + good.importance * good.price + appendix1.importance * appendix1.price;
                    }
                }
                // 买主商品和附件2
                if (good.appendix2 != 0) {
                    // 附件1存在
                    Good appendix2 = goods[good.appendix2 - 1];
                    // 价格足够买主商品和附件1
                    if (i - good.price - appendix2.price >= 0) {
                        importance3 = dp[i - good.price - appendix2.price][j - 1] + good.importance * good.price + appendix2.importance * appendix2.price;
                    }
                }

                // 买主商品和附件1 2
                if (good.appendix1 != 0 && good.appendix2 != 0) {
                    // 附件1存在
                    Good appendix1 = goods[good.appendix1 - 1];
                    Good appendix2 = goods[good.appendix2 - 1];
                    // 价格足够买主商品和附件1和附件2
                    if (i - good.price - appendix1.price - appendix2.price >= 0) {
                        importance4 = dp[i - good.price - appendix1.price - appendix2.price][j - 1] + good.importance * good.price + appendix1.importance * appendix1.price + appendix2.importance * appendix2.price;
                    }
                }


                dp[i][j] = max(importance0, importance1, importance2, importance3, importance4);
            }
        }
//        print(dp);

        return dp[totalMoney][goods.length];

    }

    private static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            int[] ints = dp[i];
            if (i == 0) {

                System.out.print(" : ");
                for (int i1 = 0; i1 < ints.length; i1++) {
                    System.out.print(i1 + "\t");
                }
                System.out.println();
            }
            System.out.print(i + ": ");
            for (int i1 = 0; i1 < ints.length; i1++) {
                System.out.print(ints[i1] + "\t");
            }
            System.out.println();
        }
    }

    private static int max(int... nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }


    public static class Good {
        // 编号,从 1 开始
        public int no;
        // 价格
        public int price;
        // 重要度
        public int importance;
        // q=0代表主件,否则代表所属主件的编号
        public int mainNo;

        // 附属品1
        public int appendix1;
        // 附属品2
        public int appendix2;

        public Good(int no, int price, int importance, int mainNo) {
            this.no = no;
            this.price = price;
            this.importance = importance;
            this.mainNo = mainNo;
        }

        public boolean isMain() {
            return mainNo == 0;
        }

    }


}
