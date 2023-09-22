package day9;

/**
 * @author MrkWinter
 * @version 1.0
 * 2591. 将钱分给最多的儿童
 * 提示
 * 简单
 * 35
 * 相关企业
 * <p>
 * 给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。
 * <p>
 * 你需要按照如下规则分配：
 * <p>
 * 所有的钱都必须被分配。
 * 每个儿童至少获得 1 美元。
 * 没有人获得 4 美元。
 * <p>
 * 请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：money = 20, children = 3
 * 输出：1
 * 解释：
 * 最多获得 8 美元的儿童数为 1 。一种分配方案为：
 * - 给第一个儿童分配 8 美元。
 * - 给第二个儿童分配 9 美元。
 * - 给第三个儿童分配 3 美元。
 * 没有分配方案能让获得 8 美元的儿童数超过 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：money = 16, children = 2
 * 输出：2
 * 解释：每个儿童都可以获得 8 美元。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= money <= 200
 * 2 <= children <= 30
 */
/*
解题思路:
优先分配8金币给孩子
根据剩余的金币x和孩子n数判断情况
如果 x<n  则返回匹配的孩子数-1
如果 x>=8 且 x>n 接着匹配下一个孩子
当 剩余一个孩子 并且剩余金币为4时 返回n - 1
 */
public class DistMoney {
    public static void main(String[] args) {
        int money = 17, children = 2;
        DistMoney distMoney = new DistMoney();
        int i = distMoney.distMoney(money, children);
        System.out.println(i);
    }

    public int distMoney(int money, int children) {
        if (money < children)
            return -1;
        for (int i = 0; i <= children; i++) {
            if (money < 8) {
                if ((children - i == 1 && money == 4) || money < children - i) {
                    return i - 1;
                }
                return i;
            }
            if (money < children - i) {
                return i - 1;
            }
            if (children - i == 1 && money > 8)
                return i;
            money -= 8;
        }
        return 1;
    }
}
