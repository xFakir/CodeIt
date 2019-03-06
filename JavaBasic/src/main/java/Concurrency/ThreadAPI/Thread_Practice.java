package Concurrency.ThreadAPI;

/**
 * @ClassName : Thread_Practice
 * @Description : 模仿银行柜台出号
 * @Author : xcx
 * @Date : 2019-02-28 15:01
 * @Version : 1.0
 */
public class Thread_Practice extends Thread{
    private final String name;

    private static final int MAX = 50;

    private static int index = 1;

    public Thread_Practice(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println("柜台:" + name + "当前号码是:" + (index++));
        }
    }

    public static void main(String[] args) {
        Thread_Practice t1 = new Thread_Practice("柜台1");
        t1.start();

        Thread_Practice t2 = new Thread_Practice("柜台2");
        t2.start();

        Thread_Practice t3 = new Thread_Practice("柜台3");
        t3.start();

        Thread_Practice t4 = new Thread_Practice("柜台4");
        t4.start();
    }
}
