package Concurrency.Communication.MyLock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

/**
 * @ClassName : BooleanLock
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-05 15:23
 * @Version : 1.0
 */
public class BooleanLock implements Lock{

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this){
            while (locked){
                final Thread tempThread = currentThread();
                try {
                    if(!blockedList.contains(tempThread)){
                        blockedList.add(tempThread);
                        this.wait();
                    }
                } catch (InterruptedException e){
                    blockedList.remove(tempThread);
                    throw e;
                }
            }
            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this){
            if (mills < 0){
                //也可以抛出异常
                this.lock();
            } else {
                long remainingMillis = mills;
                long endMillis = currentTimeMillis() + remainingMillis;
                while (locked){
                    if (remainingMillis <= 0) {
                        throw new TimeoutException();
                    }
                    final Thread tempThread = currentThread();
                    try {

                        if (!blockedList.contains(tempThread)) {
                            blockedList.add(tempThread);
                        }
                        this.wait(remainingMillis);
                    } catch (InterruptedException e){
                        blockedList.remove(tempThread);
                        throw e;
                    }

                    remainingMillis = endMillis - currentTimeMillis();
                }
                blockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }

        }
    }

    @Override
    public void unlock() {
        synchronized (this){
            if(currentThread == currentThread()){
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock.").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
