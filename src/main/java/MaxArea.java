//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例:
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class MaxArea {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(height));
    }

    public int maxArea(int[] height) {
        int beginIndex = 0;
        int endIndex = height.length - 1;
        int maxArea = 0;
        while(beginIndex < endIndex) {
            int area = (endIndex - beginIndex) * min(height[beginIndex], height[endIndex]);
            if (maxArea < area) {
                maxArea = area;
            }
            if (height[beginIndex] < height[endIndex]) {
                beginIndex++;
            } else {
                endIndex--;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * min(height[j], height[i]);
                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }



    private int min(int value1, int value2) {
        return value1 < value2 ? value1 : value2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
