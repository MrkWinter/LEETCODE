package com.mrkwinter.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author MrkWinter
 * @version 1.0
 * 1761. 一个图中连通三元组的最小度数
 * 提示
 * 困难
 * 60
 * 相关企业
 * <p>
 * 给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向边。
 * <p>
 * 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
 * <p>
 * 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
 * <p>
 * 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
 * 输出：3
 * 解释：只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
 * 输出：0
 * 解释：有 3 个三元组：
 * 1) [1,4,3]，度数为 0 。
 * 2) [2,5,6]，度数为 2 。
 * 3) [5,6,7]，度数为 2 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 400
 * edges[i].length == 2
 * 1 <= edges.length <= n * (n-1) / 2
 * 1 <= ui, vi <= n
 * ui != vi
 * 图中没有重复的边。
 */
public class MinTrioDegree {
    public static void main(String[] args) {
//        int n = 6;
//        int[][] edges = {{1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6}};
//        int n = 4;
//        int[][] edges = {{1, 2}, {4, 1}, {4, 2}};
        int n = 10;
        int[][] edges = {{3,4},{3,10},{5,7},{9,5},{8,3},
            {5,10},{9,8},{10,9},{1,6},{1,3},
            {6,2},{6,8},{4,8},{3,6},{8,2},
            {9,1},{9,4},{7,3},{7,6},{3,2},
            {3,5},{5,2},{4,10},{9,3},{5,8},
            {8,7},{9,6},{10,1},{10,7},
            {1,4},{2,9},{1,7}};

        int i = new MinTrioDegree().minTrioDegree4(n, edges);
        System.out.println(i);
    }

    public int minTrioDegree1(int n, int[][] edges) {
        int[] visit = new int[n];
        //标识判断是否可成为三元组 0 未判断 1 访问过可以为三元组 -1 访问过不可为三元组
        ArrayList<Integer> nodes = new ArrayList<>();
        //模拟队列 进行广度优先遍历
        for (int i = 0; i < n; i++) {

            nodes.add(i);
            //添加起始遍历结点
            for (int j = 0; j < edges[0].length; j++) {

            }

        }
        return 1;
    }

