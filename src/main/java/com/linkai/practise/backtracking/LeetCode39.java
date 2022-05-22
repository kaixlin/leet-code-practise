package com.linkai.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 *
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
public class LeetCode39 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2,2,3),
                Arrays.asList(7)
        );
        List<List<Integer>> actual = new LeetCode39().combinationSum(candidates, target);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2,2,2,2),
                Arrays.asList(2,3,3),
                Arrays.asList(3,5)
        );
        List<List<Integer>> actual = new LeetCode39().combinationSum(candidates, target);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example3() {
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> actual = new LeetCode39().combinationSum(candidates, target);
        System.out.println("示例3，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking2(candidates, target, 0, path, result);
        return result;
    }

    public void backtracking(int[] candidates, int target,int startIndex, List<Integer> path, List<List<Integer>> result) {
        int sum = path.stream().reduce(0, Integer::sum);
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(candidates, target, i, path, result);
            path.remove(path.size() - 1);
        }
    }

    public void backtracking2(int[] candidates, int target,int startIndex, List<Integer> path, List<List<Integer>> result) {
        int sum = path.stream().reduce(0, Integer::sum);
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        //剪枝优化: 如果当前和加上下个元素的和大于target则跳过
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            backtracking2(candidates, target, i, path, result);
            path.remove(path.size() - 1);
        }
    }
}
