package day2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author MrkWinter
 * @version 1.0
 * 2251. 花期内花的数目
 * 提示
 * 困难
 * 87
 * 相关企业
 * <p>
 * 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
 * <p>
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
 * 输出：[1,2,2,2]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * <p>
 * 示例 2：
 * <p>
 * 输入：flowers = [[1,10],[3,3]], people = [3,3,2]
 * 输出：[2,2,1]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= flowers.length <= 5 * 104
 * flowers[i].length == 2
 * 1 <= starti <= endi <= 109
 * 1 <= people.length <= 5 * 104
 * 1 <= people[i] <= 109
 */
/*
思路 用数组记录每个时间点花的个数
然后返回对应时间的数组
 */
public class FullBloomFlowers {
    public static void main(String[] args) {
        int[][] flowers = {{21, 34}, {17, 37}, {23, 43}, {17, 46}, {37, 41}, {44, 45}, {32, 45}};
        int[] people = {31, 41, 10, 12};
        int[] ints = new FullBloomFlowers().fullBloomFlowers(flowers, people);
        System.out.println(Arrays.toString(ints));
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Arrays.sort(flowers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int[] ret = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int per = people[i];


            int left = 0;
            int right = flowers.length - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (per >= flowers[mid][0]) {
                    break;
                }
                right = mid - 1;
            }
            for (int j = mid; j >= 0 && per >= flowers[j][0]; j--) {
                if (per <= flowers[j][1])
                    ret[i] += 1;
            }
            for (int j = mid + 1; j < flowers.length && per >= flowers[j][0]; j++) {
                if (per <= flowers[j][1])
                    ret[i] += 1;
            }
        }
        return ret;
    }

    public int[] fullBloomFlowers1(int[][] flowers, int[] people) {
        //先找到大值
        int max = 0;
        for (int[] info : flowers) {
            if (max < info[1])
                max = info[1];
        }
        int[] flowersTime = new int[max + 1];
        for (int[] info : flowers) {
            for (int i = info[0]; i <= info[1]; i++) {
                flowersTime[i] += 1;
            }
        }
        int len = people.length;
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            if (people[i] > max) {
                continue;
            }
            ret[i] = flowersTime[people[i]];
        }
        return ret;
    }
}
