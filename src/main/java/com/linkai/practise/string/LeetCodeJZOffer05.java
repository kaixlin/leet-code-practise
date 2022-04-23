package com.linkai.practise.string;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class LeetCodeJZOffer05 {

    public static void main(String[] args) {
        example1();
    }

    public static void example1() {
        String s = "We are happy.";
        String expected = "We%20are%20happy.";
        String actual = new LeetCodeJZOffer05().replaceSpace(s);
        System.out.println("示例1，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                result.append("%20");
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
