package com.linkai.practise.string;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * 限制：
 * 1 <= k < s.length <= 10000
 */
public class LeetCodeJZOffer58 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        String s = "abcdefg";
        int n = 2;
        String expected = "cdefgab";
        String actual = new LeetCodeJZOffer58().reverseLeftWords(s, n);
        System.out.println("示例1，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example2() {
        String s = "lrloseumgh";
        int n = 6;
        String expected = "umghlrlose";
        String actual = new LeetCodeJZOffer58().reverseLeftWords(s, n);
        System.out.println("示例2，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder result = new StringBuilder(s);
        //反转前n个字符串
        reverse(result, 0, n - 1);

        //反转剩余的字符串
        reverse(result, n, s.length() - 1);

        //反转完成的字符串
        reverse(result, 0, s.length()  - 1);

        return result.toString();
    }

    public void reverse(StringBuilder sb, int left, int right) {
        char tempChar;
        while (left < right) {
            tempChar = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, tempChar);
            left++;
            right--;
        }
    }
}
