package com.linkai.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class LeetCode77 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int n = 4;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(1,3),
                Arrays.asList(1,4),
                Arrays.asList(2,3),
                Arrays.asList(2,4),
                Arrays.asList(3,4));
        int k = 2;
        List<List<Integer>> actual = new LeetCode77().combine(n, k);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int n = 1;
        int k = 1;
        List<List<Integer>> expected = Collections.singletonList(
                Collections.singletonList(1));
        List<List<Integer>> actual = new LeetCode77().combine(n, k);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking2(n, k, 1, path, result);
        return result;
    }

    public void backtracking(int n, int k, int startIndex, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public void backtracking2(int n, int k, int startIndex, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        //剪枝优化：每层遍历如果大于n - (k - path.size()) + 1就没有意义了
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking2(n, k, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
