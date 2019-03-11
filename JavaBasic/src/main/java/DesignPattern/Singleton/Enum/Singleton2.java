package DesignPattern.Singleton.Enum;

/**
 * @ClassName : Singleton2
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-11 20:10
 * @Version : 1.0
 *
 * 提供了懒加载
 */
public class Singleton2 {
    private Singleton2(){

    }

    private enum EnumHolder{
        //实例
        INSTANCE;

        private Singleton2 instance;

        EnumHolder(){
            this.instance = new Singleton2();
        }

        private Singleton2 getSingleton(){
            return instance;
        }
    }

    public static Singleton2 getInstance(){
        return EnumHolder.INSTANCE.getSingleton();
    }

}
