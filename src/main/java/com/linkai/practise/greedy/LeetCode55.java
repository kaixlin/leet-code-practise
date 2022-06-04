package com.linkai.practise.greedy;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class LeetCode55 {
    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] nums = {2,3,1,1,4};
        boolean expected = true;
        boolean actual = new LeetCode55().canJump(nums);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {3,2,1,0,4};
        boolean expected = false;
        boolean actual = new LeetCode55().canJump(nums);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public boolean canJump(int[] nums) {
        int maxJumpIndex = 0;
        for (int i = 0; i < nums.length && maxJumpIndex >= i; i++) {
            if (i + nums[i] > maxJumpIndex) {
                maxJumpIndex = i + nums[i];
            }
        }
        return maxJumpIndex >= nums.length - 1;
    }
}
