package Concurrency.CyclicBarrier;

import java.util.Random;

/**
 * @ClassName : MatrixGenerator
 * @Description : 生成一个随机M*N矩阵，每位为0~9
 * @Author : xcx
 * @Date : 2019-03-28 14:21
 * @Version : 1.0
 */
public class MatrixGenerator {
    private int[][] data;

    public MatrixGenerator(int size, int length, int number) {
        int counter = 0;
        data = new int[size][length];
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < length; j++) {
                data[i][j] = random.nextInt(10);
                if(data[i][j] == number) {
                    counter++;
                }
            }
        }
        System.out.printf("Mock: There are %d occurrences of number %d " +
                "in generated data.\n", counter, number);
    }

    public int[] getRow(int row) {
        if(row >= 0 && row < data.length) {
            return data[row];
        } else {
            return null;
        }
    }
}
