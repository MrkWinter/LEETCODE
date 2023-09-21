package day8;

import sun.misc.Queue;

import java.util.*;

/**
 * @author MrkWinter
 * @version 1.0
 * 2603. 收集树中金币
 * 提示
 * 困难
 * 74
 * 相关企业
 * <p>
 * 给你一个 n 个节点的无向无根树，节点编号从 0 到 n - 1 。给你整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间有一条边。再给你一个长度为 n 的数组 coins ，其中 coins[i] 可能为 0 也可能为 1 ，1 表示节点 i 处有一个金币。
 * <p>
 * 一开始，你需要选择树中任意一个节点出发。你可以执行下述操作任意次：
 * <p>
 * 收集距离当前节点距离为 2 以内的所有金币，或者
 * 移动到树中一个相邻节点。
 * <p>
 * 你需要收集树中所有的金币，并且回到出发节点，请你返回最少经过的边数。
 * <p>
 * 如果你多次经过一条边，每一次经过都会给答案加一。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1,0,0,0,0,1], edges = [[0,1],[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：从节点 2 出发，收集节点 0 处的金币，移动到节点 3 ，收集节点 5 处的金币，然后移动回节点 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：coins = [0,0,0,1,1,0,0,1], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[5,6],[5,7]]
 * 输出：2
 * 解释：从节点 0 出发，收集节点 4 和 3 处的金币，移动到节点 2 处，收集节点 7 处的金币，移动回节点 0 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == coins.length
 * 1 <= n <= 3 * 104
 * 0 <= coins[i] <= 1
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges 表示一棵合法的树。
 */
/*
解题思路:
先记录结点个数n
先将无向二叉树转换为图 并且将所有无金币的叶子结点去除

删去所有叶子结点(都含金币)

再删除所有叶子结点相连的叶子结点 (得到金币需要跑到的结点)

遍历剩下的树就是能收集全部金币所需要的最小步数

遍历边和点有特殊关系 返回 2*(n-1) 为最小步数
 */
public class CollectTheCoins {
    public static void main(String[] args) {
//        int[] coins = {0, 0, 0, 1, 1, 0, 0, 1};
//        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {5, 6}, {5, 7}};
        int[] coins = {1, 0, 0, 0, 0, 1};
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
//        int[] coins = {1, 1};
//        int[][] edges = {{0, 1}};
        CollectTheCoins coll = new CollectTheCoins();
        int i = coll.collectTheCoins(coins, edges);
        System.out.println(i);
    }

    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        int[] degree = new int[n];
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edge.add(new ArrayList<Integer>());
        }
        for (int[] info : edges) {
            edge.get(info[0]).add(info[1]);
            edge.get(info[1]).add(info[0]);
            degree[info[0]]++;
            degree[info[1]]++;
        }
        int ret = n;
        //除去非金币叶子结点
        for (int i = 0; i < n; i++) {
            int j = i;
            while (coins[j] != 1 && degree[j] == 1) {
                degree[j]--;
                int temp = edge.get(j).get(0);
                degree[temp]--;
                edge.get(temp).remove(new Integer(j));
                edge.get(j).clear();
                j = temp;
                ret--;
            }
        }
        //去除两次叶子结点

        for (int i = 0; i < 2; i++) {
            ArrayDeque<Integer> delete = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                if (degree[j] == 1) {
                    delete.offer(j);
                }
            }
            while (!delete.isEmpty()) {
                try {
                    int x = delete.poll();
                    degree[x]--;
                    int temp = edge.get(x).get(0);
                    degree[temp]--;
                    edge.get(temp).remove(new Integer(x));
                    edge.get(x).clear();
                    ret--;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return ret == 0 ? 0 : (ret - 1) * 2;
    }

//    public int collectTheCoins1(int[] coins, int[][] edges) {
//        int n = coins.length;
//        List<Integer>[] g = new List[n];
//        for (int i = 0; i < n; ++i) {
//            g[i] = new ArrayList<Integer>();
//        }
//        int[] degree = new int[n];
//        for (int[] edge : edges) {
//            int x = edge[0], y = edge[1];
//            g[x].add(y);
//            g[y].add(x);
//            ++degree[x];
//            ++degree[y];
//        }
//
//        int rest = n;
//        /* 删除树中所有无金币的叶子节点，直到树中所有的叶子节点都是含有金币的 */
//        Queue<Integer> queue = new ArrayDeque<Integer>();
//        for (int i = 0; i < n; ++i) {
//            if (degree[i] == 1 && coins[i] == 0) {
//                queue.offer(i);
//            }
//        }
//        while (!queue.isEmpty()) {
//            int u = queue.poll();
//            --degree[u];
//            --rest;
//            for (int v : g[u]) {
//                --degree[v];
//                if (degree[v] == 1 && coins[v] == 0) {
//                    queue.offer(v);
//                }
//            }
//        }
//        /* 删除树中所有的叶子节点, 连续删除2次 */
//        for (int x = 0; x < 2; ++x) {
//            queue = new ArrayDeque<Integer>();
//            for (int i = 0; i < n; ++i) {
//                if (degree[i] == 1) {
//                    queue.offer(i);
//                }
//            }
//            while (!queue.isEmpty()) {
//                int u = queue.poll();
//                --degree[u];
//                --rest;
//                for (int v : g[u]) {
//                    --degree[v];
//                }
//            }
//        }
//
//        return rest == 0 ? 0 : (rest - 1) * 2;
//    }
}
