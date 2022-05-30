package com.linkai.practise.backtracking;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class LeetCode47 {
    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] nums = {1,1,2};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,1,2),
                Arrays.asList(1,2,1),
                Arrays.asList(2,1,1)
        );
        List<List<Integer>> actual = new LeetCode47().permuteUnique(nums);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {1,2,3};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(1,3,2),
                Arrays.asList(2,1,3),
                Arrays.asList(2,3,1),
                Arrays.asList(3,1,2),
                Arrays.asList(3,2,1)
        );
        List<List<Integer>> actual = new LeetCode47().permuteUnique(nums);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
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

        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            //同一层存在相同节点则跳过
            if (numSet.contains(nums[i]) || used[i] == 1) {
                continue;
            }
            numSet.add(nums[i]);
            used[i] = 1;
            path.add(nums[i]);
            backtracking(nums, used, path, result);
            used[i] = 0;
            path.remove(path.size()  - 1);
        }
    }
}
