//给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
//
// 示例:
//
// 输入: "Hello World"
//输出: 5
//
// Related Topics 字符串



//leetcode submit region begin(Prohibit modification and deletion)
class LengthOfLastWord {

    public static void main(String[] args) {
//        String input = "hello world";
//        String input = "a ";
        String input = " ";
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord(input));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(" ");
        if (lastSpaceIndex == -1) {
            return s.length();
        }
        else {
            if (s.length() - 1 == lastSpaceIndex) {
                return 1;
            }
            return s.length() - lastSpaceIndex - 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
