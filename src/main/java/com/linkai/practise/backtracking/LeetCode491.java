package com.linkai.practise.backtracking;

import java.util.*;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * 示例 1：
 * 输入：nums = [4,7,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 *
 * 示例 2：
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 */
public class LeetCode491 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] nums = {4,6,7,7};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(4,6),
                Arrays.asList(4,6,7),
                Arrays.asList(4,6,7,7),
                Arrays.asList(4,7),
                Arrays.asList(4,7,7),
                Arrays.asList(6,7),
                Arrays.asList(6,7,7),
                Arrays.asList(7,7)
        );
        List<List<Integer>> actual = new LeetCode491().findSubsequences(nums);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {4,4,3,2,1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(4,4)
        );
        List<List<Integer>> actual = new LeetCode491().findSubsequences(nums);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, path, result);
        return result;
    }

    public void backtracking(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> result) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        if (startIndex >= nums.length) {
            return;
        }

        Set<Integer> usedNums = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //过滤掉非递增的元素
            if (i > 0 && path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            //过滤掉同层重复的元素
            if (usedNums.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            //记录这个元素在本层用过了，本层后面不能再用了
            usedNums.add(nums[i]);
            backtracking(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
