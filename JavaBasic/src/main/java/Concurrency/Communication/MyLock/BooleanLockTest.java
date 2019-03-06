package Concurrency.Communication.MyLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @ClassName : BooleanLockTest
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-05 16:09
 * @Version : 1.0
 */
public class BooleanLockTest {
    private final Lock lock = new BooleanLock();

    public void syncMethod() {

        try {
            lock.lock();
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void syncMethodTimeoutable(){
        try {
            lock.lock(1000);
            System.out.println(currentThread() + " get the lock");
            int randomInt = current().nextInt(10);
            TimeUnit.SECONDS.sleep(randomInt);

        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{

        test3();

    }

    private static void test1(){
        //1.多个线程通过lock()争抢锁
        BooleanLockTest blt = new BooleanLockTest();
        IntStream.range(0,10).mapToObj(i -> new Thread(blt::syncMethod)).forEach(Thread::start);
    }

    private static void test2() throws InterruptedException{
        //2.可中断被阻塞的线程
        BooleanLockTest blt = new BooleanLockTest();
        new Thread(blt::syncMethod,"t1").start();
        TimeUnit.MILLISECONDS.sleep(2);
        Thread t2 = new Thread(blt::syncMethod,"t2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);
        t2.interrupt();
    }

    private static void test3() throws InterruptedException{
        //3.阻塞的线程可超时
        BooleanLockTest blt = new BooleanLockTest();
        new Thread(blt::syncMethod,"t1").start();
        TimeUnit.MILLISECONDS.sleep(2);
        Thread t2 = new Thread(blt::syncMethodTimeoutable,"t2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);
    }



}
