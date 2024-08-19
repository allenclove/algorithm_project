package cn.alenc._04字符串;

/**
 * @Auther: allenc
 * @Date: 2024/8/13 21:59
 * 简单
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class _541_反转字符串II {
    public static String reverseStr(String s, int k) { // 暴力解法
        char[] chars = s.toCharArray();
        int length = s.length();
        int cnt1 = length / (2 * k);
        int cnt2 = length % (2 * k);

        StringBuilder sb = new StringBuilder();
        for (int i = 2 * k; i <= length;  i = i + 2 * k) {
            int index1 = 0;
            while (index1 < k) {
                sb.append(chars[i - index1 - k - 1]);
                index1++;
            }
            int index2 = 0;
            while (index2 < k) {
                sb.append(chars[i + index2 - k]);
                index2++;
            }
        }

        if (cnt2 >= k) {
            int index = k;
            while (index > 0) {
                sb.append(chars[cnt1 * (2 * k) + index - 1]);
                index--;
            }
            sb.append(s.substring(cnt1 * (2 * k) + k ));
        } else {
            int index = length - 1;
            while (index >= (cnt1 * (2 * k))) {
                sb.append(chars[index]);
                index--;
            }
        }

        return sb.toString();
    }

    public static String reverseStr1(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i+=2*k) {
            reverse(arr, i,Math.min(i + k, n) - 1);
        }
        return new String(arr); // 在一个数组上操作，最后操作完直接new一个String对象拿到结果，很妙
    }

    public static void reverse(char[] arr, int left, int right) { // 数组中交换元素的经典写法
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        reverseStr("a",2);
    }
}
