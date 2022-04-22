package com.linkai.practise.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 */
public class LeetCode454 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        int expected = 2;
        int actual = new LeetCode454().fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums1 = {0};
        int[] nums2 = {0};
        int[] nums3 = {0};
        int[] nums4 = {0};
        int expected = 1;
        int actual = new LeetCode454().fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println("示例2，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sum1Map = new HashMap<>();
        int count = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                sum1Map.computeIfPresent(num1 + num2, (key, value) -> value + 1);
                sum1Map.putIfAbsent(num1 + num2, 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int temp = -(num3 + num4);
                if (sum1Map.containsKey(temp)) {
                    count += sum1Map.get(temp);
                }
            }
        }
        return count;
    }
}
