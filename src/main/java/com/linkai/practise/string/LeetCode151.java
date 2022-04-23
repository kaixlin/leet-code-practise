package com.linkai.practise.string;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class LeetCode151 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        String s = "the sky is blue";
        String expected = "blue is sky the";
        String actual = new LeetCode151().reverseWords(s);
        System.out.println("示例1，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example2() {
        String s = "  hello world!  ";
        String expected = "world! hello";
        String actual = new LeetCode151().reverseWords(s);
        System.out.println("示例2，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example3() {
        String s = "a good   example";
        String expected = "example good a";
        String actual = new LeetCode151().reverseWords(s);
        System.out.println("示例3，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        //去重头尾空格以及重复的空格
        int start = 0, end = s.length() - 1;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        while (end > 0 && s.charAt(end) == ' ') {
            end--;
        }
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') {
                continue;
            }
            result.append(s.charAt(i));
        }

        //反转字符串
        int left = 0, right = result.length() - 1;
        char tempChar;
        while (left < right) {
            tempChar = result.charAt(left);
            result.setCharAt(left, result.charAt(right));
            result.setCharAt(right, tempChar);
            left++;
            right--;
        }

        //反转单词
        int index = 0;
        while (index < result.length()) {
            left = index;
            while (index < result.length() && result.charAt(index) != ' ') {
                index++;
            }
            right = index - 1;
            while (left < right) {
                tempChar = result.charAt(left);
                result.setCharAt(left, result.charAt(right));
                result.setCharAt(right, tempChar);
                left++;
                right--;
            }
            index++;
        }
        return result.toString();
    }
}
