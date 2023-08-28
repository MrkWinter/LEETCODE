package com.mrkwinter.day7;

import sun.reflect.generics.tree.Tree;

/**
 * @author MrkWinter
 * @version 1.0
 * 530. 二叉搜索树的最小绝对差
 * 简单
 * 494
 * 相关企业
 *
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     树中节点的数目范围是 [2, 104]
 *     0 <= Node.val <= 105
 *
 *
 *
 * 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 */
public class GetMinimumDifference {
    private int min = Integer.MAX_VALUE;
    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return 0;
        TreeNode leftMax;
        TreeNode rightMin;
        if(root.left!=null) {
            leftMax = root.left;
            while (leftMax.right!=null) {
                leftMax = leftMax.right;
            }
            min = Math.min(root.val-leftMax.val,min);
            getMinimumDifference(root.left);
        }
        if(root.right!=null){
            rightMin = root.right;
            while (rightMin.left!=null) {
                rightMin = rightMin.left;
            }
            min = Math.min(rightMin.val-root.val,min);
            getMinimumDifference(root.right);
        }
        return min;
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
/