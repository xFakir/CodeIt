package Concurrency.CyclicBarrier;

/**
 * @ClassName : Result
 * @Description : 保存返回结果类
 * @Author : xcx
 * @Date : 2019-03-28 14:23
 * @Version : 1.0
 */
public class Result {
    private int[] data;

    public Result(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
