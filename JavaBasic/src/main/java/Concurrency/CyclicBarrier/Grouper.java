package Concurrency.CyclicBarrier;

/**
 * @ClassName : Grouper
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-28 22:34
 * @Version : 1.0
 */
public class Grouper implements Runnable{
    private Result result;

    public Grouper(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: Processing results...\n");
        int[] data = result.getData();
        for(int number : data) {
            finalResult += number;
        }
        System.out.printf("Grouper: Total result: %d.\n", finalResult);
    }

}
