package com.mrkwinter.day2;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author MrkWinter
 * @version 1.0
 * 1782. 统计点对的数目
 * 提示
 * 困难
 * 82
 * 相关企业
 * <p>
 * 给你一个无向图，无向图由整数 n  ，表示图中节点的数目，和 edges 组成，其中 edges[i] = [ui, vi] 表示 ui 和 vi 之间有一条无向边。同时给你一个代表查询的整数数组 queries 。
 * <p>
 * 第 j 个查询的答案是满足如下条件的点对 (a, b) 的数目：
 * <p>
 * a < b
 * cnt 是与 a 或者 b 相连的边的数目，且 cnt 严格大于 queries[j] 。
 * <p>
 * 请你返回一个数组 answers ，其中 answers.length == queries.length 且 answers[j] 是第 j 个查询的答案。
 * <p>
 * 请注意，图中可能会有 重复边 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]
 * 输出：[6,5]
 * 解释：每个点对中，与至少一个点相连的边的数目如上图所示。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5, edges = [[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]], queries = [1,2,3,4,5]
 * 输出：[10,10,9,8,6]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 2 * 104
 * 1 <= edges.length <= 105
 * 1 <= ui, vi <= n
 * ui != vi
 * 1 <= queries.length <= 20
 * 0 <= queries[j] < edges.length
 */
public class CountPairs {
    public static void main(String[] args) {
        int[][] edges = new int[5][2];
        edges[0][0] = 1; edges[0][1]=2 ;
        edges[1][0] = 2; edges[1][1]= 4;
        edges[2][0] = 1; edges[2][1]=3 ;
        edges[3][0] = 2; edges[3][1]= 3;
        edges[4][0] = 2; edges[4][1]= 1;
        int n = 4;
        int[] queries = {2,3};
        int[] ints = new CountPairs().countPairs(n, edges, queries);
        System.out.println(Arrays.toString(ints));
    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        //表示每个结点的所连边数
        int[] nodeCT = new int[n];
        //表示两点间的连接边数
        HashMap<String, Integer> hashMap = new HashMap<>();
        //统计每个结点的连接边数 并且存储连接边数
        int a = 0, b = 0;
        Integer cont = 0;
        for (int i = 0; i < edges.length; i++) {
            a = edges[i][0] - 1;
            b = edges[i][1] - 1;
            nodeCT[a]++;
            nodeCT[b]++;
            if (a < b) {
                if ((cont = hashMap.get(a + "-" + b)) == null)
                    hashMap.put(a + "-" + b, 1);
                else hashMap.put(a + "-" + b, cont + 1);
            } else if (b < a) {
                if ((cont = hashMap.get(b + "-" + a)) == null)
                    hashMap.put(b + "-" + a, 1);
                else hashMap.put(b + "-" + a, cont + 1);
            }
        }
        //创建数组 存放边数值
        int index = 0;
        int hah  = 0;
        int[] ints = new int[n * (n - 1) / 2];
        for (int i = 0; i < nodeCT.length - 1; i++) {
            for (int j = i + 1; j < nodeCT.length; j++) {
                if(hashMap.get(i + "-" + j)!=null) {
                    hah = hashMap.get(i + "-" + j);
                }
                ints[index++] = nodeCT[i] + nodeCT[j] - hah;
                hah = 0;
            }

        }
        //创建返回数组
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] > queries[i]) {
                    ret[i]++;
                }
            }
        }
        return ret;
    }
}
