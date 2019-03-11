package DesignPattern.Singleton.LazyAndSync;

/**
 * @ClassName : Singleton
 * @Description : 懒汉式+同步方法
 * @Author : xcx
 * @Date : 2019-03-11 19:53
 * @Version : 1.0
 *
 * 虽然synchronized保证了instance实例唯一性
 * 但也导致了getInstance方法在同一时刻被一个线程访问，故性能低下
 *
 */
public class Singleton {

    private static Singleton instance = null;

    private Singleton(){

    }

    public static synchronized Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
