package com.linkai.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class LeetCode40 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,1,6),
                Arrays.asList(1,2,5),
                Arrays.asList(1,7),
                Arrays.asList(2,6)
        );
        List<List<Integer>> actual = new LeetCode40().combinationSum2(candidates, target);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,2,2),
                Arrays.asList(5)
        );
        List<List<Integer>> actual = new LeetCode40().combinationSum2(candidates, target);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] used = new int[candidates.length];
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, used, path, result);
        return result;
    }

    public void backtracking(int[] candidates, int target, int startIndex, int[] used, List<Integer> path, List<List<Integer>> result) {
        int sum = path.stream().reduce(0, Integer::sum);
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <=  target; i++) {
            // used[i - 1] == 1，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == 0，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(candidates[i]);
            used[i] = 1;
            backtracking(candidates, target, i + 1, used, path, result);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
