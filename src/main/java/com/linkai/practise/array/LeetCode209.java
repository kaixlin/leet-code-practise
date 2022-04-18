package com.linkai.practise.array;

/**
 * 【题目描述】
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class LeetCode209 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int expected = 2;
        int actual = new LeetCode209().minSubArrayLen2(target, nums);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {1,4,4};
        int target = 1;
        int expected = 1;
        int actual = new LeetCode209().minSubArrayLen2(target, nums);
        System.out.println("示例2，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example3() {
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        int expected = 0;
        int actual = new LeetCode209().minSubArrayLen2(target, nums);
        System.out.println("示例3，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum +=  nums[j];
                if (sum >= target && minCount > j - i + 1) {
                    minCount = j - i + 1;
                    break;
                }
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int minCount = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                if (minCount > j - i + 1) {
                    minCount = j - i + 1;
                }
                sum -= nums[i];
                i++;
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}
