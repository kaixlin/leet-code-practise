package archive;//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
//
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
// 说明:
//
//
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
//
//
// 示例 1:
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3:
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4:
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5:
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false
// Related Topics 字符串 动态规划 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class IsMatch {

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        String s = "ab";
        String p = ".*c";
        System.out.println(isMatch.isMatch(s, p));
        s = "abab";
        p = ".*ab";
        System.out.println(isMatch.isMatch(s, p));
        s = "abab";
        p = "ab*ab";
        System.out.println(isMatch.isMatch(s, p));
        s = "abab";
        p = "ab*a.*b";
        System.out.println(isMatch.isMatch(s, p));
        s = "aaa";
        p = "a*a";
        System.out.println(isMatch.isMatch(s, p));
        s = "aaa";
        p = "aaaa";
        System.out.println(isMatch.isMatch(s, p));
        s = "aaa";
        p = ".*aa";
        System.out.println(isMatch.isMatch(s, p));
        s = "ss";
        p = "a";
        System.out.println(isMatch.isMatch(s, p));
        s = "aa";
        p = "a*";
        System.out.println(isMatch.isMatch(s, p));
        s = "ab";
        p = ".*";
        System.out.println(isMatch.isMatch(s, p));
        s = "aab";
        p = "c*a*b";
        System.out.println(isMatch.isMatch(s, p));
        s = "mississippi";
        p = "mis*is*p*.";
        System.out.println(isMatch.isMatch(s, p));
        s = "abcd";
        p = "d*";
        System.out.println(isMatch.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int patternProgress = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean isMatched = false;
            for (int j = patternProgress; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    patternProgress = j + 1;
                    isMatched = true;
                    break;
                }
                if (p.charAt(j) == '*') {
                    if (i > 0 && s.charAt(i - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        isMatched = true;
                        break;
                    }
                } else if (j >= p.length() - 1 || p.charAt(j + 1) != '*') {
                    break;
                }
            }

            if (!isMatched) {
                return false;
            }
        }

        if (patternProgress < p.length()) {
            if (p.charAt(patternProgress) != '*') {
                return false;
            }
            String restPattern = p.substring(patternProgress + 1);
            return s.endsWith(restPattern);
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
