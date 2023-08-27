package com.mrkwinter.day6;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 56. 合并区间
 * 中等
 * 2K
 * 相关企业
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Merge {
    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
//        int[][] merge = new Merge().merge1(intervals);
        int[][] merge = new Merge().merge2(intervals);
        System.out.println(Arrays.toString(merge));
    }

    public int[][] merge1(int[][] intervals) {
        boolean flag = true;
        ArrayList<Integer> startArr = new ArrayList<>();
        startArr.add(intervals[0][0]);
        ArrayList<Integer> endArr = new ArrayList<>();
        endArr.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int n = startArr.size();
            int j = 0;
            for (j = 0; j < n; j++) {
                if (startArr.get(j) >= start) {
                    if (startArr.get(j) <= end) {
                        startArr.set(j, start);
                        endArr.set(j, Math.max(end, endArr.get(j)));
                        break;
                    }
                } else {
                    if (start <= endArr.get(j)) {
                        endArr.set(j, Math.max(end, endArr.get(j)));
                        break;
                    }
                }
            }
            if (j == n) {
                startArr.add(start);
                endArr.add(end);
            }
            if (!(j == n || j == n - 1)) {
                flag = false;
            }

        }
        int[][] ints = new int[startArr.size()][2];
        for (int i = 0; i < ints.length; i++) {
            ints[i][0] = startArr.get(i);
            ints[i][1] = endArr.get(i);
        }
        if (flag)
            return ints;
        else
            return merge1(ints);
    }

    public int[][] merge2(int[][] intervals) {
        for (int gap = intervals.length / 2; gap > 0; gap/=2) {
            for (int i = gap; i < intervals.length; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                int j = 0;
                for (j = i; j >= gap; j -= gap) {
                    if (intervals[j - gap][0] > start) {
                        intervals[j][0] = intervals[j-gap][0];
                        intervals[j][1] = intervals[j-gap][1];
                    } else if (intervals[j - gap][0] == start) {
                        if(intervals[j-gap][1]>end) {
                            intervals[j][0] = intervals[j-gap][0];
                            intervals[j][1] = intervals[j-gap][1];
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                intervals[j][0] = start;
                intervals[j][1] = end;
            }
        }
        ArrayList<Integer> startArr = new ArrayList<>();
        startArr.add(intervals[0][0]);
        ArrayList<Integer> endArr = new ArrayList<>();
        endArr.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int size = startArr.size();
            if (intervals[i][0]<=endArr.get(size-1)) {
                endArr.set(size-1,Math.max(intervals[i][1],endArr.get(size-1)));
            } else {
                startArr.add(intervals[i][0]);
                endArr.add(intervals[i][1]);
            }
        }
        int[][] ints = new int[startArr.size()][2];
        for (int i = 0; i < ints.length; i++) {
            ints[i][0] = startArr.get(i);
            ints[i][1] = endArr.get(i);
        }
        return ints;
    }

}
