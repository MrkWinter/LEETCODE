package com.mrkwinter.day10;

import java.util.Stack;

/**
 * @author MrkWinter
 * @version 1.0
 * 20. 有效的括号
 * 提示
 * 简单
 * 4.1K
 * 相关企业
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class IsValid {
    public static void main(String[] args) {
        boolean valid = new IsValid().isValid("(d{d}d[d]d[d]d{dd})");
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                charStack.push(chars[i]);
            } else if(chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                if (!charStack.empty()) {
                    Character pop = charStack.pop();
                    if(pop == '(')
                        pop = ')';
                    else if(pop =='{')
                        pop = '}';
                    else if (pop == '[')
                        pop = ']';
                    if(pop != chars[i])
                        return false;
                } else
                    return false;
            }
        }
        return charStack.empty();
    }
}
