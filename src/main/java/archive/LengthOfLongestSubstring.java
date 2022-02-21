package archive;//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window



//leetcode submit region begin(Prohibit modification and deletion)
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuilder currentSubString = new StringBuilder();
        currentSubString.append(s.charAt(0));
        String longestSubString = currentSubString.toString();
        for (int i = 1; i < s.length(); i++) {
            int searchIndex = currentSubString.toString().indexOf(s.charAt(i));
            if (searchIndex == -1) {
                currentSubString.append(s.charAt(i));
            } else {
                currentSubString.delete(0, searchIndex + 1);
                currentSubString.append(s.charAt(i));
            }
            if (longestSubString.length() < currentSubString.length()) {
                longestSubString = currentSubString.toString();
            }
        }
        return longestSubString.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
