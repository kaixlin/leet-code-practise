package com.linkai.practise.string;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 *
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class LeetCode459 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        String s = "abab";
        boolean expected = true;
        boolean actual = new LeetCode459().repeatedSubstringPattern(s);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        String s = "aba";
        boolean expected = false;
        boolean actual = new LeetCode459().repeatedSubstringPattern(s);
        System.out.println("示例2，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example3() {
        String s = "abcabcabcabc";
        boolean expected = true;
        boolean actual = new LeetCode459().repeatedSubstringPattern(s);
        System.out.println("示例3，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) {
            return false;
        }
        int[] nextPatternArray = getNextPatternArray(s);
        int maxPatternSize = nextPatternArray[nextPatternArray.length - 1];
        if (maxPatternSize >= s.length() - maxPatternSize && s.length() % (s.length() - maxPatternSize) == 0) {
            return true;
        }
        return false;
    }

    public int[] getNextPatternArray(String s) {
        int[] nextPatternArray = new int[s.length()];
        int j = 0;
        nextPatternArray[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = nextPatternArray[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            nextPatternArray[i] = j;
        }
        return nextPatternArray;
    }
}
