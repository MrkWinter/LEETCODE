package day5;

import java.util.HashMap;

/**
 * @author MrkWinter
 * @version 1.0
 * 337. 打家劫舍 III
 * 中等
 * 1.8K
 * 相关企业
 * <p>
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树的节点数在 [1, 104] 范围内
 * 0 <= Node.val <= 104
 */
/*
//解题思路
//使用动态规划算法 + 二叉树的层次遍历
//1. 使用arraylist存储前n层树的最大偷窃数
//2. 当n = 1 时 arraylist[0] = root 值
//3. 当n = 2 时 arr[1] = 第2层值的总和 和 第1层的较大者
//4. 当n = 3 时 arr[2] = 第2层的值 与 第1层值 + 第三层值的较大者


使用后序遍历 加 动态规划的方法
 */
public class Rob {
    public static void main(String[] args) {

    }
    private HashMap<TreeNode, Integer> y = new HashMap<>();
    private HashMap<TreeNode, Integer> n = new HashMap<>();


    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(y.getOrDefault(root, 0), n.getOrDefault(root, 0));
    }
    //思路是由后序遍历y记录不包含该结点的最大值  n记录包含该结点的最大值
    //y 放入对应的node时  值为 node结点的值 + 左子树不包含该结点的最大值 + 柚子树不包含该结点的最大值
    //n 放入对应的node时  值为 左子树包含结点或不包含结点的较大值 + 右子树包含结点或不包含结点的较大值
    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        dfs(node.right);
        y.put(node, node.val + n.getOrDefault(node.left, 0) + n.getOrDefault(node.right, 0));
        n.put(node, Math.max(y.getOrDefault(node.left, 0) , n.getOrDefault(node.left, 0))+
                        Math.max(y.getOrDefault(node.right, 0) , n.getOrDefault(node.right, 0)));
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
