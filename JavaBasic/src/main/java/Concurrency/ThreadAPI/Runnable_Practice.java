package Concurrency.ThreadAPI;

/**
 * @ClassName : Runnable_Practice
 * @Description : 模仿银行柜台出号
 * @Author : xcx
 * @Date : 2019-02-28 15:19
 * @Version : 1.0
 */
public class Runnable_Practice implements Runnable{
    private int index = 1;

    private final static int MAX = 50;


    @Override
    public void run() {
        while (index <= MAX){
            System.out.println(Thread.currentThread() + "当前号码是:" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Runnable_Practice task = new Runnable_Practice();

        Thread t1 = new Thread(task,"柜台1");
        Thread t2 = new Thread(task,"柜台2");
        Thread t3 = new Thread(task,"柜台3");
        Thread t4 = new Thread(task,"柜台4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
