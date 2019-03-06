package Concurrency.Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName : Mutex
 * @Description :
 * @Author : xcx
 * @Date : 2019-02-28 20:16
 * @Version : 1.0
 */
public class Mutex {
    public static final Object MUTEX = new Object();

    public void accessResource(){
        synchronized (MUTEX){
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        for (int i = 0; i < 10; i++) {
            new Thread(mutex::accessResource).start();

        }
    }
}
