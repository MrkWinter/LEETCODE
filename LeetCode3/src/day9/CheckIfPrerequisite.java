package day9;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MrkWinter
 * @version 1.0
 * 1462. 课程表 IV
 * 提示
 * 中等
 * 136
 * 相关企业
 * <p>
 * 你总共需要上 numCourses 门课，课程编号依次为 0 到 numCourses-1 。你会得到一个数组 prerequisite ，其中 prerequisites[i] = [ai, bi] 表示如果你想选 bi 课程，你 必须 先选 ai 课程。
 * <p>
 * 有的课会有直接的先修课程，比如如果想上课程 1 ，你必须先上课程 0 ，那么会以 [0,1] 数对的形式给出先修课程数对。
 * <p>
 * 先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。
 * <p>
 * 你也得到一个数组 queries ，其中 queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程 uj 是否是课程 vj 的先决条件。
 * <p>
 * 返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * 输出：[false,true]
 * 解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。
 * <p>
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
 * 输出：[false,false]
 * 解释：没有先修课程对，所以每门课程之间是独立的。
 * <p>
 * 示例 3：
 * <p>
 * 输入：numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
 * 输出：[true,true]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= numCourses <= 100
 * 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
 * prerequisites[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 每一对 [ai, bi] 都 不同
 * 先修课程图中没有环。
 * 1 <= queries.length <= 104
 * 0 <= ui, vi <= n - 1
 * ui != vi
 */
public class CheckIfPrerequisite {

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries = {{1, 0}, {1, 2}};
        CheckIfPrerequisite checkIfPrerequisite = new CheckIfPrerequisite();
        checkIfPrerequisite.checkIfPrerequisite(numCourses, prerequisites, queries);
    }

    private ArrayList<ArrayList<Integer>> edges;
    private boolean[] visit;
    private boolean flag;

    //先创建图 根据dfs遍历 如果能从 u -> v 则证明u为v的先修课程
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //建立图
        edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[0]).add(info[1]);
        }
        visit = new boolean[numCourses];
        ArrayList<Boolean> ret = new ArrayList<>(queries.length);
        for (int i = 0; i < queries.length; i++) {
            ret.add(false);
        }
        for (int i = 0; i < queries.length; i++) {
            flag = false;
            dfsGet(queries[i][0], queries[i][1]);
            if (flag)
                ret.set(i, true);
            Arrays.fill(visit, false);
        }
        return ret;
    }

    private void dfsGet(int begin, int find) { //从begin开始 是否能找到find
        ArrayList<Integer> integers = edges.get(begin);
        visit[begin] = true;
        for (Integer integer : integers) {
            if (integer == find) {
                flag = true;
            }
            if (!flag && !visit[integer]) {
                dfsGet(integer, find);
            }
        }
    }
}
