package DesignPattern.Singleton.DoubleCheckAndVolatile;

/**
 * @ClassName : Singleton
 * @Description : volatile + Double-Check
 * @Author : xcx
 * @Date : 2019-03-11 20:01
 * @Version : 1.0
 *
 * volatile禁止指令重排，就可以避免可能出现的空指针异常了
 */
public class Singleton {
    private volatile static Singleton instance = null;

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
