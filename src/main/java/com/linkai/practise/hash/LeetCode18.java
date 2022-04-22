package com.linkai.practise.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 *
 * 注意：
 * 答案中不可以包含重复的四元组。
 */
public class LeetCode18 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(-2,-1,1,2),
                Arrays.asList(-2,0,0,2), Arrays.asList(-1,0,0,1));
        List<List<Integer>> actual = new LeetCode18().fourSum(nums, target);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        List<List<Integer>> expected = Collections.singletonList(Arrays.asList(2,2,2,2));
        List<List<Integer>> actual = new LeetCode18().fourSum(nums, target);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        sortArray(nums);
        int left, right;
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                left = j + 1;
                right = nums.length - 1;

                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right -1]) {
                            right--;
                        }
                        left++;
                        right--;
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public void sortArray(int[] nums) {
        int minNum, minNumIndex;
        for (int i = 0; i < nums.length; i++) {
            minNum = nums[i];
            minNumIndex = i;
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
