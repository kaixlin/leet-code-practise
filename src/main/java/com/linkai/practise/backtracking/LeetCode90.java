package com.linkai.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class LeetCode90 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] nums = {1,2,2};
        List<List<Integer>> expected = Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(1),
                Arrays.asList(1,2),
                Arrays.asList(1,2,2),
                Arrays.asList(2),
                Arrays.asList(2,2)
        );
        List<List<Integer>> actual = new LeetCode90().subsetsWithDup(nums);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {0};
        List<List<Integer>> expected = Arrays.asList(
                new ArrayList<>(),
                Arrays.asList(0)
        );
        List<List<Integer>> actual = new LeetCode90().subsetsWithDup(nums);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        backtracking(nums, 0, used, path, result);
        return result;
    }

    public void backtracking(int[] nums, int startIndex, int[] used, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            //过滤掉同层重复的节点
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            backtracking(nums, i + 1, used, path, result);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
