package com.linkai.practise.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 *
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 *
 * 说明: 你可以假设字符串只包含小写字母。
 */
public class LeetCode242 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        String s = "anagram";
        String t = "nagaram";
        boolean expected = true;
        boolean actual = new LeetCode242().isAnagram(s, t);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example2() {
        String s = "rat";
        String t = "car";
        boolean expected = false;
        boolean actual = new LeetCode242().isAnagram(s, t);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> dictionary = new HashMap<>();
        for (char ch : s.toCharArray()) {
            dictionary.computeIfPresent(ch, (key, value) -> value + 1);
            dictionary.putIfAbsent(ch, 1);
        }

        for (char ch : t.toCharArray()) {
            if (!dictionary.containsKey(ch)) {
                return false;
            }
            if (dictionary.get(ch) > 1) {
                dictionary.computeIfPresent(ch, (key, value) -> value - 1);
            } else {
                dictionary.remove(ch);
            }
        }
        return dictionary.size() == 0;
    }
}
