package day5;

/**
 * @author MrkWinter
 * @version 1.0
 * 2594. 修车的最少时间
 * 提示
 * 中等
 * 63
 * 相关企业
 * <p>
 * 给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
 * <p>
 * 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
 * <p>
 * 请你返回修理所有汽车 最少 需要多少时间。
 * <p>
 * 注意：所有机械工可以同时修理汽车。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranks = [4,2,3,1], cars = 10
 * 输出：16
 * 解释：
 * - 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
 * - 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
 * - 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
 * - 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * 16 分钟是修理完所有车需要的最少时间。
 * <p>
 * 示例 2：
 * <p>
 * 输入：ranks = [5,1,8], cars = 6
 * 输出：16
 * 解释：
 * - 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
 * - 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * - 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
 * 16 分钟时修理完所有车需要的最少时间。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ranks.length <= 105
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 106
 */
public class RepairCars {
    public static void main(String[] args) {

    }

    //二分查找算法
    public long repairCars(int[] ranks, int cars) {
        long l = 1, r = (long) ranks[0] * cars * cars; //最小时间 最大时间
        while (l < r) {
            long mid = (l + r) / 2; //求得中间时间
            if (check(ranks, cars, mid)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return r;
    }

    //时间是否够用
    private boolean check(int[] rank, int cars, long mid) {
        int sum = 0;
        for (int n : rank) sum += Math.sqrt(mid / n);
        return sum >= cars;
    }
}
