package com.linkai.practise.hash;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class LeetCode1 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] expected = {0,1};
        int[] actual = new LeetCode1().twoSum(nums, target);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected, actual) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {3,2,4};
        int target = 6;
        int[] expected = {1,2};
        int[] actual = new LeetCode1().twoSum(nums, target);
        System.out.println("示例2，输出结果：" + (Arrays.equals(expected, actual) ? "成功" : "失败"));
    }

    public static void example3() {
        int[] nums = {3,3};
        int target = 6;
        int[] expected = {0,1};
        int[] actual = new LeetCode1().twoSum(nums, target);
        System.out.println("示例3，输出结果：" + (Arrays.equals(expected, actual) ? "成功" : "失败"));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        int resultIndex1, resultIndex2;

        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexList = numMap.get(nums[i]);
            if (indexList == null) {
                indexList = new ArrayList<>();
                indexList.add(i);
                numMap.put(nums[i], indexList);
            } else {
                indexList.add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            resultIndex1 = i;
            if (numMap.containsKey(target - nums[i])) {
                List<Integer> indexList = numMap.get(target - nums[i]);
                for (Integer index : indexList) {
                    if (index != i) {
                        resultIndex2 = index;
                        return new int[]{resultIndex1, resultIndex2};
                    }
                }
            }
        }
        return null;
    }
}
