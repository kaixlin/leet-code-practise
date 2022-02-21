package archive;//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

//leetcode submit region begin(Prohibit modification and deletion)
class LongestPalindrome {

    public static void main(String[] args) {
        String input = "cbbd";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
//        String output = longestPalindrome.longestPalindrome(input);
        String output = longestPalindrome.longestPalindromeSolution2(input);
    }

    public String longestPalindromeSolution2(String s) {
        if (s.length() == 0) {
            return "";
        }
        int longestPalindromeBeginIndex = -1;
        int longestPalindromeEndIndex = -1;
        int[][] palindromeResults = new int[s.length()][s.length()];
        for (int i = 0; i < palindromeResults.length; i++) {
            for(int j = 0; j < palindromeResults.length; j++) {
                palindromeResults[i][j] = 0;
                if (i == j) {
                    palindromeResults[i][j] = 1;
                    longestPalindromeBeginIndex = i;
                    longestPalindromeEndIndex = j;
                }
            }
        }

        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 2) {
                        palindromeResults[i][j] = 1;
                        longestPalindromeBeginIndex = i;
                        longestPalindromeEndIndex = j;
                    } else if (palindromeResults[i + 1][j - 1] == 1) {
                        palindromeResults[i][j] = 1;
                        longestPalindromeBeginIndex = i;
                        longestPalindromeEndIndex = j;
                    }
                }
            }
        }
        return s.substring(longestPalindromeBeginIndex, longestPalindromeEndIndex + 1);
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int longestPalindromeLength = -1;
        int longestPalindromeIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j + 1 >  longestPalindromeLength && isPalindrome(s, j, i)) {
                    longestPalindromeLength = i - j + 1;
                    longestPalindromeIndex = j;
                }
            }
        }
        return s.substring(longestPalindromeIndex, longestPalindromeIndex + longestPalindromeLength);
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        int i = 0;
        while(true) {

            if (endIndex - i <= startIndex + i) {
                break;
            }
            if (s.charAt(endIndex - i) != s.charAt(startIndex + i)) {
                break;
            }
            i++;
        }
        return endIndex - i <= startIndex + i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
