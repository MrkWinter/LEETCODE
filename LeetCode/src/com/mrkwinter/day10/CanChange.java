package com.mrkwinter.day10;

/**
 * @author MrkWinter
 * @version 1.0
 * 2337. 移动片段得到字符串
 * 提示
 * 中等
 * 79
 * 相关企业
 * <p>
 * 给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
 * <p>
 * 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
 * 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
 * <p>
 * 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：start = "_L__R__R_", target = "L______RR"
 * 输出：true
 * 解释：可以从字符串 start 获得 target ，需要进行下面的移动：
 * - 将第一个片段向左移动一步，字符串现在变为 "L___R__R_" 。
 * - 将最后一个片段向右移动一步，字符串现在变为 "L___R___R" 。
 * - 将第二个片段向右移动散步，字符串现在变为 "L______RR" 。
 * 可以从字符串 start 得到 target ，所以返回 true 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：start = "R_L_", target = "__LR"
 * 输出：false
 * 解释：字符串 start 中的 'R' 片段可以向右移动一步得到 "_RL_" 。
 * 但是，在这一步之后，不存在可以移动的片段，所以无法从字符串 start 得到 target 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：start = "_R", target = "R_"
 * 输出：false
 * 解释：字符串 start 中的片段只能向右移动，所以无法从字符串 start 得到 target 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == start.length == target.length
 * 1 <= n <= 105
 * start 和 target 由字符 'L'、'R' 和 '_' 组成
 */
public class CanChange {
    public static void main(String[] args) {
        String start =
                "__R_R_R_L",
                target =
                        "____RRR_L";
        boolean b = new CanChange().canChange(start, target);
        System.out.println(b);
    }

    public boolean canChange(String start, String target) {
        int i = 0;
        int j = 0;
        int length = start.length();
        while (i < length && j < length) {
            while (i < length - 1 && start.charAt(i) == '_') {
                i++;
            }
            while (j < length - 1 && target.charAt(j) == '_') {
                j++;
            }
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (i == length - 1) {
                while (++j < length) {
                    if (target.charAt(j) != '_')
                        return false;
                }
            } else if (j == length - 1) {
                while (++i < length) {
                    if (start.charAt(i) != '_')
                        return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }
//    public boolean canChange(String start, String target) {
//        int i = 0;
//        int j = 0;
//        int length = start.length();
//        char[] startArr = start.toCharArray();
//        while (i < length && i >= 0 && j < length) {
//            //找到字母
//            while (j < length-1 && target.charAt(j) == '_') {
//                j++;
//            }
//            while (i < length-1 && startArr[i] == '_') {
//                i++;
//            }
//            if (startArr[i] != target.charAt(j)) {
//                return false;
//            }
//            //字母 相等
//            //位置不等
//            if (startArr[i] == 'R' && i > j) {
//                return false;
//            } else if (startArr[i] == 'R' && i < j) { //查看是否可以向右移动到合适位置
//                int num = 1;
//                startArr[i] = '_';
//                while (startArr[++i] != 'L' && i < j) {
//                    if (startArr[i] == 'R') {
//                        startArr[i] = '_';
//                        num++;
//                    }
//                }
//                if (i != j) {
//                    return false;
//                }
//                while (i < length && startArr[i] != 'L' && num > 0) {
//                    if (startArr[i] == '_') {
//                        startArr[i] = 'R';
//                        num--;
//                    }
//                    i++;
//                }
//                if (num != 0) {
//                    return false;
//                }
//            } else if (startArr[i] == 'L' && i < j) {
//                return false;
//            } else if (startArr[i] == 'L' && i > j) { //查看是否可以向左移动到合适位置
//                startArr[i] = '_';
//                while (startArr[--i] != 'R' && i > j) {
//                    if (startArr[i] == 'L') {
//                        startArr[i] = '_';
//                    }
//                }
//                startArr[i] = 'L';
//                if (i != j) {
//                    return false;
//                }
//            }
//            i = ++j;
//        }
//        return true;
//    }
}
