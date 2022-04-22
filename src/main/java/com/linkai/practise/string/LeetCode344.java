package com.linkai.practise.string;

import com.linkai.practise.linkedlist.ListNodeUtil;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 $O(1)$ 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class LeetCode344 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        char[] actual = {'h','e','l','l','o'};
        char[] expected = {'o','l','l','e','h'};
        new LeetCode344().reverseString(actual);
        System.out.println("示例1，输出结果：" + (Arrays.equals(actual, expected) ? "成功" : "失败"));
    }

    public static void example2() {
        char[] actual = {'H','a','n','n','a','h'};
        char[] expected = {'h','a','n','n','a','H'};
        new LeetCode344().reverseString(actual);
        System.out.println("示例2，输出结果：" + (Arrays.equals(actual, expected) ? "成功" : "失败"));
    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        char tempChar;
        while (left < right) {
            tempChar = s[left];
            s[left] = s[right];
            s[right] = tempChar;
            left++;
            right--;
        }
    }
}
