package day2;


import java.util.ArrayList;

/**
 * @author MrkWinter
 * @version 1.0
 * 449. 序列化和反序列化二叉搜索树
 * 中等
 * 449
 * 相关企业
 * <p>
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 */
public class Codec {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        Codec codec = new Codec();
        String serialize = codec.serialize(treeNode1);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        around(root, sb);
        return sb.toString();
    }

    private void around(TreeNode node, StringBuilder str) {
        str.append(node.val).append(" ");
        if (node.left != null) {
            around(node.left, str);
        }
        if (node.right != null) {
            around(node.right, str);
        }
    }

    // Decodes your encoded data to tree.
    //反序列化二叉树
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] s = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        for (int i = 1; i < s.length; i++) {
            addNode(Integer.parseInt(s[i]), root);
        }
        return root;
    }

    private void addNode(int value, TreeNode root) {
        while (true) {
            if (root.val >= value) {
                if (root.left == null) {
                    root.left = new TreeNode(value);
                    return;
                }
                root = root.left;
            }
            if (root.val < value) {
                if (root.right == null) {
                    root.right = new TreeNode(value);
                    return;
                }
                root = root.right;
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
