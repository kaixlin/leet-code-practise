//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。
//
// 示例 1:
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//
// 示例 2:
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//
// 说明:
//
//
// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//
// Related Topics 数学 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class Divide {

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        Divide divide = new Divide();
//        System.out.println(divide.divide(dividend, divisor));
//        dividend = 7;
//        divisor = -3;
//        System.out.println(divide.divide(dividend, divisor));
//        dividend = -2147483648;
//        divisor = -1;
//        System.out.println(divide.divide(dividend, divisor));
//        dividend = -2147483648;
//        divisor = 2;
        System.out.println(divide.divide(dividend, divisor));
        dividend = -1010369383;
        divisor =  -2147483648;
        System.out.println(divide.divide(dividend, divisor));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        int sign = 1;
        if (divisor < 0 && dividend > 0 || (divisor > 0 && dividend < 0)) {
            sign = -1;
        }
        long absDividend = dividend;
        long absDivisor = divisor;

        absDividend = absDividend > 0 ? absDividend : -absDividend;
        absDivisor = absDivisor > 0 ? absDivisor : -absDivisor;


        if (absDividend < absDivisor) {
            return 0;
        }

        long result = div(absDividend, absDivisor);

        return sign == -1 ? - (int) result : (int) result;
    }

    private long div(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long sum = divisor;
        long count = 1;
        while (true) {
            if (sum + sum > dividend || sum + sum < 0) {
                break;
            }
            count += count;
            sum += sum;
        }
        return count + div(dividend - sum, divisor);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
