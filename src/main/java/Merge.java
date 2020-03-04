//给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1:
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
// Related Topics 排序 数组

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Merge {

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] intervals = { {1, 3}, {2, 6}, {8, 10}, {15, 18} };
        int[][] output = null; //
        output = merge.merge(intervals);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "," + output[i][1]);
        }
        int[][] intervals2 = { {1, 4}, {4, 5} };
        output = merge.merge(intervals2);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "," + output[i][1]);
        }
        int[][] intervals3 = { {1, 4}, {2, 3} };
        output = merge.merge(intervals3);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "," + output[i][1]);
        }
        int[][] intervals4 = { {2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10} };
        output = merge.merge(intervals4);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "," + output[i][1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        insertionSort(intervals);
        List<int[]> output = new ArrayList<>();
        int[] current = { intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = intervals[i][1] > current[1] ? intervals[i][1] : current[1];
            } else {
                output.add(current);
                current = new int[2];
                current[0] = intervals[i][0];
                current[1] = intervals[i][1];
            }
        }
        output.add(current);
        return output.toArray(new int[0][]);
    }

    public void insertionSort(int[][] intervals) {
        int[] temp = new int[2];
        for (int i = 1; i < intervals.length; i++) {
            for (int j = i; j > 0; j--) {
                if (intervals[j][0] < intervals[j - 1][0]) {
                    temp[0] = intervals[j][0];
                    temp[1] = intervals[j][1];
                    intervals[j][0] = intervals[j - 1][0];
                    intervals[j][1] = intervals[j - 1][1];
                    intervals[j - 1][0] = temp[0];
                    intervals[j - 1][1] = temp[1];
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
