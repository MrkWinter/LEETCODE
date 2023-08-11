package com.mrkwinter.day3;

/**
 * @author MrkWinter
 * @version 1.0
 * 1572. 矩阵对角线元素的和
 * 提示
 * 简单
 * 100
 * 相关企业
 * <p>
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * <p>
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 * <p>
 * <p>
 * 示例  1：
 * <p>
 * 输入：mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * <p>
 * 示例  2：
 * <p>
 * 输入：mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * <p>
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 */
public class DiagonalSum {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new DiagonalSum().diagonalSum(arr));
    }

    public int diagonalSum(int[][] mat) {
        int len = mat.length;
        int sum = 0;
        for (int i = 0,j = len-1; i <len; i++) {
            if(i == j-i) {
                sum  = sum + mat[i][i];
            } else {
                sum = sum + mat[i][i] + mat[i][j-i];
            }
        }
        return sum;
    }
}
