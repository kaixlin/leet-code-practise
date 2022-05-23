package com.linkai.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class LeetCode78 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] nums = {1,2,3};
        List<List<Integer>> expected = Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(1),
                Arrays.asList(1,2),
                Arrays.asList(1,2,3),
                Arrays.asList(1,3),
                Arrays.asList(2),
                Arrays.asList(2,3),
                Arrays.asList(3)
        );
        List<List<Integer>> actual = new LeetCode78().subsets(nums);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {0};
        List<List<Integer>> expected = Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(0)
        );
        List<List<Integer>> actual = new LeetCode78().subsets(nums);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, path, result);
        return result;
    }

    public void backtracking(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> result) {
        //处理子集要放在终止条件上面
        result.add(new ArrayList<>(path));
        if (path.size() >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
