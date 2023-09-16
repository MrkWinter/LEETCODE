package day1;

import java.util.*;


/**
 * @author MrkWinter
 * @version 1.0
 * 1222. 可以攻击国王的皇后
 * 提示
 * 中等
 * 68
 * 相关企业
 * <p>
 * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 * <p>
 * 给定一个由整数坐标组成的数组 queens ，表示黑皇后的位置；以及一对坐标 king ，表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * 输出：[[0,1],[1,0],[3,3]]
 * 解释：
 * [0,1] 的皇后可以攻击到国王，因为他们在同一行上。
 * [1,0] 的皇后可以攻击到国王，因为他们在同一列上。
 * [3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。
 * [0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。
 * [4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。
 * [2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
 * <p>
 * 示例 2：
 * <p>
 * 输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * 输出：[[2,2],[3,4],[4,4]]
 * <p>
 * 示例 3：
 * <p>
 * 输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * 输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queens.length <= 63
 * queens[i].length == 2
 * 0 <= queens[i][j] < 8
 * king.length == 2
 * 0 <= king[0], king[1] < 8
 * 一个棋盘格上最多只能放置一枚棋子。
 */

/*
解题思路：
1.先将黑皇后的位置记录在一个8*8的棋盘上 然后从白皇后的位置向上下左右以及对角线寻找最近的黑皇后
2.找到的黑皇后就是可以攻击白皇后的黑皇后
3.理论上找到的可攻击白皇后的黑皇后最多只有8个
 */
public class QueensAttackTheKing {
    public static void main(String[] args) {
        int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] king = {0,0};
        QueensAttackTheKing queensAttackTheKing = new QueensAttackTheKing();
        List<List<Integer>> lists = queensAttackTheKing.queensAttackTheKing(queens, king);

        ArrayList<String> strings = new ArrayList<>();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) { //hashNext  检测当前cur 指针是否走到结尾 如果走到结尾 则退出循环
            String next = iterator.next(); //取出当前元素 将指针向后移动
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        Set<String> strings1 = hashMap.keySet();
        Collection<Integer> values = hashMap.values();
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        
    }

    public List<List<Integer>> queensAttackTheKing(int[][] queens, int[] king) {
        int[][] boards = new int[8][8];
        for (int[] info : queens) {
            boards[info[0]][info[1]] = 1;
        }
        List<List<Integer>> ret = new ArrayList<>();
        int x = king[0];
        int y = king[1];
        //上
        int tempX;
        int tempY;
        for (tempX = x; tempX >= 0; tempX--) {
            if (boards[tempX][y] == 1) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(tempX);
                integers.add(y);
                ret.add(integers);
                break;
            }
        }
        //下
        for (tempX = x; tempX < 8; tempX++) {
            if (boards[tempX][y] == 1) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(tempX);
                integers.add(y);
                ret.add(integers);
                break;
            }
        }
        //左
        for (tempY = y; tempY >= 0; tempY--) {
            if (boards[x][tempY] == 1) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(x);
                integers.add(tempY);
                ret.add(integers);
                break;
            }
        }
        //右
        for (tempY = y; tempY < 8; tempY++) {
            if (boards[x][tempY] == 1) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(x);
                integers.add(tempY);
                ret.add(integers);
                break;
            }
        }
        //左下
        for (tempX = x, tempY = y; tempX < 8 && tempY >= 0; tempX++, tempY--) {
            if (boards[tempX][tempY] == 1) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(tempX);
                integers.add(tempY);
                ret.add(integers);
                break;
            }
        }
        //左上
        for (tempX = x, tempY = y; tempX >= 0 && tempY >= 0; tempX--, tempY--) {
            if (boards[tempX][tempY] == 1) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(tempX);
                integers.add(tempY);
                ret.add(integers);
                break;
            }
        }
        //右上
        for (tempX = x, tempY = y; tempX >= 0 && tempY < 8; tempX--, tempY++) {
            if (boards[tempX][tempY] == 1) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(tempX);
                integers.add(tempY);
                ret.add(integers);
                break;
            }
        }
        //右下
        for (tempX = x, tempY = y; tempX < 8 && tempY < 8; tempX++, tempY++) {
            if (boards[tempX][tempY] == 1) {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(tempX);
                integers.add(tempY);
                ret.add(integers);
                break;
            }
        }
        return ret;
    }
}
