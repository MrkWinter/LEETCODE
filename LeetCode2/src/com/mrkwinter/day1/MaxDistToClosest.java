package com.mrkwinter.day1;

/**
 * @author MrkWinter
 * @version 1.0
 * 849. 到最近的人的最大距离
 * 中等
 * 234
 * 相关企业
 * <p>
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 * <p>
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：seats = [1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：seats = [1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：seats = [0,1]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= seats.length <= 2 * 104
 * seats[i] 为 0 或 1
 * 至少有一个 空座位
 * 至少有一个 座位上有人
 */
public class MaxDistToClosest {
    public static void main(String[] args) {
        int[] seats = {1, 0, 0, 0, 1, 0, 1};
        int i = new MaxDistToClosest().maxDistToClosest(seats);
        System.out.println(i);
    }

    //左边有人 右边没人
    //左边
    public int maxDistToClosest(int[] seats) {
        int maxDist = 0;
        for (int i = 0, curEnd = 0; i < seats.length; i = curEnd++) {
            while (curEnd < seats.length - 1 && seats[curEnd] != 1) {
                curEnd++;
            }
            if (i == 0 && seats[i] == 0) {
                maxDist = Math.max(maxDist, curEnd - i);
            } else if (curEnd == seats.length - 1 && seats[curEnd] == 0) {
                maxDist = Math.max(maxDist, curEnd - i);
            } else {
                maxDist = Math.max(maxDist, (curEnd - i) / 2);
            }
        }
        return maxDist;
    }
}
