package archive.binarysearch;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class SearchInsert {

    public static void main(String[] args) {
        int[] nums;
        int target = 0;
        SearchInsert searchInsert = new SearchInsert();

        nums = new int[]{1, 3, 5, 6};
        target = 5;
        System.out.println(searchInsert.searchInsert(nums, target));

        target = 2;
        System.out.println(searchInsert.searchInsert(nums, target));

        target = 7;
        System.out.println(searchInsert.searchInsert(nums, target));

        target = 0;
        System.out.println(searchInsert.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
