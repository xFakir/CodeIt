package Algorithm.array;

import java.util.Arrays;

/**
 * @ClassName : RotateImage
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-18 9:26
 * @Version : 1.0
 */
public class RotateImage {
    /**
     *给定一个 n × n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     *
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     *
     *
     */

    /**
     * 先转置再交换
     *
     * @param matrix
     */
    public static void solution(int[][] matrix){
        int length = matrix.length;
        if (length == 0) return;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int j = 0; j < length/2; j++) {
            for (int i = 0; i < length; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = temp;
            }
        }


    }

    /**
     * 利用公式,注意循环终点
     * 起始位置:matrix[i][j]
     * 逆时针90度位置:
     * matrix[lenh - j - 1][i]
     * 逆时针180度位置:
     * matrix[lenw- i- 1][lenh- j- 1]
     * 逆时针270度位置:
     * matrix[j][lenw - i - 1]
     *
     * @param matrix
     */
    public static void solution2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n - 1 - i; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        solution(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }


    }
}
