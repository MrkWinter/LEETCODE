package com.mrkwinter.day10;

import java.util.ArrayList;

/**
 * @author MrkWinter
 * @version 1.0
 * 383. 赎金信
 * 简单
 * 769
 * 相关企业
 * <p>
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class CanConstruct {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        boolean b = new CanConstruct().canConstruct(ransomNote, magazine);
        System.out.println(b);
    }

    //    public boolean canConstruct(String ransomNote, String magazine) {
//        char[] chars = magazine.toCharArray();
//        ArrayList<Character> characters = new ArrayList<>(chars.length);
//        for (int i = 0; i < chars.length; i++) {
//            characters.add(chars[i]);
//        }
//        for (int i = 0; i < ransomNote.length(); i++) {
//            Character c = ransomNote.charAt(i);
//            if(!characters.remove(c)) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        char c = '\u0000';
        boolean index = true;
        for (int i = 0; i < ransomNote.length(); i++) {
            c = ransomNote.charAt(i);
            index = false;
            for (int j = 0; j < chars.length; j++) {
                if(chars[j] == c) {
                    chars[j] = '\u0000';
                    index = true;
                    break;
                }
            }
            if(!index)
                return false;
        }
        return true;
    }
}
