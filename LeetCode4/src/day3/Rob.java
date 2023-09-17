package day3;

/**
 * @author MrkWinter
 * @version 1.0
 * 198. 打家劫舍
 * 中等
 * 2.8K
 * 相关企业
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */

/*
解题思路
使用动态规划算法求解

1. 当nums长度为1 时 取前1个值的窃取最大值 即 max[0] = nums[0]
2. 当nums长度为2 时 取前2个值的窃取最大值 即 max[1] = max[0] 与 nums[1] 较大者
3. 当nums长度为3 时 取前3个值的窃取最大值 即 max[2] = max[1] 与 max[0] + nums[2] 较大者
4. 当nums长度为n 时 取前n个值的窃取最大值 即 max[n-1] = max[n-2] 与 max[n-3] + num[n-1] 的较大者
由上可得出该动态规划的状态转移方程

 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        Rob rob = new Rob();
        int rob1 = rob.rob(nums);
        System.out.println(rob1);
    }

    public int rob(int[] nums) {
        int len = nums.length;
        int[] fMax = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0)
                fMax[i] = nums[i];
            else if (i == 1)
                fMax[i] = Math.max(fMax[0], nums[i]);
            else {
                fMax[i] = Math.max(fMax[i - 1], fMax[i - 2] + nums[i]);
            }
        }
        return fMax[len - 1];
    }
}
