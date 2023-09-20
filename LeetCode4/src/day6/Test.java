package day6;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Test {
    private static int count = 0;
    public static void main(String[] args) {
        mal(new int[5], 0);
        System.out.println(count);
    }

    private static void mal(int[] nums, int index) {
        if (nums.length == index) {
            System.out.println(Arrays.toString(nums));
            count++;
            return;
        }
        nums[index] = 0;
        mal(nums, index + 1);
        nums[index] = 1;
        mal(nums, index + 1);

    }

}
