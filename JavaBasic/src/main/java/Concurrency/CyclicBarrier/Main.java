package Concurrency.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName : Main
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-28 22:34
 * @Version : 1.0
 */
public class Main {
    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINE_PARTICIPANT = 2000;

        MatrixGenerator mock = new MatrixGenerator(ROWS, NUMBERS, SEARCH);
        Result result = new Result(ROWS);
        Grouper grouper = new Grouper(result);

        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

        NumberSearcher[] searchers = new NumberSearcher[PARTICIPANTS];
        for(int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new NumberSearcher(i * LINE_PARTICIPANT, (i * LINE_PARTICIPANT) + LINE_PARTICIPANT,
                    mock, result, 5, barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.printf("Main: The main thread has finished.\n");
    }
}
