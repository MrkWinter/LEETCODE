package com.mrkwinter.day2;

import java.util.Arrays;
import java.util.Map;

/**
 * @author MrkWinter
 * @version 1.0
 * 1289. 下降路径最小和 II
 * 提示
 * 困难
 * 122
 * 相关企业
 * <p>
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 * <p>
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[7]]
 * 输出：7
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 */
public class MinFallingPathSum {
    private int minSum = 0;

    public static void main(String[] args) {
//        int[] arr = {1, 2, 5, 8, 3, 5};
//        MinFallingPathSum min = new MinFallingPathSum();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new MinFallingPathSum().minFallingPathSum(arr));

    }

    //使用动态规划算法
    public int minFallingPathSum(int[][] grid) {
        int len = grid.length;
        int[][] des = new int[len][len];
        //des数组每一行保存前几行到该行的最小值
        for (int i = 0; i < des.length; i++) {
            for (int j = 0; j < len; j++) {
                des[i][j] = Integer.MAX_VALUE;
            }
            des[0][i] = grid[0][i];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (j == k)
                        continue;
                    des[i][j] = Math.min(des[i][j], des[i - 1][k] + grid[i][j]);
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            ret = Math.min(ret, des[len - 1][i]);
        }
        return ret;
    }

    //算法优化 未完成
    public int minFallingPathSum(int[][] grid, int s) {
        int len = grid.length;
        int first = grid[0][0];
        int firstIndex = 0;
        int second = grid[0][0];
        int retFirst = Integer.MAX_VALUE;
        int retSecond = Integer.MAX_VALUE;
        int retIndex = 0;
        int temp = 0;
        //找到第一行的最小值和次小值及下标
        for (int i = 1; i < len; i++) {
            if (grid[0][i] < second) {
                second = grid[0][i];
            }
            if (second < first) {
                temp = second;
                second = first;
                first = temp;
                firstIndex = i;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (j == retIndex) {
                        if (j == 0) {
                            retFirst = retSecond = second + grid[i][j];
                        } else {
                            if (retSecond > second + grid[i][j]) {
                                retSecond = second + grid[i][j];
                            }
                        }
                    } else {

                    }
                }
            }
        }
        return 1;
    }
    //row 表示要遍历的本行 col为上一行的元素行的位置 递归回溯时间复读较高
    //public int minFallingPathSum(int[][] grid) {
    //    getMinSum(grid, 0, grid.length, 0);
    //    return minSum;
    //}

    //row 表示要遍历的本行 col为上一行的元素行的位置 递归回溯时间复读较高
    public void getMinSum(int[][] arr, int row, int col, int sum) {
        if (row == arr.length) {
            //到达最后一行
            if (minSum == 0) {
                //先赋值一个下降路径
                minSum = sum;
            } else if (sum < minSum) {
                //找到更小的下降路径 重新赋值给minSum
                minSum = sum;
            }
            return;
        }
        //递归遍历本行相加
        for (int i = 0; i < arr[0].length; i++) {
            if (i != col && row + 1 <= arr.length) { //不在同一列上
                getMinSum(arr, row + 1, i, sum + arr[row][i]);
            }
        }
    }
    //贪心算法优化
    //返回一个数组 数组中依次为较小值的下标 升序排列
}
