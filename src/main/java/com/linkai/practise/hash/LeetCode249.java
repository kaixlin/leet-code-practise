package com.linkai.practise.hash;

import java.util.*;

/**
 * 题意：给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 * 说明： 输出结果中的每个元素一定是唯一的。 我们可以不考虑输出结果的顺序。
 */
public class LeetCode249 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] expected = {2};
        int[] actual = new LeetCode249().intersection(nums1, nums2);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected, actual) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] expected = {9,4};
        int[] actual = new LeetCode249().intersection(nums1, nums2);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected, actual) ? "成功" : "失败"));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums1) {
            nums1Set.add(num);
        }
        for (int num : nums2) {
            if (nums1Set.contains(num)) {
                result.add(num);
                nums1Set.remove(num);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
