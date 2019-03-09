package JVM.ClassLoader;

/**
 * @ClassName : NameSpace
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 16:48
 * @Version : 1.0
 */
public class NameSpace {
    public static void main(String[] args) throws ClassNotFoundException{
        ClassLoader classLoader = NameSpace.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("JVM.ClassLoader.Test");
        Class<?> bClass = classLoader.loadClass("JVM.ClassLoader.Test");
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(aClass.hashCode() == bClass.hashCode());
    }
}
