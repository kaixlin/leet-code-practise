package com.linkai.practise.greedy;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class LeetCode45 {
    public static void main(String[] args) {
        example1();
        example2();
//        example3();
    }

    public static void example1() {
        int[] nums = {2,3,1,1,4};
        int expected = 2;
        int actual = new LeetCode45().jump(nums);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {2,3,0,1,4};
        int expected = 2;
        int actual = new LeetCode45().jump(nums);
        System.out.println("示例2，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example3() {
        int[] nums = {2,3,1};
        int expected = 2;
        int actual = new LeetCode45().jump(nums);
        System.out.println("示例2，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public int jump(int[] nums) {
        int step = 0;
        int i = 0;
        while (i < nums.length - 1) {
                //跳跃步数增加1
            step++;
            //计算最大跳跃步数得出下一步的index
            int maxJumpIndex = 0;
            int nextIndex = 0;
            //如果当前跳到达终点，则直接进行标记
            if (i + nums[i] >= nums.length - 1) {
                nextIndex = i + nums[i];
            } else {
                //否则计算下一步最大跳跃index
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j + nums[i + j] >= maxJumpIndex) {
                        maxJumpIndex = i + j + nums[i + j];
                        nextIndex = i + j;
                    }
                }
            }
            i = nextIndex;
        }
        return step;
    }
}
