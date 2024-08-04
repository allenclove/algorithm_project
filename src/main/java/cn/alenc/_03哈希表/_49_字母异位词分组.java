package cn.alenc._03哈希表;

import java.util.*;

/**
 * @Auther: allenc
 * @Date: 2024/8/4 14:47
 * 中等
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class _49_字母异位词分组 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = convertStr(str);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }

        return new ArrayList<>(map.values());
    }

    public static String convertStr(String a) {
        char[] aChars = a.toCharArray(); // 这里转成数组再排序是判断异位字符串的常用方法
        Arrays.sort(aChars);
        String result = "";
        for (char aChar : aChars) { // 这个数组转字符串可以使用new String(aChars);更加简单
            result += aChar;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
