package day10;

/**
 * @author MrkWinter
 * @version 1.0
 * 2596. 检查骑士巡视方案
 * 提示
 * 中等
 * 23
 * 相关企业
 * <p>
 * 骑士在一张 n x n 的棋盘上巡视。在有效的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
 * <p>
 * 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，其中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的。
 * <p>
 * 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
 * <p>
 * 注意，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
 * 输出：true
 * 解释：grid 如上图所示，可以证明这是一个有效的巡视方案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[0,3,6],[5,8,1],[2,7,4]]
 * 输出：false
 * 解释：grid 如上图所示，考虑到骑士第 7 次行动后的位置，第 8 次行动是无效的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 3 <= n <= 7
 * 0 <= grid[row][col] < n * n
 * grid 中的所有整数 互不相同
 */

/*
题解思路

从0开始 依次通过检测函数check 判断是否有正确的下一步位置
如果有 则一哪一步位置继续判断 是否有下一步位置
如果无 则返回false 直到遍历找到步数位数为 n*n-1 则遍历完全证明该策略可以遍历全部 返回true

check函数设计

private int[] check(int row,int col,int curStep)
int[] 是一个数组 如果找到位置 返回[0] 行 [1] 列
否则 返回null
要注意数组访问越界的问题
 */
public class CheckValidGrid {
    public static void main(String[] args) {
//        int[][] grid = {{0,3,6},{5,8,1},{2,7,4}};
        int[][] grid = {{8, 3, 6}, {5, 0, 1}, {2, 7, 4}};
        CheckValidGrid checkValidGrid = new CheckValidGrid();
        boolean b = checkValidGrid.checkValidGrid(grid);
        System.out.println(b);
    }

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0)
            return false;
        int n = grid.length;
        int[] position = {0, 0};
        for (int i = 1; i < n * n; i++) {
            position = check(position[0], position[1], grid, i);
            if (position == null)
                return false;
        }
        return true;
    }

    private int[] check(int row, int col, int[][] grid, int nextStep) {
        int n = grid.length;
        //1
        if (row + 2 < n && col - 1 >= 0 && grid[row + 2][col - 1] == nextStep) {
            return new int[]{row + 2, col - 1};
        }
        //2
        if (row + 1 < n && col - 2 >= 0 && grid[row + 1][col - 2] == nextStep) {
            return new int[]{row + 1, col - 2};
        }
        //3
        if (row - 1 >= 0 && col - 2 >= 0 && grid[row - 1][col - 2] == nextStep) {
            return new int[]{row - 1, col - 2};
        }
        //4
        if (row - 2 >= 0 && col - 1 >= 0 && grid[row - 2][col - 1] == nextStep) {
            return new int[]{row - 2, col - 1};
        }
        //5
        if (row - 2 >= 0 && col + 1 < n && grid[row - 2][col + 1] == nextStep) {
            return new int[]{row - 2, col + 1};
        }
        //6
        if (row - 1 >= 0 && col + 2 < n && grid[row - 1][col + 2] == nextStep) {
            return new int[]{row - 1, col + 2};
        }
        //7
        if (row + 1 < n && col + 2 < n && grid[row + 1][col + 2] == nextStep) {
            return new int[]{row + 1, col + 2};
        }
        //8
        if (row + 2 < n && col + 1 < n && grid[row + 2][col + 1] == nextStep) {
            return new int[]{row + 2, col + 1};
        }
        return null;
    }
}
