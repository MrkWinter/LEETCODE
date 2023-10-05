package day3;

/**
 * @author MrkWinter
 * @version 1.0
 * 309. 买卖股票的最佳时机含冷冻期
 * 中等
 * 1.6K
 * 相关企业
 * <p>
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 示例 2:
 * <p>
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
/*
思路:
用三个数组表示每天在一种状态下的最大利润
手中有一只股票
手中无股票 处于冷却期
手中无股票 不属于冷却期
 */
public class MaxProfit {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] max = new int[len][3];
        max[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            max[i][0] = Math.max(max[i - 1][2] - prices[i], max[i - 1][0]);
            max[i][1] = max[i - 1][0] + prices[i - 1];
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]);
        }
        return Math.max(max[len - 1][1], max[len - 1][2]);
    }
}
