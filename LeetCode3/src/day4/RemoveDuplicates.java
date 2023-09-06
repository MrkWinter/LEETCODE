package day4;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 80. 删除有序数组中的重复项 II
 * 中等
 * 879
 * 相关企业
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums = {1, 2, 2};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates1(nums);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int sub = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] == nums[i]) {
                int j = i;
                while (j < nums.length && nums[j] == nums[i - 2]) {
                    nums[j] = Integer.MAX_VALUE;
                    sub++;
                    j++;
                }
                i = j;
            }
        }
        Arrays.sort(nums);
        return nums.length - sub;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int k = 2;
        boolean flag = true;
        for (k = 2; k < nums.length; k++) {
            if (nums[k - 2] == nums[k]) {
                k = k + 1;
                flag = false;
                break;
            }
        }
        if (flag)
            return nums.length;
        int i = k - 2;
        while (k < nums.length) {
            if (nums[i - 1] == nums[i]) {
                //找不等于的两个
                while (k < nums.length && nums[k] == nums[i]) {
                    k++;
                }
                if (k < nums.length && i + 1 < nums.length)
                    nums[++i] = nums[k++];
                if (k < nums.length && i + 2 < nums.length)
                    nums[++i] = nums[k++];
            } else {
                //任意找一个
                if (i + 1 < nums.length) {
                    nums[++i] = nums[k++];
                }
            }
        }
        return i + 1;
    }
}
