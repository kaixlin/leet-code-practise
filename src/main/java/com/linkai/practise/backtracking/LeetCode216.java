package com.linkai.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * ● 只使用数字1到9
 * ● 每个数字 最多使用一次
 *
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 *
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 *
 * 示例 3:
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 */
public class LeetCode216 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        int n = 7;
        int k = 3;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,2,4));
        List<List<Integer>> actual = new LeetCode216().combinationSum3(k, n);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int n = 9;
        int k = 3;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,2,6),
                Arrays.asList(1,3,5),
                Arrays.asList(2,3,4));
        List<List<Integer>> actual = new LeetCode216().combinationSum3(k, n);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example3() {
        int n = 1;
        int k = 4;
        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> actual = new LeetCode216().combinationSum3(k, n);
        System.out.println("示例3，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking2(k, n, 1, path, result);
        return result;
    }

    public void backtracking(int k, int n, int startIndex, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            int sum = path.stream().reduce(0, Integer::sum);
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            backtracking(k, n, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public void backtracking2(int k, int n, int startIndex, List<Integer> path, List<List<Integer>> result) {
        //剪枝优化1：如果和大于给定的值则直接返回
        int sum = path.stream().reduce(0, Integer::sum);
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        //剪枝优化2：每层遍历大于（9 - （k - path.size()） + 1)就没有意义了
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking2(k, n, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
