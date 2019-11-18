//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法



//leetcode submit region begin(Prohibit modification and deletion)
class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] num2 = {3,4};
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        findMedianSortedArrays.findMedianSortedArrays(nums1, num2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int medianIndex1 = totalLength % 2 == 0 ? totalLength/2 - 1 : -1;
        int median1 = 0;
        int medianIndex2 = totalLength / 2;
        int median2 = 0;
        int currentIndex = 0;
        int num1Index = 0;
        int num2Index = 0;
        int min = -1;
        while(currentIndex <= medianIndex2) {

            if (num1Index > nums1.length - 1) {
                min = nums2[num2Index];
                num2Index++;
            } else if (num2Index > nums2.length  - 1) {
                min = nums1[num1Index];
                num1Index++;
            } else if (nums1[num1Index] < nums2[num2Index]) {
                min = nums1[num1Index];
                num1Index++;
            } else {
                min = nums2[num2Index];
                num2Index++;
            }

            if (medianIndex1 == currentIndex) {
                median1 = min;
            }
            if (medianIndex2 == currentIndex) {
                median2 = min;
            }
            currentIndex++;
        }
        return medianIndex1 == -1 ? median2 : (median1 + median2 ) / 2.0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
