package day7;

/**
 * @author MrkWinter
 * @version 1.0
 * LCP 06. 拿硬币
 * 简单
 * 84
 * 相关企业
 * <p>
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[4,2,1]
 * <p>
 * 输出：4
 * <p>
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,3,10]
 * <p>
 * 输出：8
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 */
public class MinCount {
    public static void main(String[] args) {

    }

    public int minCount(int[] coins) {
        int count = 0;
        for (int x :
                coins) {
            count += (x + 1) / 2;
        }
        return count;
    }
}
