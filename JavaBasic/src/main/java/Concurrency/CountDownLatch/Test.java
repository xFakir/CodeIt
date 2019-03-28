package Concurrency.CountDownLatch;

/**
 * @ClassName : BasicPractice
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-27 16:02
 * @Version : 1.0
 */
public class Test {
    public static void main(String[] args) {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);
    }
}
