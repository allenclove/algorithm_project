package cn.alenc.dynamicprogram;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName 删除并获得点数
 * @Description
 * @Author ALLENC
 * @Date 2021/8/1 13:05
 * <p>
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *  
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 * <p>
 * 说实话这个题目我看了半天都没有看懂，看了答案说可以转换为打家劫舍的问题
 * 他这里的关键点是：删除一个元素a后， 所有的a+1和a-1都要删掉，比如我们删掉了实例2中的4， 那么3和5要全部删掉， 就剩nums=[2,2], 点数是4
 * 最后分别删掉两次2点数就是8，那么就比实例中的点数少， 所以我们删除一个元素会一删到底， 然后再删除其他的， 并且删除获得的点数需要比较大
 * <p>
 * 所以我们可以把相同的元素排列到一起， 也就是排序， 然后将值相加，这样就转化为了打家劫舍的问题了
 * 比如示例2就变成：[0，0，4，9，4]， 也就是说不能连续偷， 至少需要隔着一间房子
 * <p>
 * 状态转移方程:这里的还要注意的是dp的前两个值需要我们自己赋值
 * dp[i] = max(dp[i-2] + nums[i], nums[i-1])
 **/
public class 删除并获得点数 {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums[nums.length - 1] + 1];

        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i]] == 0) {
                arr[nums[i]] = nums[i];
            } else {
                arr[nums[i]] += nums[i];
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(arr));

        int[] dp = new int[arr.length];
        if (arr.length == 1) {
            return arr[0];
        } else if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        } else {
            dp[0] = arr[0];
            dp[1] = Math.max(arr[0],arr[1]);
            for (int i = 2; i < arr.length; i++) {
                dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
            }
        }

        System.out.println(Arrays.toString(dp));

        return Math.max(dp[arr.length - 1], dp[arr.length - 2]);
    }

    @Test
    public void demoTest() {
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }
}
