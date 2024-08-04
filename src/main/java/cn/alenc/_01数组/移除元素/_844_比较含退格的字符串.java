package cn.alenc._01数组.移除元素;

/**
 * @Auther: allenc
 * @Date: 2024/7/1 20:33
 * 简单
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * <p>
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * <p>
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * <p>
 * 进阶：
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 */
public class _844_比较含退格的字符串 {
    public static boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] sCharArr = new char[s.length()];
        int sIndex = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != '#') {
                sCharArr[sIndex++] = sChars[i];
            } else {
                if (sIndex - 1 >=0) {
                    sCharArr[--sIndex] = 'A';
                }
            }
        }

        char[] tChars = t.toCharArray();
        char[] tCharArr = new char[t.length()];
        int tIndex = 0;
        for (int i = 0; i < tChars.length; i++) {
            if (tChars[i] != '#') {
                tCharArr[tIndex++] = tChars[i];
            } else {
                if (tIndex - 1 >=0) {
                    tCharArr[--tIndex] = 'A';
                }
            }
        }

        if (sIndex != tIndex) {
            return false;
        }

        int startIndex = 0;
        while (startIndex < sIndex) {
            if (sCharArr[startIndex] != tCharArr[startIndex]) {
                return false;
            }
            startIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a#c", "b"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));
        System.out.println(backspaceCompare1("ab#c", "ad#c"));
        System.out.println(backspaceCompare1("ab##", "c#d#"));
        System.out.println(backspaceCompare1("a#c", "b"));
        System.out.println(backspaceCompare1("a##c", "#a#c"));
        System.out.println(backspaceCompare1("xywrrmp", "xywrrmu#p"));
    }

    public static boolean backspaceCompare1(String s, String t) {
        return build(s).equals(build(t));
    }

    // 上面的方法过于复杂，没有必要将字符串转换成字符数组的，思路还可以，使用栈的思路
    public static String build(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '#') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        return sb.toString();
    }
}
