package DesignPattern.Singleton.Holder;

/**
 * @ClassName : Singleton
 * @Description : Holder
 * @Author : xcx
 * @Date : 2019-03-11 20:02
 * @Version : 1.0
 *
 * Singleton类的初始化过程中不会创建instance实例
 * Singleton的实例化在Java编译时期收集至<clinit>()方法中，该方法为同步方法
 *
 */
public class Singleton {
    private Singleton(){

    }

    private static class Holder{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return Holder.instance;
    }

}
