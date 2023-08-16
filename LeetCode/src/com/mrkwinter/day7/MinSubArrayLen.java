package com.mrkwinter.day7;

/**
 * @author MrkWinter
 * @version 1.0
 * 209. 长度最小的子数组
 * 中等
 * 1.8K
 * 相关企业
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int i = new MinSubArrayLen().minSubArrayLen(target, arr);
        System.out.println(i);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int numSum = 0;
        int curIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            numSum += nums[i];
            while (numSum >= target && i >= curIndex) {
                if (i - curIndex + 1 < minLen) {
                    minLen = i - curIndex + 1;
                }
                numSum -= nums[curIndex++];
            }
        }
        if (minLen == Integer.MAX_VALUE)
            minLen = 0;
        return minLen;
    }
}
