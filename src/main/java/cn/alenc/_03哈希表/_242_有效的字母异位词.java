package cn.alenc._03哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allenc
 * @Date: 2024/8/2 21:17
 * 简单
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class _242_有效的字母异位词 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            map.put(s.charAt(i) + "", map.getOrDefault(s.charAt(i) + "",0) + 1);
            i++;
        }

        i = 0;
        while (i < t.length()) {
            if (map.getOrDefault(t.charAt(i) + "",0) == 1) {
                map.remove(t.charAt(i) + "");
            } else {
                map.put(t.charAt(i) + "", map.getOrDefault(t.charAt(i) + "",0) - 1);
            }
            i++;
        }

        if (map.size() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        isAnagram("anagram","nagaram");
        isAnagram("rat","car");
    }
}
