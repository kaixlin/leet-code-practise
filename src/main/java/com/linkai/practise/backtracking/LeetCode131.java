package com.linkai.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class LeetCode131 {

    public static void main(String[] args) {
//        example1();
//        example2();
        example3();
    }

    public static void example1() {
        String s = "aab";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a","a","b"),
                Arrays.asList("aa","b")
        );
        List<List<String>> actual = new LeetCode131().partition(s);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        String s = "a";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );
        List<List<String>> actual = new LeetCode131().partition(s);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example3() {
        String s = "efe";
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("e","f","e"),
                Arrays.asList("efe")
        );
        List<List<String>> actual = new LeetCode131().partition(s);
        System.out.println("示例3，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtracking(s, 0, path, result);
        return result;
    }

    public void backtracking(String s, int startIndex, List<String> path, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String subStr = s.substring(startIndex, i + 1);
            if (!isPalindrome(subStr)) {
                continue;
            }
            path.add(subStr);
            backtracking(s, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex <= rightIndex) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

}
