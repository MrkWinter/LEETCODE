package com.mrkwinter.day5;

import sun.misc.Queue;

import java.sql.RowId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author MrkWinter
 * @version 1.0
 * 199. 二叉树的右视图
 * 中等
 * 927
 * 相关企业
 * <p>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * <p>
 * 示例 3:
 * <p>
 * 输入: []
 * 输出: []
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
public class RightSideView {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode4;
        List<Integer> integers = new RightSideView().rightSideView(treeNode1);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<TreeNode> treeQueue = new ArrayList<>();
        ArrayList<Integer> viewInt = new ArrayList<>();
        if (root == null)
            return viewInt;
        treeQueue.add(root);
        int nodeNum = 1;
        int tempNum = 0;
        while (nodeNum !=0) {
            viewInt.add(treeQueue.get(nodeNum - 1).val);
            tempNum = nodeNum;
            nodeNum = 0;
            while (tempNum-- != 0) {
                TreeNode remove = treeQueue.remove(0);
                if (remove.left != null) {
                    nodeNum++;
                    treeQueue.add(remove.left);
                }
                if (remove.right != null) {
                    nodeNum++;
                    treeQueue.add(remove.right);
                }
            }
        }
        return viewInt;
    }
}