package com.linkai.practise.queue;

import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class LeetCode239 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] expected = {3,3,5,5,6,7};
        int[] actual = new LeetCode239().maxSlidingWindow(nums, k);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected, actual) ? "成功" : "失败"));
    }

    public static void example2() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        int[] actual = new LeetCode239().maxSlidingWindow(nums, k);
        System.out.println("示例1，输出结果：" + (Arrays.equals(expected, actual) ? "成功" : "失败"));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        //先将前k的元素放入队列中
        for (int i = 0; i < k; i++) {
            //如果当前放入队列中的值比末尾的值大的话，将队尾的值取出来，直接不小于当前值或者队列为空为值
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.add(nums[i]);
        }
        result.add(deque.peekFirst());
        for (int i = k; i < nums.length; i++) {
            //窗口滑动的时候，需要判断一下窗口之前的元素是否等队头元素的值，如果等的话，需要将这个元素从队列中移除掉。
            if (!deque.isEmpty() && deque.peekFirst() == nums[i - k]) {
                deque.pop();
            }

            //如果当前放入队列中的值比末尾的值大的话，将队尾的值取出来，直接不小于当前值或者队列为空为值
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.add(nums[i]);
            result.add(deque.peekFirst());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
