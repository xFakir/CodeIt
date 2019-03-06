package Concurrency.ThreadPool;

@FunctionalInterface
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
