package com.linkai.practise.array;


/**
 * 【题目描述】
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
public class LeetCode704 {


    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        LeetCode704 solution = new LeetCode704();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int expected = 4;
        int actual = solution.search(nums, target);
        System.out.println("示例1，执行结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        LeetCode704 solution = new LeetCode704();
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        int expected = -1;
        int actual = solution.search2(nums, target);
        System.out.println("示例2，执行结果：" + (actual == expected ? "成功" : "失败"));
    }

    /**
     * 二分查找：左闭右闭区间的实现方式
     * @param nums 数组
     * @param target 匹配值
     * @return 查找值的下标
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 二分查找：左闭右开区间的查找方式
     * @param nums 数组
     * @param target 匹配值
     * @return 查找值的下标
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
