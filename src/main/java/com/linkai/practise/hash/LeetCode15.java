package com.linkai.practise.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意： 答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 */
public class LeetCode15 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1,-1,2));
        expected.add(Arrays.asList(-1,0,1));
        List<List<Integer>> actual = new LeetCode15().threeSum(nums);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {};
        List<List<Integer>> actual = new LeetCode15().threeSum(nums);
        System.out.println("示例2，输出结果：" + (actual.size() == 0 ? "成功" : "失败"));
    }

    public static void example3() {
        int[] nums = {0};
        List<List<Integer>> actual = new LeetCode15().threeSum(nums);
        System.out.println("示例3，输出结果：" + (actual.size() == 0 ? "成功" : "失败"));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        sortArray(nums);
        int left, right;
        for (int i = 0; i < nums.length; i++) {

            //去除重复集合（必须是跟前一个元素进行比较）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //去除重复的元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                    continue;
                }

                if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    private void sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minNum = nums[i];
            int minNumIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (minNum > nums[j]) {
                    minNum = nums[j];
                    minNumIndex = j;
                }
            }
            if (minNumIndex != i) {
                nums[minNumIndex] = nums[i];
                nums[i] = minNum;
            }
        }
    }
}
