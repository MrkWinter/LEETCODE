package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author MrkWinter
 * @version 1.02605. 从两个数字数组里生成最小数字
 * 提示
 * 简单
 * 55
 * 相关企业
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,1,3], nums2 = [5,7]
 * 输出：15
 * 解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
 * 输出：3
 * 解释：数字 3 的数位 3 在两个数组中都出现了。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 9
 * 1 <= nums1[i], nums2[i] <= 9
 * 每个数组中，元素 互不相同 。
 */
public class MinNumber {
    public static void main(String[] args) {
        int[] num1 = {4, 1, 3};
        int[] num2 = {5, 7};
        MinNumber minNumber = new MinNumber();
        int i = minNumber.minNumber2(num1, num2);
        System.out.println(i);
    }

    public int minNumber1(int[] nums1, int[] nums2) {
        int min1 = 10;
        int min2 = 10;
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && nums1[i] < min1) {
                    min1 = min2 = nums1[i];
                    break;
                }
            }
        }
        if (min1 < 10)
            return min1;
        for (int i = 0; i < nums1.length; i++) {
            if (min1 > nums1[i])
                min1 = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            if (min2 > nums2[i])
                min2 = nums2[i];
        }
        if (min1 < min2)
            return min1 * 10 + min2;
        else
            return min2 * 10 + min1;
    }

    public int minNumber2(int[] nums1, int[] nums2) {
        int min1 = 10;
        int leftNum = 10;
        int rightNum = 10;
        for (int i = 0; i < nums1.length; i++) {
            if (leftNum > nums1[i])
                leftNum = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && nums1[i] < min1) {
                    min1 = nums1[i];
                    if (i != 0)
                        break;
                }
                if (i == 0) {
                    if (rightNum > nums2[j])
                        rightNum = nums2[j];
                }
            }
        }
        if (min1 < 10)
            return min1;
        if (leftNum < rightNum)
            return leftNum * 10 + rightNum;
        else
            return rightNum * 10 + leftNum;
    }
}
