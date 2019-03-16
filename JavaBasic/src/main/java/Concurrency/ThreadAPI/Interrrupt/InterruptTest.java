package Concurrency.ThreadAPI.Interrrupt;

/**
 * @ClassName : InterruptTest
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-16 10:47
 * @Version : 1.0
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 对正在执行非阻塞方法的线程调用interrupt方法，会将interrupt标识设置为true
         */
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    Thread.yield();
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        };

        /**
         * 对正在执行非阻塞方法的线程调用interrupt方法，会将interrupt标识设置为true
         */
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.yield();
                }
            }
        };

        Thread t3 = new Thread(){
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(1000);

                        //其他阻塞方法
                        innerBlock();
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted when sleep");
                        //1.interrupt标识设置为true
                        Thread.currentThread().interrupt();
                        //2.向上抛出
                        //throw e;
                    }
                }
            }
        };

        test(t3);
    }

    private static void test(Thread thread) throws InterruptedException {
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    private static void innerBlock() throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("inner block interrupted");
            throw e;
        }
    }
}
