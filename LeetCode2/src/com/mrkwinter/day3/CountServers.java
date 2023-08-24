package com.mrkwinter.day3;

/**
 * @author MrkWinter
 * @version 1.0
 * 1267. 统计参与通信的服务器
 * 提示
 * 中等
 * 77
 * 相关企业
 * <p>
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * <p>
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * <p>
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 */
public class CountServers {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int i = new CountServers().countServers(grid);
        System.out.println(i);
    }

    public int countServers(int[][] grid) {
        int row = 0;
        int col = 0;
        int rowCount = 0;
        int sumCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (rowCount == 0) {
                        row = i;
                        col = j;
                    }
                    rowCount++;
                }
            }
            if (rowCount > 0) {
                if (rowCount == 1) {
                    for (int j = 0; j < grid.length; j++) {
                        if (j != row && grid[j][col] == 1) {
                            sumCount += rowCount;
                            break;
                        }
                    }
                } else {
                    sumCount += rowCount;
                }
                rowCount = 0;
            }
        }
        return sumCount;
    }
}
