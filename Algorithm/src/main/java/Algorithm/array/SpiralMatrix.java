package Algorithm.array;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : SpiralMatrix
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-18 10:45
 * @Version : 1.0
 */
public class SpiralMatrix {
    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     *
     * 输入:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    public static List<Integer> soluntion(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {

            }
        }
        return null;
    }
}
