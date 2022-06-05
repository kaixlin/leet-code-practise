package com.linkai.practise.greedy;

import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 示例 1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 *
 * 示例 2：
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 */
public class LeetCode135 {
    public static void main(String[] args) {
        example1();
        example2();
//        example3();
    }

    public static void example1() {
        int[] ratings = {1,0,2};
        int expected = 5;
        int actual = new LeetCode135().candy(ratings);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        int[] ratings = {1,2,2};
        int expected = 4;
        int actual = new LeetCode135().candy(ratings);
        System.out.println("示例2，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example3() {
        int[] ratings = {1,3,2,2,1};
        int expected = 7;
        int actual = new LeetCode135().candy(ratings);
        System.out.println("示例3，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public int candy2(int[] ratings) {
        int[] candyCounts = new int[ratings.length];
        Arrays.fill(candyCounts, 1);

        //从前向后
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyCounts[i] = candyCounts[i - 1] + 1;
            }
        }

        //从后向前
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] ) {
                candyCounts[i] = Math.max(candyCounts[i], candyCounts[i + 1] + 1);
            }
        }
        return Arrays.stream(candyCounts).sum();
    }

    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] candyCounts = new int[ratings.length];
        int leastCandyCount = ratings[1] < ratings[0] ? 2 : 1;
        candyCounts[0]= leastCandyCount;
        for (int i = 1; i < ratings.length; i++) {
            //如果发现当前评分小于前一个评分，并且之前的最低评分为1，则需要刷新之前的评分
            if (ratings[i] < ratings[i - 1] && leastCandyCount == 1) {
                for (int j = i - 1; j >= 0; j--) {
                    //如果当前评分比下一个评分小，则表明不需要进行刷新了。
                    if (ratings[j] <= ratings[j + 1]) {
                        break;
                    }
                    candyCounts[j] += 1;
                    //当前分配的数量累加1之后，判断上一个candyCount是否仍大于当前candyCount，如果仍大则可以终止
                    if (j - 1 >= 0 && candyCounts[j - 1] > candyCounts[j]) {
                        break;
                    }
                }
            }
            //如果当前评分小于等于上一个评分，则重置最低分配糖果数量为1
            if (ratings[i] <= ratings[i - 1]) {
                leastCandyCount = 1;
            } else {
                leastCandyCount++;
            }
            candyCounts[i] = leastCandyCount;
        }
        return Arrays.stream(candyCounts).sum();
    }
}
