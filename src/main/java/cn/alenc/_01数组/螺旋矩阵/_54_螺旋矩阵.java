package cn.alenc._01数组.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allenc
 * @Date: 2024/7/14 14:35
 * 中等
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class _54_螺旋矩阵 { // 【个人感觉比较难想到这种解法】
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int startx = 0;
        int endx = matrix[0].length - 1;
        int starty = 0;
        int endy = matrix.length - 1;
        int i, j;

        while (startx <= endx && starty <= endy) { // 这里用左闭右闭代码显得很简单，使用左闭右开代码很麻烦。需要注意的是值的传递
            for (j = startx; j <= endx; j++) {
                    list.add(matrix[starty][j]);
            }
            starty++;

            for (i = starty; i <= endy; i++) {
                list.add(matrix[i][endx]);
            }
            endx--;

            if (starty <= endy) {
                for (j = endx; j >= startx; j--) {
                    list.add(matrix[endy][j]);
                }
            }
            endy--;

            if (startx <= endx) {
                for (i = endy; i >= starty; i--) {
                    list.add(matrix[i][startx]);
                }
            }
            startx++;
        }
        return list;
    }

    public static void main(String[] args) {
//        System.out.println(spiralOrder(new int[][]{{6,9,7}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
//        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
//        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}));
//        System.out.println(spiralOrder(new int[][]{{1, 2, 3,4, 5}, {6,7, 8, 9,10}, {11, 12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}}));
    }
}
