//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class IsAnagram {

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram.isAnagram(s, t));
        s = "rat";
        t = "car";
        System.out.println(isAnagram.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

//        String sortedS = selectionSort(s);
//        String sortedT = selectionSort(t);
//        String sortedS = insertionSort(simplifyString(s));
        ////        String sortedT = insertionSort(simplifyString(t));
        Map<Character, Integer> mapS = simplifyString(s);
        Map<Character, Integer> mapT = simplifyString(t);
        if (mapS.keySet().size() != mapT.keySet().size()) {
            return false;
        }
        for (Map.Entry entry : mapS.entrySet()) {
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (!mapT.containsKey(key) || !mapT.get(key).equals(value)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> simplifyString(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        return map;
    }

    public String selectionSort(String s) {
        char[] sortedChars = s.toCharArray();
        char tempChar;
        int maxIndex;
        for (int i = 0; i < sortedChars.length; i++) {
            maxIndex = i;
            for (int j = i; j < sortedChars.length; j++) {
                if (sortedChars[j] > sortedChars[maxIndex]) {
                    maxIndex = j;
                }
            }
            tempChar = sortedChars[i];
            sortedChars[i] = sortedChars[maxIndex];
            sortedChars[maxIndex] = tempChar;
        }
        return String.valueOf(sortedChars);
    }

    public String insertionSort(String s) {
        char[] sortedChars = s.toCharArray();
        char tempChar;
        for (int i = 1; i < sortedChars.length; i++) {
            for (int j = i; j > 0; j--) {
                if (sortedChars[j] > sortedChars[j - 1]) {
                    tempChar = sortedChars[j];
                    sortedChars[j] = sortedChars[j - 1];
                    sortedChars[j - 1] = tempChar;
                }
            }
        }
        return String.valueOf(sortedChars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
