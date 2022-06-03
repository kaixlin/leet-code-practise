package com.linkai.practise.backtracking;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 */
public class LeetCode51 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int n = 4;
        List<List<String>> expected = Arrays.asList(
                Arrays.asList(".Q..","...Q","Q...","..Q."),
                Arrays.asList("..Q.","Q...","...Q",".Q..")
        );
        List<List<String>> actual = new LeetCode51().solveNQueens(n);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        int n = 1;
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("Q")
        );
        List<List<String>> actual = new LeetCode51().solveNQueens(n);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<List<String>> chessboard = new ArrayList<>(n);
        for (int row = 0; row < n; row++) {
            List<String> chessboardRow = new ArrayList<>(n);
            for (int col = 0; col < n; col++) {
                chessboardRow.add(".");
            }
            chessboard.add(chessboardRow);
        }
        backtracking(n, 0, chessboard, result);
        return result;
    }

    public void backtracking(int n, Integer row, List<List<String>> chessboard, List<List<String>> result) {
        if (row == n) {
            List<String> path = chessboard.stream()
                    .map(chessboardLine -> chessboardLine.stream().reduce(String::concat).orElse(null))
                    .collect(Collectors.toList());
            result.add(path);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(col, row, chessboard, n)) {
                chessboard.get(row).set(col, "Q");
                backtracking(n, row + 1, chessboard, result);
                chessboard.get(row).set(col, ".");
            }
        }
    }

    private boolean isValid(int col, int row, List<List<String>> chessboard, int n) {
        //当前行不存在Q
        for (int i = 0; i < n; i++) {
            if ("Q".equals(chessboard.get(i).get(col))) {
                return false;
            }
        }

        //当前列不存在Q
        for (int i = 0; i < n; i++) {
            if ("Q".equals(chessboard.get(row).get(i))) {
                return false;
            }
        }
        //45度角存在Q
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(chessboard.get(i).get(j))) {
                return false;
            }
        }
        //135度角存在Q
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if ("Q".equals(chessboard.get(i).get(j))) {
                return false;
            }
        }
        return true;
    }
}
