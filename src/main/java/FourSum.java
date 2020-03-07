//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
// 注意：
//
// 答案中不可以包含重复的四元组。
//
// 示例：
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
//
// Related Topics 数组 哈希表 双指针

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//leetcode submit region begin(Prohibit modification and deletion)
class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int[] nums =  {-1,0,-5,-2,-2,-4,0,1,-2};
        int target = -9;
        System.out.println(fourSum.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int leftIndex = j + 1;
                int rightIndex = nums.length - 1;
                int sum = -1;
                while (leftIndex < rightIndex) {
                    sum = nums[i] + nums[j] + nums[leftIndex] + nums[rightIndex];

                    if (sum == target) {
                        output.add(Arrays.asList(nums[i], nums[j], nums[leftIndex], nums[rightIndex]));
                        while(leftIndex < nums.length - 1 && nums[leftIndex + 1] == nums[leftIndex]) {
                            leftIndex++;
                        }

                        while(rightIndex > 0 && nums[rightIndex - 1] == nums[rightIndex]) {
                            rightIndex--;
                        }

                        leftIndex++;
                        rightIndex--;
                    }

                    if (sum > target) {
                        rightIndex--;
                    }

                    if (sum < target) {
                        leftIndex++;
                    }
                }
                while ( j < nums.length -1 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }

            while ( i  < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
