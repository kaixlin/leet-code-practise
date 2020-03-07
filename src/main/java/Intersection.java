//给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1:
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
//
//
// 示例 2:
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [9,4]
//
// 说明:
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 排序 哈希表 双指针 二分查找


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Intersection {

    public static void main(String[] args) {
        int[] nums1 = {4, 9 ,5};
        int[] nums2 = {9,4 , 9, 8, 4};
        Intersection intersection = new Intersection();
        int[] result = null;
        result = intersection.intersection(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        int[] nums11 = {1,2,2,1};
        int[] nums21 = {2,2};
        result = intersection .intersection(nums11, nums21);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        insertionSort(nums1);
        insertionSort(nums2);
        Set<Integer> result = new HashSet<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                    i++;
            } else if (nums1[i] > nums2[j]) {
                    j++;
            }
        }
        return result.stream().mapToInt(value -> value).toArray();
    }

    public void insertionSort(int[] nums) {
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
