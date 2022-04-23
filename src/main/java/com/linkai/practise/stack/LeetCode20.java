package com.linkai.practise.stack;

import com.linkai.practise.linkedlist.ListNodeUtil;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * ● 左括号必须用相同类型的右括号闭合。
 * ● 左括号必须以正确的顺序闭合。
 * ● 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class LeetCode20 {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
    }

    public static void example1() {
        String s = "()";
        boolean expected = true;
        boolean actual = new LeetCode20().isValid(s);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example2() {
        String s = "()[]{}";
        boolean expected = true;
        boolean actual = new LeetCode20().isValid(s);
        System.out.println("示例2，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example3() {
        String s = "(]";
        boolean expected = false;
        boolean actual = new LeetCode20().isValid(s);
        System.out.println("示例3，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example4() {
        String s = "([)]";
        boolean expected = false;
        boolean actual = new LeetCode20().isValid(s);
        System.out.println("示例4，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example5() {
        String s = "{[]}";
        boolean expected = true;
        boolean actual = new LeetCode20().isValid(s);
        System.out.println("示例5，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case ')':
                    if (characterStack.isEmpty() || '(' != characterStack.pop()) {
                        return false;
                    }
                    break;
                case ']':
                    if (characterStack.isEmpty() || '[' != characterStack.pop()) {
                        return false;
                    }
                    break;
                case '}':
                    if (characterStack.isEmpty() || '{' != characterStack.pop()) {
                        return false;
                    }
                    break;
                default:
                    characterStack.push(ch);
            }
        }
        return characterStack.isEmpty();
    }
}
