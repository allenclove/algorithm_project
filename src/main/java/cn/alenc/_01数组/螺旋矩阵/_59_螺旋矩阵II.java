package cn.alenc._01数组.螺旋矩阵;

import java.util.Arrays;

/**
 * @Auther: allenc
 * @Date: 2024/7/14 16:27
 * 中等
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= n <= 20
 */
public class _59_螺旋矩阵II {
    public static int[][] generateMatrix(int n) { // 需要注意，遵循左闭右开原则即可
        int[][] result = new int[n][n];

        int startX = 0;
        int startY = 0;
        int offest = 1;
        int loop = 1;
        int count = 1;
        int i, j; // i表示行，j表示列
        while (loop <= n / 2) { // 控制循环次数
            for (j = startY; j < n - offest; j++) { // 第一行赋值，横坐标不变，纵坐标变
                result[startX][j] = count++;
            }

            for (i = startX; i < n - offest; i++) { // 最后一列赋值，使用上面的纵坐标，纵坐标不变，横坐标变
                result[i][j] = count++;
            }

            for (; j > startX; j--) { // 最后一行赋值，使用上面的横坐标，横坐标不变，纵坐标变
                result[i][j] = count++;
            }

            for (; i > startY; i--) { // 第一列赋值，使用上面的纵坐标，纵坐标不变，横坐标变
                result[i][j] = count++;
            }

            startX++;
            startY++;
            loop++;
            offest++;
        }

        if (n % 2 == 1) { // 奇数的话需要赋值最后一个位置
            result[startX][startY] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateMatrix(4)));
        System.out.println(Arrays.toString(generateMatrix(2)));
        System.out.println(Arrays.toString(generateMatrix(3)));
        System.out.println(Arrays.toString(generateMatrix(1)));
    }
}
