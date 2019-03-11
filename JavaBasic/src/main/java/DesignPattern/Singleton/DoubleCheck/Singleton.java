package DesignPattern.Singleton.DoubleCheck;

/**
 * @ClassName : Singleton
 * @Description : Double-Check
 * @Author : xcx
 * @Date : 2019-03-11 19:56
 * @Version : 1.0
 *
 * 既满足了懒加载，也满足了instance实例的唯一性
 * 但在多线程情况下可能会引起空指针异常
 *
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(null == instance){
            synchronized (Singleton.class){
                if(null == instance){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
