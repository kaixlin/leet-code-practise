package archive;//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
// Related Topics 数学 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class Multiply {

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        String num1 = "2";
        String num2 = "3";
//        System.out.println(multiply.multiply(num1, num2));
        num1 = "123";
        num2 = "456";
        System.out.println(multiply.multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        String output;
        int maxLength = num1.length() + num2.length();
        int carry = 0;
        int current = 0;
        int sum = 0;
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < maxLength; i++) {
            sum = carry;
            for (int j = 0; j <= i; j++) {
                n1 = j >= num1.length() ? 0 : num1.charAt(num1.length() - 1 - j) - 48;
                n2 = i - j >= num2.length() ? 0 : num2.charAt(num2.length() - 1 - (i - j)) - 48;
                sum += n1 * n2;
            }
            carry = sum / 10;
            current = sum % 10;
            builder.append(current);
        }
        output = builder.reverse().toString();
        if (output.startsWith("0")) {
            output = output.replaceFirst("0", "");
        }
        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
