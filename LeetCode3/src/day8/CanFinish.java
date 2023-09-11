package day8;

import java.util.ArrayList;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class CanFinish {
    private ArrayList<ArrayList<Integer>> edges;
    private int[] visit;
    private boolean isFinish;

    public static void main(String[] args) {
        int[][] prerequisites = {{0, 1}};
        CanFinish canFinish = new CanFinish();
        canFinish.canFinish(2, prerequisites);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<ArrayList<Integer>>(); //记录图边
        visit = new int[numCourses]; //记录点是否遍历
        isFinish = true; //表示可以完成学习 如果图存在环则不能完成
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[0]).add(info[1]); //添加边 [0]点 的入度
        }
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0)
                dfs(i);
        }
        return isFinish;
    }

    //深度遍历  看是否有环
    private void dfs(int i) {
        visit[i] = 1; //该点搜索中
        ArrayList<Integer> points = edges.get(i);
        for (int j = 0; j < points.size(); j++) {
            if (visit[points.get(j)] == 1) {
                isFinish = false;
                return;
            } else if (visit[points.get(j)] == 0) {
                if (isFinish)
                    dfs(points.get(j));
            }
        }
        visit[i] = 2;
    }
}
