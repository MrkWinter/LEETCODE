package day7;

/**
 * @author MrkWinter
 * @version 1.0
 * 2698. 求一个整数的惩罚数
 * 提示
 * 中等
 * 66
 * 相关企业
 * <p>
 * 给你一个正整数 n ，请你返回 n 的 惩罚数 。
 * <p>
 * n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
 * <p>
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：182
 * 解释：总共有 3 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * 因此，10 的惩罚数为 1 + 81 + 100 = 182
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 37
 * 输出：1478
 * 解释：总共有 4 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * - 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
 * 因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */

// 使用递归求数和
public class PunishmentNumber {
    private Boolean splitResult = false;

    public static void main(String[] args) {
        int i = new PunishmentNumber().punishmentNumber(10);
        System.out.println(i);
//        Boolean aBoolean = new PunishmentNumber().splitCanBeSum(10, 0, "1000");
//        System.out.println(aBoolean);

    }

    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (splitCanBeSum(i, 0,Integer.toString(i * i))) {
                sum += i*i;
            }
        }
        return sum;
    }

    public Boolean splitCanBeSum(int n, int sum, String tempSplit) {
        if (sum == n && tempSplit.equals(""))
            splitResult = true;
        int temp = sum;
        for (int i = 1; i <= tempSplit.length(); i++) {
            sum += Integer.parseInt(tempSplit.substring(0, i));
            splitCanBeSum(n, sum, tempSplit.substring(i));
            sum = temp;
        }
        return splitResult;
    }
}


class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i * i);
            if (dfs(s, 0, 0, i)) {
                res += i * i;
            }
        }
        return res;
    }

    public boolean dfs(String s, int pos, int tot, int target) {
        if (pos == s.length()) {
            return tot == target;
        }
        int sum = 0;
        for (int i = pos; i < s.length(); i++) {
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum + tot > target) {
                break;
            }
            if (dfs(s, i + 1, sum + tot, target)) {
                return true;
            }
        }
        return false;
    }
}