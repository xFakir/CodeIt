package Concurrency.Synchronized;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * @ClassName : ThisMonitor
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-04 16:37
 * @Version : 1.0
 */
public class ThisMonitor {
    public synchronized void method1(){
        System.out.println(currentThread() + " enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2(){
        System.out.println(currentThread() + " enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThisMonitor thisMonitor = new ThisMonitor();
        new Thread(thisMonitor::method1).start();
        new Thread(thisMonitor::method2).start();
    }
}
