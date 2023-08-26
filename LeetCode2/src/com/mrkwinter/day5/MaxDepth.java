package com.mrkwinter.day5;

/**
 * @author MrkWinter
 * @version 1.0
 * 104. 二叉树的最大深度
 * 简单
 * 1.7K
 * 相关企业
 * <p>
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,null,2]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 */
public class MaxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        //本结点的高度为 左子树和右子树中高度的最大值+1;
        return Math.max(root.left == null ? 0 : maxDepth(root.left), root.right == null ? 0 : maxDepth(root.right)) + 1;
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
