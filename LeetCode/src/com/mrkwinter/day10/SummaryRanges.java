package com.mrkwinter.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MrkWinter
 * @version 1.0
 * 228. 汇总区间
 * 简单
 * 276
 * 相关企业
 * <p>
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */
public class SummaryRanges {
    public static void main(String[] args) {
        List<String> strings = new SummaryRanges().summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println(strings);
    }

    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        int j = 0;
        ArrayList<String> strings = new ArrayList<>();
        while (j < nums.length) {
            while (j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                j++;
            }
            if (i == j) {
                strings.add(Integer.toString(nums[i]));
            } else {
                strings.add(nums[i] + "->" + nums[j]);
            }
            i = ++j;
        }
        return strings;
    }
}
