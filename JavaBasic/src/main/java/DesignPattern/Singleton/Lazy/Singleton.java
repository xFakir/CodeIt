package DesignPattern.Singleton.Lazy;

/**
 * @ClassName : Singleton
 * @Description : 懒汉式
 * @Author : xcx
 * @Date : 2019-03-11 19:49
 * @Version : 1.0
 *
 * 在Singleton.class被初始化的时候，instance不会被实例化
 * 多线程环境下，会导致instance被实例化多次
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


}
