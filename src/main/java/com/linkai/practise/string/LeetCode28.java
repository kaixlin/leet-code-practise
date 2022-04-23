package com.linkai.practise.string;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
public class LeetCode28 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        String haystack = "hello";
        String needle = "ll";
        int expected = 2;
        int actual = new LeetCode28().strStr(haystack, needle);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        String haystack = "aaaaa";
        String needle = "bba";
        int expected = -1;
        int actual = new LeetCode28().strStr(haystack, needle);
        System.out.println("示例2，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example3() {
        String haystack = "";
        String needle = "";
        int expected = 0;
        int actual = new LeetCode28().strStr(haystack, needle);
        System.out.println("示例3，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] nextPatternArray = buildNextPatternArray(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = nextPatternArray[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }

            if (j == needle.length()) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    public int[] buildNextPatternArray(String needle) {
        int[] nextPatternArray = new int[needle.length()];
        int j = 0;
        nextPatternArray[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = nextPatternArray[j - 1];
            }

            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }
            nextPatternArray[i] = j;
        }
        return nextPatternArray;
    }
}
