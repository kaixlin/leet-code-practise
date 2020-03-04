//给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//
// 如果数组元素个数小于 2，则返回 0。
//
// 示例 1:
//
// 输入: [3,6,9,1]
//输出: 3
//解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
//
// 示例 2:
//
// 输入: [10]
//输出: 0
//解释: 数组元素个数小于 2，因此返回 0。
//
// 说明:
//
//
// 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
// 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
//
// Related Topics 排序



//leetcode submit region begin(Prohibit modification and deletion)
class MaximumGap {

    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        int[] nums = {3, 6, 9, 1};
        System.out.println(maximumGap.maximumGap(nums));
        int[] nums2 = {10};
        System.out.println(maximumGap.maximumGap(nums2));
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        insertionSort(nums);
        int gap = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > gap) {
                gap = nums[i] - nums[i -1];
            }
        }
        return gap;
    }

    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
