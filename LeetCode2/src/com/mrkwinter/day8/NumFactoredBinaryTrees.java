package com.mrkwinter.day8;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 823. 带因子的二叉树
 * 中等
 * 143
 * 相关企业
 * <p>
 * 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
 * <p>
 * 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 * <p>
 * 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: arr = [2, 4]
 * 输出: 3
 * 解释: 可以得到这些二叉树: [2], [4], [4, 2, 2]
 * <p>
 * 示例 2:
 * <p>
 * 输入: arr = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * 2 <= arr[i] <= 109
 * arr 中的所有值 互不相同
 */
public class NumFactoredBinaryTrees {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 10};
        int i = new NumFactoredBinaryTrees().numFactoredBinaryTrees1(arr);
        System.out.println(i);
    }
    public int numFactoredBinaryTrees1(int[] arr){
        Arrays.sort(arr);
        long[] treeNum = new long[arr.length];
        Arrays.fill(treeNum, 1);
        long sum = 0;long MOD = 1000000007;
        //取得的根
        for (int i = 0; i < arr.length; i++) {
            //从根前面得到的第一个乘数
            for (int j = 0; j < i; j++) {
                //从根前面得到的第二个乘数
                for (int k = j; k < i&&(long)arr[k]*arr[j]<=arr[i]; k++) {
                    if ((long)arr[j] * arr[k] == arr[i]) {
                        if (j == k) {
                            treeNum[i] = (treeNum[i] + treeNum[j] * treeNum[k])%MOD;
                        } else {
                            treeNum[i] = (treeNum[i] + 2 * treeNum[j] * treeNum[k])%MOD;
                        }
                    }
                }
            }
            sum = (sum + treeNum[i]) % MOD;
        }
        return (int) sum;
    }
    public int numFactoredBinaryTrees2(int[] arr) {
        Arrays.sort(arr);
        long[] treeNum = new long[arr.length];
        Arrays.fill(treeNum, 1);
        long sum = 0;
        long MOD = 1000000007;
        //取得的根
        for (int i = 0; i < arr.length; i++) {
            //从根前面得到的第一个乘数
            for (int left = 0, right = i - 1; left <= right; left++) {
                while (left <= right && (long)arr[left] * arr[right] > arr[i]) {
                    right--;
                }
                if(left<=right&&(long)arr[left]*arr[right]==arr[i]) {
                    if (left == right) {
                        treeNum[i] = (treeNum[i] + treeNum[left] * treeNum[right])%MOD;
                    } else {
                        treeNum[i] = (treeNum[i] + 2 * treeNum[left] * treeNum[right])%MOD;
                    }
                }
            }
            sum = (sum + treeNum[i]) % MOD;
        }
        return (int) sum;
    }
}
