package Concurrency.Communication;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName : EventClient
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-05 13:55
 * @Version : 1.0
 */
public class EventClient {
    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();
        new Thread(() -> {
            for (;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"Producer").start();

        new Thread(() -> {
            for (;;){
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer").start();
    }
}
