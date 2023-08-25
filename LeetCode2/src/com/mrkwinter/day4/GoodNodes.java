package com.mrkwinter.day4;

/**
 * @author MrkWinter
 * @version 1.0
 * 1448. 统计二叉树中好节点的数目
 * 提示
 * 中等
 * 125
 * 相关企业
 * <p>
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * <p>
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,1,4,3,null,1,5]
 * 输出：4
 * 解释：图中蓝色节点为好节点。
 * 根节点 (3) 永远是个好节点。
 * 节点 4 -> (3,4) 是路径中的最大值。
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [3,3,null,4,2]
 * 输出：3
 * 解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 * 解释：根节点是好节点。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉树中节点数目范围是 [1, 10^5] 。
 * 每个节点权值的范围是 [-10^4, 10^4] 。
 */
public class GoodNodes {
    private int count;

    public static void main(String[] args) {

    }

    //    public int goodNodes(TreeNode root) {
//        if(root==null)
//            return 0;
//        return goodNodes(root, root.val);
//    }
//
//    public int goodNodes(TreeNode root, int pathMax) {
//        int sum = 0;
//        if (root.val >= pathMax) {
//            //当前结点是好结点
//            pathMax = root.val;
//            sum++;
//        }
//        if (root.left != null) {
//            sum += goodNodes(root.left, pathMax);
//        }
//        if (root.right != null) {
//            sum += goodNodes(root.right, pathMax);
//        }
//        return sum;
//    }
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        goodNodes(root, root.val);
        return count;
    }

    public void goodNodes(TreeNode root, int pathMax) {
        if (root.val >= pathMax) {
            //当前结点是好结点
            pathMax = root.val;
            count++;
        }
        if (root.left != null) {
            goodNodes(root.left, pathMax);
        }
        if (root.right != null) {
            goodNodes(root.right, pathMax);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
