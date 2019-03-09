package JVM.ClassLoader;

import JVM.ClassLoader.MyClassLoader.BrokenDelegeteClassLoader;

/**
 * @ClassName : LoadSimpleClass
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 17:11
 * @Version : 1.0
 */
public class LoadSimpleClass {
    public static void main(String[] args) throws Exception{
        BrokenDelegeteClassLoader classLoader = new BrokenDelegeteClassLoader();
        Class<?> clazz = classLoader.loadClass("JVM.ClassLoader.SimpleClass");
        System.out.println(classLoader.getParent());
        clazz.newInstance();
    }
}
