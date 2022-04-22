package com.linkai.practise.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 *  也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 示例：
 * 输入：19
 * 输出：true
 *
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 */
public class LeetCode202 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int n = 19;
        boolean expected = true;
        boolean actual = new LeetCode202().isHappy(n);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example2() {
        int n = 2;
        boolean expected = false;
        boolean actual = new LeetCode202().isHappy(n);
        System.out.println("示例2，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        int sum = n;
        while (!sumSet.contains(sum)) {
            sumSet.add(sum);
            sum = getSum(sum);
            if (sum == 1) {
                return true;
            }
        }
        return false;
    }

    public int getSum(int n) {
        int count = 10;
        int sum = 0;
        while ( n > 0) {
            sum += (n % count) * (n % count);
            n = n / count;
        }
        return sum;
    }
}

