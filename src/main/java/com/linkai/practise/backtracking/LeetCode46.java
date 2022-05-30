package com.linkai.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class LeetCode46 {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        int[] nums = {1,2,3};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(1,3,2),
                Arrays.asList(2,1,3),
                Arrays.asList(2,3,1),
                Arrays.asList(3,1,2),
                Arrays.asList(3,2,1)
        );
        List<List<Integer>> actual = new LeetCode46().permute(nums);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {0,1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,0)
        );
        List<List<Integer>> actual = new LeetCode46().permute(nums);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example3() {
        int[] nums = {1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );
        List<List<Integer>> actual = new LeetCode46().permute(nums);
        System.out.println("示例3，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] used = new int[nums.length];
        backtracking(nums, used, path, result);
        return result;
    }

    public void backtracking(int[] nums, int[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            path.add(nums[i]);
            backtracking(nums, used, path, result);
            used[i] = 0;
            path.remove(path.size()  - 1);
        }
    }
}
