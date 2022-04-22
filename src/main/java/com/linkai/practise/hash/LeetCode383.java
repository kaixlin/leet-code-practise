package com.linkai.practise.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class LeetCode383 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        String ransomNote = "a";
        String magazine = "b";
        boolean expected = false;
        boolean actual = new LeetCode383().canConstruct(ransomNote, magazine);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example2() {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean expected = false;
        boolean actual = new LeetCode383().canConstruct(ransomNote, magazine);
        System.out.println("示例2，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example3() {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean expected = true;
        boolean actual = new LeetCode383().canConstruct(ransomNote, magazine);
        System.out.println("示例3，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();

        for (char magazineChar : magazine.toCharArray()) {
            magazineMap.computeIfPresent(magazineChar, (key ,value) -> value + 1);
            magazineMap.putIfAbsent(magazineChar, 1);
        }

        for (char ransomNoteChar : ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(ransomNoteChar)) {
                return false;
            }
            int magazineCharCount = magazineMap.get(ransomNoteChar);
            if (magazineCharCount == 1) {
                magazineMap.remove(ransomNoteChar);
            } else {
                magazineMap.computeIfPresent(ransomNoteChar, (key, value) -> value - 1);
            }
        }
        return true;
    }
}