    public int minTrioDegree2(int n, int[][] edges) {
        int[] visit = new int[n];
        //标识判断是否可成为三元组 0 未判断 1 访问过可以为三元组 -1 访问过不可为三元组
        //先用Map将点的边存起来
        HashMap<Integer, ArrayList<Integer>> group = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int key = edges[i][0];
            if (group.get(key) == null) {
                group.put(key, new ArrayList<Integer>());
            }
            ArrayList<Integer> integers1 = group.get(key);
            integers1.add(edges[i][1]);
            key = edges[i][1];
            if (group.get(key) == null) {
                group.put(key, new ArrayList<Integer>());
            }
            ArrayList<Integer> integers2 = group.get(key);
            integers2.add(edges[i][0]);
        }
        //用ArrayList存放三元组 
        ArrayList<int[]> three = new ArrayList<>();
        //直接多次遍历edges数组 找到三元组
        for (int i = 0; i < edges.length; i++) {
            //找到可以为三元组的第一个结点
            if (visit[edges[i][0] - 1] != -1 && visit[edges[i][1] - 1] != -1) {
                //得到第二个结点的连通结点集合
                ArrayList<Integer> anotherEdges = group.get(edges[i][1]);
                //得到第三个结点
                boolean flag = true;
                for (int j = 0; j < anotherEdges.size(); j++) {
                    //判断第三个结点是否连接第一个结点
                    if (anotherEdges.get(j) == edges[i][0])
                        continue;
                    ArrayList<Integer> oEdges = group.get(anotherEdges.get(j));

                    for (int k = 0; k < oEdges.size(); k++) {
                        if (oEdges.get(k) == edges[i][0]) {
                            int[] ints = {edges[i][0], edges[i][1], anotherEdges.get(j)};
                            Arrays.sort(ints);
                            boolean tap = true;
                            for (int l = 0; l < three.size(); l++) {
                                if (Arrays.equals(three.get(l), ints)) {
                                    tap = false;
                                    break;
                                }
                            }
                            if (!tap) {
                                flag = false;
                                break;
                            }
                            three.add(ints);
                            visit[ints[0] - 1] = 1;
                            visit[ints[1] - 1] = 1;
                            visit[ints[2] - 1] = 1;
                            flag = false;
                            break;
                        }
                    }
                }
                //这两个结点找不到三元组
                if (flag) {
                    visit[edges[i][1] - 1] = -1;
                }
            }
        }
        //统计最小三元组
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < three.size(); i++) {
            int[] ints = three.get(i);
            int temp = group.get(ints[0]).size() + group.get(ints[1]).size() + group.get(ints[2]).size() - 6;
            min = Math.min(temp, min);
        }
        return min;
    }

    public int minTrioDegree3(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> group = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int key = edges[i][0];
            if (group.get(key) == null) {
                group.put(key, new ArrayList<Integer>());
            }
            ArrayList<Integer> integers1 = group.get(key);
            integers1.add(edges[i][1]);
            key = edges[i][1];
            if (group.get(key) == null) {
                group.put(key, new ArrayList<Integer>());
            }
            ArrayList<Integer> integers2 = group.get(key);
            integers2.add(edges[i][0]);
        }
        ArrayList<int[]> three = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            ArrayList<Integer> anotherEdges = group.get(edges[i][1]);
            for (int j = 0; j < anotherEdges.size(); j++) {
                if (anotherEdges.get(j) == edges[i][0])
                    continue;
                ArrayList<Integer> oEdges = group.get(anotherEdges.get(j));
                for (int k = 0; k < oEdges.size(); k++) {
                    if (oEdges.get(k) == edges[i][0]) {
                        int[] ints = {edges[i][0], edges[i][1], anotherEdges.get(j)};
                        Arrays.sort(ints);
                        boolean tap = true;
                        for (int l = 0; l < three.size(); l++) {
                            if (Arrays.equals(three.get(l), ints)) {
                                tap = false;
                                break;
                            }
                        }
                        if (tap) {
                            three.add(ints);
                        }
                        break;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < three.size(); i++) {
            int[] ints = three.get(i);
            int temp = group.get(ints[0]).size() + group.get(ints[1]).size() + group.get(ints[2]).size() - 6;
            min = Math.min(temp, min);
        }
        if (min != Integer.MAX_VALUE)
            return min;
        else return -1;
    }

    public int minTrioDegree4(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> group = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int key = edges[i][0];
            if (group.get(key) == null) {
                group.put(key, new ArrayList<Integer>());
            }
            ArrayList<Integer> integers1 = group.get(key);
            integers1.add(edges[i][1]);
            key = edges[i][1];
            if (group.get(key) == null) {
                group.put(key, new ArrayList<Integer>());
            }
            ArrayList<Integer> integers2 = group.get(key);
            integers2.add(edges[i][0]);
        }
        int[] visit = new int[n];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            ArrayList<Integer> secondNode = group.get(i);
            if (secondNode == null)
                continue;
            for (int j = 0; j < secondNode.size(); j++) {
                if (visit[secondNode.get(j) - 1] == -1)
                    continue;
                ArrayList<Integer> thirdNode = group.get(secondNode.get(j));
                for (int k = 0; k < thirdNode.size(); k++) {
                    if (visit[thirdNode.get(k) - 1] == -1)
                        continue;
                    ArrayList<Integer> retNode = group.get(thirdNode.get(k));
                    if (retNode.contains(i)) {
                        int[] ints = {i, secondNode.get(j), thirdNode.get(k)};
                        min = Math.min(group.get(ints[0]).size() +
                                group.get(ints[1]).size() + group.get(ints[2]).size() - 6, min);
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                visit[i - 1] = -1;
            }
        }
        if (min != Integer.MAX_VALUE)
            return min;
        else return -1;
    }
}
