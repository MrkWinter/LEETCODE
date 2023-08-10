package com.mrkwinter.day1;

/**
 * @author MrkWinter
 * @version 1.0
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 */
public class SubtractProductAndSum {
    public static void main(String[] args) {
        int num = 1243;
        System.out.println(subtractProductAndSum(1234));
    }

    public static int subtractProductAndSum(int n) {
        int temp = n;
        int add = 0;
        int sum = temp % 10;
        //求数字之和
        for (int i = 0; ; i++) {
            if (temp / (int)(Math.pow(10, i)) == 0)
                break;
            add += temp / (int)(Math.pow(10, i)) % 10;
        }
        for (int i = 1; ; i++) {
            if (temp / (int)(Math.pow(10, i)) == 0)
                break;
            sum *= temp / (int)(Math.pow(10, i)) % 10;
        }
        return sum - add;
    }
}
