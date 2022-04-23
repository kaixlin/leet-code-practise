package com.linkai.practise.string;

import com.linkai.practise.linkedlist.ListNodeUtil;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 *
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class LeetCode541 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        String s = "abcdefg";
        int k = 2;
        String expected = "bacdfeg";
        String actual = new LeetCode541().reverseStr(s, k);
        System.out.println("示例1，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example2() {
        String s = "abcd";
        int k = 2;
        String expected = "bacd";
        String actual = new LeetCode541().reverseStr(s, k);
        System.out.println("示例2，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public String reverseStr(String s, int k) {
        int left, right;
        char[] sChars = s.toCharArray();
        char tempChar;
        for (int i = 0; i < sChars.length; i = i + 2 * k) {
            left = i;
            right = Math.min(i + k - 1, sChars.length - 1);
            while (left < right) {
                tempChar = sChars[left];
                sChars[left] = sChars[right];
                sChars[right] = tempChar;
                left++;
                right--;
            }
        }
        return new String(sChars);
    }
}
