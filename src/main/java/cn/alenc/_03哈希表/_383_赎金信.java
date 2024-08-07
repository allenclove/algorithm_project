package cn.alenc._03哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allenc
 * @Date: 2024/8/7 21:54
 * 简单
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class _383_赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            String str = magazine.charAt(i) + "";
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            String str = ransomNote.charAt(i) + "";
            if (map.containsKey(str)) {
                if (map.get(str).compareTo(1) == 0) {
                    map.remove(str);
                } else {
                    map.put(str, map.get(str) - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) { // 数组的解法更加快一点
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
