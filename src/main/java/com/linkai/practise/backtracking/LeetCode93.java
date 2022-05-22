package com.linkai.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 * 示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class LeetCode93 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        String s = "25525511135";
        List<String> expected = Arrays.asList("255.255.11.135","255.255.111.35");
        List<String> actual = new LeetCode93().restoreIpAddresses(s);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example2() {
        String s = "0000";
        List<String> expected = Arrays.asList("0.0.0.0");
        List<String> actual = new LeetCode93().restoreIpAddresses(s);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public static void example3() {
        String s = "101023";
        List<String> expected = Arrays.asList("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3");
        List<String> actual = new LeetCode93().restoreIpAddresses(s);
        System.out.println("示例3，输出结果：" + (Arrays.equals(expected.toArray(), actual.toArray()) ? "成功" : "失败"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtracking(s, 0, path, result);
        return result;
    }

    public void backtracking(String s, int startIndex, List<String> path, List<String> result) {

        if (path.size() == 4) {
            result.add(String.join(".", path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String subStr = s.substring(startIndex, i + 1);
            //如果已经有三个元素了，说明剩下的数字会构成一个元素，并且设置i为s.length
            if (path.size() == 3) {
                subStr = s.substring(startIndex);
                i = s.length();
            }
            if (!isValid(subStr)) {
                break;
            }
            path.add(subStr);
            backtracking(s, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     *  判断字符串是否有效
     */
    public boolean isValid(String str) {
        if (str.startsWith("0") && str.length() > 1) {
            return false;
        }
        if (str.length() > 3 || Integer.parseInt(str) > 255) {
            return false;
        }
        return true;
    }

}
