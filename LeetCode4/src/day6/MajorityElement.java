package day6;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 169. 多数元素
 * 简单
 * 2K
 * 相关企业
 * <p>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
/*
解题思路
排序 + 双指针
 */
public class MajorityElement {
    public static void main(String[] args) {
        int i = new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1});
        System.out.println(i);
    }

    public int majorityElement1(int[] nums) {
        //发现出现最多的数字
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int j = 0;
        int maxCount = Integer.MIN_VALUE;
        int ret = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[j]) {
                continue;
            }
            if (maxCount < i - j) {
                maxCount = i - j;
                ret = nums[j];
            }
            j = i;
        }
        return ret;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[j]) {
                continue;
            }
            if (n / 2 < i - j) {
                break;
            }
            j = i;
        }
        return nums[j];
    }

    //使用摩尔投票算法
    public int majorityElement(int[] nums) {
        int curNum = nums[0];
        int count = 0;
        for (int x : nums) {
            if (x == curNum)
                count++;
            else {
                if (count == 0) {
                    curNum = x;
                    count++;
                } else {
                    count--;
                }
            }
        }
        return curNum;
    }
}
