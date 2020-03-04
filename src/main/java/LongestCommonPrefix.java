//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs1));
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs2));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        String shortestStr = findShortestStr(strs);
        String longestCommonPrefix = shortestStr;
        while(true) {
            if (longestCommonPrefix.equals("")) {
                break;
            }
            boolean isPrefix = true;
            for (String str : strs) {
                if (!str.startsWith(longestCommonPrefix)) {
                    isPrefix = false;
                    break;
                }
            }
            if (isPrefix) {
                break;
            } else {
                longestCommonPrefix = longestCommonPrefix.substring(0, longestCommonPrefix.length() - 1);
            }
        }
        return longestCommonPrefix;
    }

    private String findShortestStr(String[] strs) {
        String shortestStr = strs[0];
        int shortestStrLength = strs[0].length();
        for (String str : strs) {
            if (shortestStrLength < str.length()) {
                shortestStr = str;
                shortestStrLength = str.length();
            }
        }
        return shortestStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
