package com.linkai.practise.backtracking;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 *
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class LeetCode17 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        String digits = "23";
        List<String> expected = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        List<String> actual = new LeetCode17().letterCombinations(digits);
        System.out.println("示例1，输出结果：" + (expected.equals(actual) ? "成功" : "失败"));
    }

    public static void example2() {
        String digits = "";
        List<String> expected = new ArrayList<>();
        List<String> actual = new LeetCode17().letterCombinations(digits);
        System.out.println("示例2，输出结果：" + (expected.equals(actual) ? "成功" : "失败"));
    }

    public static void example3() {
        String digits = "2";
        List<String> expected = Arrays.asList("a","b","c");
        List<String> actual = new LeetCode17().letterCombinations(digits);
        System.out.println("示例3，输出结果：" + (expected.equals(actual) ? "成功" : "失败"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        Map<Character, String> dict = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");

        }};
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        backtracking(digits, 0, path, result, dict);
        return result;
    }

    public void backtracking(String digits, int startIndex, StringBuilder path, List<String> result, Map<Character, String> dict) {
        if (path.length() ==  digits.length()) {
            result.add(path.toString());
            return;
        }

        for (int i = startIndex; i < digits.length(); i++) {
            String algorithm = dict.get(digits.charAt(i));
            for (int j = 0; j < algorithm.length(); j++) {
                path.append(algorithm.charAt(j));
                backtracking(digits, i + 1, path, result, dict);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
