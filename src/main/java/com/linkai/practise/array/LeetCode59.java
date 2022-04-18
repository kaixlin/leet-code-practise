package com.linkai.practise.array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 */
public class LeetCode59 {


    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int n = 3;
        int[][] expected = { {1,2,3}, {8,9,4}, {7,6,5}};
        int[][] actual = new LeetCode59().generateMatrix(n);
        System.out.println("示例1，输出结果：" + (isEqualed(actual, expected) ? "成功" : "失败"));
    }

    public static void example2() {
        int n = 1;
        int[][] expected = { {1} };
        int[][] actual = new LeetCode59().generateMatrix(n);
        System.out.println("示例1，输出结果：" + (isEqualed(actual, expected) ? "成功" : "失败"));
    }

    public static boolean isEqualed(int[][] actual, int[][] expected) {
        if (actual.length != expected.length) {
            return false;
        }
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                if (actual[i][j] != expected[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startX = 0, startY = 0; //定义每循环一个圈的起始位置
        int loop = n / 2; //循环的圈数
        int offset = 1; //每一圈循环都需要控制每一条边遍历的长度
        int count = 1; //用来给矩阵中每一个空格赋值
        int i, j;
        while (loop > 0) {
            i = startX;
            j = startY;

            //模拟填充上行从左到右
            for (j = startY; j < startY + n - offset; j++) {
                result[i][j] = count++;
            }

            //模拟填充右列从上到下
            for (i = startX; i < startX + n - offset; i++) {
                result[i][j] = count++;
            }

            //模拟填充下行从右到左
            for (; j > startY; j--) {
                result[i][j] = count++;
            }

            //模拟填充左列从下到上
            for (; i > startX; i--) {
                result[i][j] = count++;
            }

            //第二圈开始的时候，起始位置要各自加1
            startX++;
            startY++;

            // offset用于控制每一圈中每条边遍历的长度
            offset += 2;
            loop--;
        }

        // 如果n为奇数，则需要单独给矩阵最中间的位置赋值
        if ( n % 2 > 0) {
            int mid = n /2;
            result[mid] [mid] = count;
        }
        return result;
    }
}
