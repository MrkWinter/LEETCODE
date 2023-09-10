package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author MrkWinter
 * @version 1.0
 * 207. 课程表
 * 提示
 * 中等
 * 1.8K
 * 相关企业
 * <p>
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * <p>
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */
public class CanFinish {
    private int[] findCourses;

    public static void main(String[] args) {
//        int[][] prerequisites = {{1, 0}};
        int[][] prerequisites = {{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}};
        int numCourses = 8;
        CanFinish canFinish = new CanFinish();
        boolean b = canFinish.canFinish(numCourses, prerequisites);
        System.out.println(b);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 取数据 键值对映射
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> integers = hashMap.get(prerequisites[i][0]);
            if (integers == null) {
                hashMap.put(prerequisites[i][0], new ArrayList());
                integers = hashMap.get(prerequisites[i][0]);
            }
            integers.add(prerequisites[i][1]);
        }
        // 2. 根据映射找到可以 能找到所有课程表示成功
        findCourses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!findCourses(i, new ArrayList<Integer>(), hashMap))
                return false;
            findCourses[i] = 1;
        }
        return true;

    }

    //递归 查看当前课程是否能学习
    private boolean findCourses(int numCourse, ArrayList<Integer> notCourse, HashMap<Integer, ArrayList<Integer>> hashMap) {
        ArrayList<Integer> integers;
        if ((integers = hashMap.get(numCourse)) == null) {
            //此课程无限制 可以学习
            return true;
        }
        notCourse.add(numCourse);
        for (int i = 0; i < integers.size(); i++) {
            Integer integer = integers.get(i);
            //查看是否有必须学习的课
            for (int j = 0; j < notCourse.size(); j++) {
                if (notCourse.get(j) == integer)
                    return false;
            }
        }
        //查看
        for (int i = 0; i < integers.size(); i++) {
            Integer integer = integers.get(i);
            //如果不能学习 返回false
            if (!(findCourses[numCourse] == 1 || findCourses(integer, notCourse, hashMap))) {
                return false;
            }
        }
        notCourse.remove(new Integer(numCourse));
        return true;
    }
}
