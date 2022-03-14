package com.linkai.practise.array;

/**
 * 【题目描述】
 *
 * 给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 * 示例 2：
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode27 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        LeetCode27 solution = new LeetCode27();
        int[] nums = {3,2,2,3};
        int val = 3;
        int expected = 2;
        int actual = solution.removeElement2(nums, val);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example2() {
        LeetCode27 solution = new LeetCode27();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int expected = 5;
        int actual = solution.removeElement2(nums, val);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    /**
     * 暴力解法
     * @param nums 元素数组
     * @param val 待删除元素
     * @return 删除后的数组大小
     */
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        //数组的大小随着元素删除在变化
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                //当往前移动的时候，i对应的元素也随之发生了变化，这时应该重新遍历判断
                i--;
                size--;
            }
        }
        return size;
    }

    /**
     * 双指针法
     * @param nums 元素数组
     * @param val 待删除元素
     * @return 删除后的数组大小
     */
    public int removeElement2(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                // 这个快慢指针的处理很巧妙，只有当值不相等的时候慢指针才更新
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
