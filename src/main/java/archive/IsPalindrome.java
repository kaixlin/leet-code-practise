package archive;//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1:
//
// 输入: 121
//输出: true
//
//
// 示例 2:
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3:
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 进阶:
//
// 你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学



//leetcode submit region begin(Prohibit modification and deletion)
class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(121));
        System.out.println(isPalindrome.isPalindrome(-121));
        System.out.println(isPalindrome.isPalindrome(10));
        System.out.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));

    }

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        boolean isPalindrome = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        boolean isPalindrome = true;
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
            if ((str.charAt(j) > 96 && str.charAt(j) < 123) || (str.charAt(j) > 47 && str.charAt(j) < 58)) {
                if((str.charAt(i) > 96 && str.charAt(i) < 123) || (str.charAt(i) > 47 && str.charAt(i) < 58)) {
                    if (str.charAt(i) != str.charAt(j)) {
                        isPalindrome = false;
                        break;
                    }
                    i++;
                    j--;
                } else {
                    i++;
                }
            } else {
                j--;
            }
        }
        return isPalindrome;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
