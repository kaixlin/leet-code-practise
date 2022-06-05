package com.linkai.practise.greedy;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * ● 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 *
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 *
 * 示例 2：
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 *
 * 示例 3：
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 */
public class LeetCode1005 {

    public static void main(String[] args) {
//        example1();
//        example2();
        example3();
    }

    public static void example1() {
        int[] nums = {4,2,3};
        int k = 1;
        int expected = 5;
        int actual = new LeetCode1005().largestSumAfterKNegations(nums, k);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {3,-1,0,2};
        int k = 3;
        int expected = 6;
        int actual = new LeetCode1005().largestSumAfterKNegations(nums, k);
        System.out.println("示例2，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example3() {
        int[] nums = {2,-3,-1,5,-4};
        int k = 2;
        int expected = 13;
        int actual = new LeetCode1005().largestSumAfterKNegations(nums, k);
        System.out.println("示例3，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = Arrays.stream(nums).sorted().toArray();
        int index = 0;
        while (index < nums.length && index < k) {
            if (nums[index] >= 0) {
                break;
            }
            nums[index] = -nums[index];
            index++;
        }
        nums = Arrays.stream(nums).sorted().toArray();
        while (index < k) {
            nums[0] = -nums[0];
            index++;
        }
        return Arrays.stream(nums).sum();
    }

}
