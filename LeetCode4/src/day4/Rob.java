package day4;

/**
 * @author MrkWinter
 * @version 1.0
 * <p>
 * 213. 打家劫舍 II
 * 提示
 * 中等
 * 1.5K
 * 相关企业
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
/*
解题思路:
仍然采用动态规划算法
使用三个数组
第一个数组fMax保存前n个数的中的窃取最大值
第二个数组fMar保存前n个不包含第一个数的窃取最大值
第三个数组max保存前n个数的窃取最大值 (包括环)
当n = 1时 fMax[0] = nums[0];  fMar不变;  max[0] = nums [1];
当n = 2时 fMax[1] = fMax[0] 与 nums[1]的较大者; fMar[1] = nums[1]; max[1] = max[0] 与 nums[1]的较大者
当n = 3时 fMax[2] = fMax[1] 与 fMar[0] + nums[2]的较大者; fMar[2] = fMar[1] 与nums[2]的较大者;  max[2]  = max[1] 与 max[0] + nums[i] 的较大者

当 n 时 fMax[n-1] = max[n-2] 与 fMar[n-3] + nums[n-1]的较大者; fMar[n-1] = fMar[n-2]  与 fMar[n-3] + fMar[n-1] 的较大者
       max[n-1] = max[n-2] 与 max[n-3] + nums[n-1] 的较大者
由此得出状态转移方程
 */
public class Rob {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {2, 1};
        int[] nums = {94,40,49,65,21,21,106,80,92,81,679,4,61,6,237,12,72,74,29,95,265,35,47,1,61,397,52,72,37,51,1,81,45,435,7,36,57,86,81,72};
        Rob rob = new Rob();
        int rob1 = rob.rob(nums);
        System.out.println(rob1);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] fMax = new int[n];
        int[] fMar = new int[n];
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                max[i] = nums[i];
                fMax[i] = nums[i];
            } else if (i == 1) {
                max[i] = Math.max(max[0], nums[i]);
                fMax[i] = Math.max(fMax[0], nums[i]);
                fMar[i] = nums[i];
            } else if (i == 2) {
                max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
                fMax[i] = Math.max(fMax[i - 1], fMar[i - 2] + nums[i]);
                fMar[i] = Math.max(fMar[1], nums[i]);
            } else {
                max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
                fMax[i] = Math.max(fMar[i - 2] + nums[i], max[i - 1]);
                fMar[i] = Math.max(fMar[i - 1], fMar[i - 2] + nums[i]);
            }
        }
        return fMax[n - 1];
    }
}
