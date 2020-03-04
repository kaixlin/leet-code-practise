//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

import java.util.*;


//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
//        int[] nums = {-1, -1, -2, 1};
//        int[] nums = {0, 0, 0};
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        int[] nums = {-1, -1 , 2, 1, -3};
        System.out.println(threeSum.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int leftIndex, rightIndex;
        for (int i = 0; i < nums.length - 2; i++) {
            leftIndex = i + 1;
            rightIndex = nums.length - 1;
            while(leftIndex < rightIndex) {

                if (nums[i] + nums[leftIndex] + nums[rightIndex] > 0) {
                    rightIndex--;
                    continue;
                }
                if (nums[i] + nums[leftIndex] + nums[rightIndex] < 0) {
                    leftIndex++;
                    continue;
                }

                if (nums[i] + nums[leftIndex] + nums[rightIndex] == 0) {
                    result.add(Arrays.asList(nums[i], nums[leftIndex], nums[rightIndex]));

                    while (leftIndex < nums.length - 1 && nums[leftIndex] == nums[leftIndex + 1]) {
                        leftIndex++;
                    }

                    while(rightIndex > 0 && nums[rightIndex] == nums[rightIndex - 1]) {
                        rightIndex--;
                    }
                    leftIndex++;
                    rightIndex--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> maps = new HashMap<Integer, List<Integer>>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (maps.containsKey(nums[j])) {
                    if (maps.get(nums[j]) != null &&
                            !maps.get(nums[j]).contains(j)) {
                        List<Integer> value = new ArrayList<Integer>();
                        value.add(nums[maps.get(nums[j]).get(0)]);
                        value.add(nums[maps.get(nums[j]).get(1)]);
                        value.add(nums[j]);
                        if (!results.contains(value)) {
                            results.add(value);
                        }
                    }
                } else {
                    int left = 0 - (nums[i] + nums[j]);
                    maps.put(left, Arrays.asList(i, j));
                }
            }
        }



        return results;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 && !results.contains(Arrays.asList(nums[i], nums[j], nums[k]))) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
