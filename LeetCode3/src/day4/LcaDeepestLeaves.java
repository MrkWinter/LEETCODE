package day4;

/**
 * @author MrkWinter
 * @version 1.0
 * 1123. 最深叶节点的最近公共祖先
 * 提示
 * 中等
 * 164
 * 相关企业
 * <p>
 * 给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
 * <p>
 * 回想一下：
 * <p>
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数将在 [1, 1000] 的范围内。
 * 0 <= Node.val <= 1000
 * 每个节点的值都是 独一无二 的。
 * 注意：本题与力扣 865 重复：https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class LcaDeepestLeaves {
    private int maxNUM = Integer.MIN_VALUE;
    private TreeNode minNode;

    public static void main(String[] args) {
        LcaDeepestLeaves lcaDeepestLeaves = new LcaDeepestLeaves();
//        TreeNode treeNode = new TreeNode(3);
//        TreeNode treeNode1 = new TreeNode(5);
//        TreeNode treeNode2 = new TreeNode(6);
//        TreeNode treeNode3 = new TreeNode(2);
//        TreeNode treeNode4 = new TreeNode(1);
//        TreeNode treeNode5 = new TreeNode(0);
//        TreeNode treeNode6 = new TreeNode(8);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode8 = new TreeNode(4);
//        treeNode.left = treeNode1;
//        treeNode.right = treeNode4;
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode4.left = treeNode5;
//        treeNode4.right = treeNode6;
//        treeNode3.left = treeNode7;
//        treeNode3.right = treeNode8;
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;


//        System.out.println(lcaDeepestLeaves.getDepth(treeNode));
        TreeNode treeNod = lcaDeepestLeaves.lcaDeepestLeaves(treeNode1);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        around(root, 0);
        return minNode;
    }

    //递归遍历得到最深根节点的最近公共祖先
    public void around(TreeNode node, int deep) {
        if (getDepth(node.left) == getDepth(node.right)) {
            int n = getDepth(node);
            if (deep + n > maxNUM) {
                maxNUM = deep + n;
                minNode = node;
            }
        }
        if (node.left != null) {
            around(node.left, deep + 1);
        }
        if (node.right != null) {
            around(node.right, deep + 1);
        }
    }

    //求当前子树的高度
    private int getDepth(TreeNode root) {
        if (root == null)
            return -1;
        return Math.max(root.left == null ? 0 : getDepth(root.left) + 1, root.right == null ? 0 : getDepth(root.right) + 1);
    }

    //通过最大深度寻找
    public TreeNode lcaDeepestLeaves1(TreeNode root) {
        return around1(root, 0, getDepth(root));
    }

    private TreeNode around1(TreeNode node, int deep, int maxD) {
        if (getDepth(node.left) == getDepth(node.right) && getDepth(node) + deep == maxD) {
            return node;
        }
        TreeNode treeNode = null;
        if (node.left != null) {
            treeNode = around1(node.left, deep + 1, maxD);
        }
        if (treeNode != null)
            return treeNode;
        if (node.right != null) {
            treeNode = around1(node.right, deep + 1, maxD);
        }
        return treeNode;
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
