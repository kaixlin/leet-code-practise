//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//
//
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
//
// 示例 1:
//
// 输入: 3
//输出: "III"
//
// 示例 2:
//
// 输入: 4
//输出: "IV"
//
// 示例 3:
//
// 输入: 9
//输出: "IX"
//
// 示例 4:
//
// 输入: 
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
//
//
// 示例 5:
//
// 输入: 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4.
// Related Topics 数学 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class IntToRoman {

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(3));
        System.out.println(intToRoman.intToRoman(4));
        System.out.println(intToRoman.intToRoman(8));
        System.out.println(intToRoman.intToRoman(9));
        System.out.println(intToRoman.intToRoman(58));
        System.out.println(intToRoman.intToRoman(1994));
    }

    public String intToRoman(int num) {
        int[] intArrays = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanArrays = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X" , "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intArrays.length; i++) {
            while(num >= intArrays[i]) {
                num = num - intArrays[i];
                builder.append(romanArrays[i]);
            }
        }
        return builder.toString();
    }

    public String intToRoman2(int num) {
        int m = num / 1000;
        num = num - (1000 * m);
        int d = num / 500;
        num = num - (500 * d);
        int c = num / 100;
        num = num - (100 * c);
        int l = num / 50;
        num = num - (50 * l);
        int x = num / 10;
        num = num - (10 * x);
        int v = num / 5;
        num = num - (5 * v);
        int i = num;
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < m; k++) {
            builder.append("M");
        }

        if (d == 1 && c == 4) {
            builder.append("CM");
        } else {
            for (int k = 0; k < d; k++) {
                builder.append("D");
            }
            if (d == 0 && c == 4) {
                builder.append("CD");
            } else {
                for (int k = 0; k < c; k++) {
                    builder.append("C");
                }
            }
        }

        if (l == 1 && x == 4) {
            builder.append("XC");
        } else {
            for (int k = 0; k < l; k++) {
                builder.append("L");
            }
            if (l == 0 && x == 4) {
                builder.append("XL");
            } else {
                for (int k = 0; k < x; k++) {
                    builder.append("X");
                }
            }
        }


        if (v == 1 && i == 4) {
            builder.append("IX");
        }
        else {
            for (int k = 0; k < v; k++) {
                builder.append("V");
            }
            if (i == 4 && v == 0) {
                builder.append("IV");
            } else {
                for (int k = 0; k < i; k++) {
                    builder.append("I");
                }
            }
        }

        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
