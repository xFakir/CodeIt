package DesignPattern.Singleton.Enum;

/**
 * @ClassName : Singleton
 * @Description : Enum
 * @Author : xcx
 * @Date : 2019-03-11 20:05
 * @Version : 1.0
 */
public enum  Singleton {
    //单例对象实例
    INSTANCE;

    Singleton(){

    }

    public static Singleton getInstance(){
        return INSTANCE;
    }

}
