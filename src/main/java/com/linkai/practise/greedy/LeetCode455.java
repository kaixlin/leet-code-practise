package com.linkai.practise.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，
 * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 示例 1:
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 *
 * 示例 2:
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 */
public class LeetCode455 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int expected = 1;
        int actual = new LeetCode455().findContentChildren(g, s);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        int[] g = {1,2};
        int[] s = {1,2,3};
        int expected = 2;
        int actual = new LeetCode455().findContentChildren(g, s);
        System.out.println("示例2，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public int findContentChildren(int[] g, int[] s) {
        g = Arrays.stream(g).sorted().toArray();
        s = Arrays.stream(s).sorted().toArray();
        int result = 0;
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                result++;
                index--;
            }
        }
        return result;
    }
}
