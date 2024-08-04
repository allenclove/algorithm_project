package cn.alenc._03哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: allenc
 * @Date: 2024/8/4 15:12
 * 中等
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 提示:
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class _438_找到字符串中所有字母异位词 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        String target = convertStr(p);
        int length = p.length();
        for (int i = 0; i < s.length() - (length - 1); i++) {
            String substring = s.substring(i, i + length);
            if (target.equals(convertStr(substring))) {
                list.add(i);
            }
        }

        return list;
    }

    public static String convertStr(String a) {
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static List<Integer> findAnagrams1(String s, String p) { // 别人的滑动窗口，有点难理解
        List<Integer> ans = new ArrayList<>();
        // 初始化一个数组来统计字符串 p 中每个字符的出现次数
        int[] cnt = new int[26];
        for(int i = 0; i < p.length(); i++){
            cnt[p.charAt(i) - 'a']++;
        }
        // l 和 r 分别表示滑动窗口的左右边界
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            // 更新当前窗口中字符的计数数组
            cnt[s.charAt(r) - 'a']--;
            // 从左侧收缩窗口，直到当前字符的计数在限定范围内
            while(cnt[s.charAt(r) - 'a'] < 0){
                cnt[s.charAt(l) - 'a']++;
                l++;
            }
            // 检查当前窗口大小是否等于字符串 p 的大小
            if(r - l + 1 == p.length()){
                ans.add(l);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(findAnagrams("cbaebabacd","abc"));
//        System.out.println(findAnagrams("abab","ab"));
//        System.out.println(findAnagrams("a","a"));
        System.out.println(findAnagrams1("cbaebabacd","abc"));
//        System.out.println(findAnagrams1("abab","ab"));
//        System.out.println(findAnagrams1("a","a"));
    }
}
