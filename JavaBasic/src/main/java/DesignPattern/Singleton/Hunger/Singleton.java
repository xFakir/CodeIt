package DesignPattern.Singleton.Hunger;

/**
 * @ClassName : Singleton
 * @Description : 饿汉式
 * @Author : xcx
 * @Date : 2019-03-11 18:38
 * @Version : 1.0
 *
 * 可以保证多个线程下的唯一实例，getInstance方法性能较高，
 * 但是无法进行懒加载
 *
 */
public final class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

}
