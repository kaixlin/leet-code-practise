package archive;//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
//
// Related Topics 数组 双指针

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSumClosest {

    public static void main(String[] args) {
//        int[] nums = {-1, 2, 1, -4};
        int[] nums = {0,1,2};
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(nums, 3));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int result = Integer.MAX_VALUE;
        int minInterval = Integer.MAX_VALUE;
        int leftIndex, rightIndex;
        for (int i = 0; i < nums.length - 2; i++) {
            leftIndex = i + 1;
            rightIndex = nums.length - 1;
            while(leftIndex < rightIndex) {

                int sum = nums[i] + nums[leftIndex] + nums[rightIndex];
                int interval = target - sum;

                if (minInterval > Math.abs(interval)) {
                    result = sum;
                    minInterval = Math.abs(interval);
                }

                if (interval < 0) {
                    rightIndex--;
                    continue;
                }
                if (interval > 0) {
                    leftIndex++;
                    continue;
                }

                return sum;
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
