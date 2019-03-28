package Concurrency.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName : NumberSearcher
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-28 14:24
 * @Version : 1.0
 */
public class NumberSearcher implements Runnable{
    private int firstRow;
    private int lastRow;
    private MatrixGenerator mock;
    private Result result;
    private int number;
    private final CyclicBarrier barrier;

    public NumberSearcher(int firstRow, int lastRow, MatrixGenerator mock,
                          Result result, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.result = result;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int counter;
        System.out.printf("%s: Processing lines from %d to %d.\n",
                Thread.currentThread().getName(), firstRow, lastRow);
        for(int i = firstRow; i < lastRow; i++) {
            int[] row = mock.getRow(i);
            counter = 0;
            for(int j = 0; j < row.length; j++) {
                if(row[j] == number) {
                    counter++;
                }
            }
            result.setData(i, counter);
        }
        System.out.printf("%s: Lines processed.\n",
                Thread.currentThread().getName());

        try {
            barrier.await();
        } catch(InterruptedException e) {
            e.printStackTrace();
        } catch(BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
