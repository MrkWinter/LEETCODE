package com.mrkwinter.day7;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 57. 插入区间
 * 中等
 * 754
 * 相关企业
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * <p>
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * <p>
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 */
public class Insert {
    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {0, 0};
        int[][] insert = new Insert().insert(intervals, newInterval);
        for (int i = 0; i < insert.length; i++) {
            System.out.println(Arrays.toString(insert[i]));
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        int count = 0;
        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= start) {//前面合并
                if (i - 1 >= 0 && start <= intervals[i - 1][1]) {
                    start = intervals[i - 1][0];
                    end = Math.max(intervals[i - 1][1], end);
                    i = i - 1;
                    count++;
                } else if (intervals[i][0] <= end) { //后面合并
                    end = Math.max(intervals[i][1], end);
                    count++;
                } else {//不能合并
                    break;
                }
                for (int j = i + 1; j < intervals.length; j++) {
                    if (intervals[j][0] <= end) {
                        end = Math.max(intervals[j][1], end);
                        count++;
                    }
                }
                break;
            }
        }
        if (i - 1 >= 0 && i == intervals.length && start <= intervals[i - 1][1]) {
            count++;
            start = intervals[i - 1][0];
            end = Math.max(intervals[i - 1][1], end);
            i = i - 1;
        }
        int[][] ints = new int[intervals.length - count + 1][2];
        for (int j = 0, k = 0; j < ints.length; j++, k++) {
            if (j == i) {
                ints[j][0] = start;
                ints[j][1] = end;
                k += count - 1;
            } else {
                ints[j][0] = intervals[k][0];
                ints[j][1] = intervals[k][1];
            }
        }
        return ints;
    }
}
