package day6;

import java.util.Arrays;
import java.util.Map;

/**
 * @author MrkWinter
 * @version 1.0
 * 2560. 打家劫舍 IV
 * 提示
 * 中等
 * 81
 * 相关企业
 * <p>
 * 沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 * <p>
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 * <p>
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 * <p>
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 * <p>
 * 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 * <p>
 * 返回小偷的 最小 窃取能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,5,9], k = 2
 * 输出：5
 * 解释：
 * 小偷窃取至少 2 间房屋，共有 3 种方式：
 * - 窃取下标 0 和 2 处的房屋，窃取能力为 max(nums[0], nums[2]) = 5 。
 * - 窃取下标 0 和 3 处的房屋，窃取能力为 max(nums[0], nums[3]) = 9 。
 * - 窃取下标 1 和 3 处的房屋，窃取能力为 max(nums[1], nums[3]) = 9 。
 * 因此，返回 min(5, 9, 9) = 5 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,7,9,3,1], k = 2
 * 输出：2
 * 解释：共有 7 种窃取方式。窃取能力最小的情况所对应的方式是窃取下标 0 和 4 处的房屋。返回 max(nums[0], nums[4]) = 2 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= (nums.length + 1)/2
 */
/*
解题思路
寻找窃取k个房间中的最小窃取数  该窃取数应在所给数组的最小值和最大值中间
找到所有满足窃取房间个数中具有窃取最小值的数即可
使用二分查找 循环尝试可能成功的最小窃取数 遍历数组 如果找到所有不相邻的小于最小窃取数的个数
如果个数大于等于k 则该窃取数成立 尝试更小的窃取数 如果窃取数不成立 尝试更大的窃取数


一次遍历得到最大count 早抢原则 给后面抢夺留给了更大可能 优先抢夺能得到最大count值
二分查找最后的结果一定在nums数组中 如果value 符合 k的条件 但不在数组中 那么value - 1 一定在数组
且满足k条件 所以二分查找的结果一定在数组中
 */
public class MinCapability {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 9};
        int k = 2;
        int i = new MinCapability().minCapability(nums, k);
        System.out.println(i);
    }

    public int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();
        while (lower <= high) { //=保证二分查找得出的结果一定在nums中
            int middle = (lower + high) / 2;
            int count = 0;
            boolean flag = true;
            for (int x : nums) {
                if (x <= middle && flag) {
                    flag = false;
                    count++;
                } else {
                    flag = true;
                }
            }
            if (count >= k)
                high = middle - 1;
            else
                lower = middle + 1;
        }
        return lower;
    }
}
