package com.mrkwinter.day6;

/**
 * @author MrkWinter
 * @version 1.0
 * 125. 验证回文串
 * 简单
 * 670
 * 相关企业
 * <p>
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 */
public class IsPalindrome {
    public static void main(String[] args) {
        boolean abA = new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(abA);
    }

    //    public boolean isPalindrome(String s) {
//        String s1 = s.replaceAll("\\W*[_]*", "");
//        boolean flag = true;
//        char a = '\u0000';
//        char b = '\u0000';
//        for (int i = 0, j = s1.length() - 1; i < s1.length(); i++, j--) {
//            a = s1.charAt(i);
//            b = s1.charAt(j);
//            if (Character.isDigit(a) && Character.isDigit(b)) {
//                if (a != b)
//                    flag = false;
//            } else if (Character.isLetter(a) && Character.isLetter(b)) {
//                if (Character.toUpperCase(a) != Character.toUpperCase(b)) {
//                    flag = false;
//                }
//            } else  {
//                flag = false;
//            }
//        }
//        return flag;
//    }
    public boolean isPalindrome(String s) {
        s = s.replaceAll("\\W*[_]*", "");
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = s.length()-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        if (s.equalsIgnoreCase(sb.toString()))
            return true;
        return false;
    }
}
