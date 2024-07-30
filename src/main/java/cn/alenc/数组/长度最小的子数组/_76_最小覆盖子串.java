package cn.alenc.数组.长度最小的子数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: allenc
 * @Date: 2024/7/13 21:54
 * 困难
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * 提示：
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 * <p>
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */
public class _76_最小覆盖子串 {
    public static String minWindow(String s, String t) { // 超时了，可以尝试两个哈希表以及滑动窗口。这里右边指针每次都是从左边指针开始重新搜索，效率很低
        Map<String, Integer> oMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            oMap.put(String.valueOf(t.charAt(i)), oMap.getOrDefault(String.valueOf(t.charAt(i)), 0) + 1);
        }

        int min = s.length();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            Map<String, Integer> map = new HashMap<>(oMap);
            if (map.containsKey(String.valueOf(s.charAt(i)))) {
                while (j < s.length() && map.size() > 0) {
                    if (map.containsKey(String.valueOf(s.charAt(j)))) {
                        if (map.getOrDefault(String.valueOf(s.charAt(j)), 0) == 1) {
                            map.remove(String.valueOf(s.charAt(j)));
                        } else {
                            map.put(String.valueOf(s.charAt(j)), map.getOrDefault(String.valueOf(s.charAt(j)), 0) - 1);
                        }
                    }
                    j++;
                }

                if (map.size() == 0) {
                    if (min >= j - i) {
                        result = s.substring(i, j);
                    }
                    min = Math.min(min, j - i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(minWindow("a", "a"));
//        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow1("cabwefgewcwaefgcf", "cae"));
        System.out.println(minWindow1("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow1("a", "a"));
        System.out.println(minWindow1("a", "aa"));
    }

    public static String minWindow1(String s, String t) { // 超时了，可以尝试两个哈希表以及滑动窗口
        Map<String, Integer> sMap = new HashMap<>(); // 字串中包含的t中的元素个数
        Map<String, Integer> tMap = new HashMap<>(); // t中包含的元素以及个数

        for (int i = 0; i < t.length(); i++) {
            tMap.put(String.valueOf(t.charAt(i)), tMap.getOrDefault(String.valueOf(t.charAt(i)), 0) + 1);
        }

        int ansL = 0;
        int ansR = 0;
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) { // i是左边指针，j是右边指针
            if (i >= 1 && sMap.containsKey(String.valueOf(s.charAt(i - 1)))) {
            String preI = String.valueOf(s.charAt(i - 1));
                if (sMap.getOrDefault(preI, 0) == 1) {
                    sMap.remove(preI);
                } else {
                    sMap.put(preI, sMap.getOrDefault(preI, 0) - 1);
                }
            }

            while (!check(sMap, tMap) && j < s.length()) {
                if (tMap.containsKey(String.valueOf(s.charAt(j)))) {
                    sMap.put(String.valueOf(s.charAt(j)), sMap.getOrDefault(String.valueOf(s.charAt(j)), 0) + 1);
                }
                j++;
            }
            if (check(sMap, tMap) && min > j - i) {
                ansL = i;
                ansR = j;
                min = Math.min(min, j - i);
            }

        }


        return s.substring(ansL, ansR);
    }

    public static boolean check(Map<String, Integer> sMap, Map<String, Integer> tMap) {
        Set<Map.Entry<String, Integer>> entries = tMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (sMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
