package archive;//给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
// 示例 1:
//
// 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
//
//
// 示例 2:
//
// 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
//
// Related Topics 排序 数组

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Insert {

    public static void main(String[] args) {
        Insert insert = new Insert();
        int[][] intervals = { {1, 3}, {6, 9} };
        int[] newInterval = {2,5};
        int[][] output ;
        output= insert.insert(intervals, newInterval);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "," + output[i][1]);
        }
        int[][] intervals2 = { {1,2}, {3,5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        output = insert.insert(intervals2, newInterval2);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "," + output[i][1]);
        }
        int[][] intervals3 = { {1,5 }};
        int[] newInterval3 = {2, 7};
        output = insert.insert(intervals3, newInterval3);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "," + output[i][1]);
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) {
            return intervals;
        }
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int[][] newIntervals = new int[intervals.length + 1][2];
        int i = 0;
        while(i < intervals.length) {
            if (intervals[i][0] < newInterval[0] || intervals[i][0] == newInterval[0]
                    && intervals[i][1] < newInterval[1]) {
                newIntervals[i] = intervals[i];
            } else {
                break;
            }
            i++;
        }
        newIntervals[i] = newInterval;
        if (intervals.length - i >= 0)
            System.arraycopy(intervals, i, newIntervals, i + 1, intervals.length - i);

        List<int[]> output = new ArrayList<>();
        int[] temp = {newIntervals[0][0], newIntervals[0][1]};
        for (int j = 1; j < newIntervals.length; j++) {
            if (newIntervals[j][0] <= temp[1]) {
                temp[1] = newIntervals[j][1] > temp[1] ? newIntervals[j][1] : temp[1];
            } else {
                output.add(temp);
                temp = new int[2];
                temp[0] = newIntervals[j][0];
                temp[1] = newIntervals[j][1];
            }
        }
        output.add(temp);
        return output.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
