package JVM.ClassLoader.MyClassLoader;

import java.lang.reflect.Method;

/**
 * @ClassName : BrokenDelegeteClassLoaderTest
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 16:39
 * @Version : 1.0
 */
public class BrokenDelegeteClassLoaderTest {
    public static void main(String[] args) throws Exception{
        BrokenDelegeteClassLoader myClassLoader = new BrokenDelegeteClassLoader();
        Class<?> clazz = myClassLoader.loadClass("JVM.ClassLoader.MyClassLoader.HelloWorld");
        System.out.println(clazz.getClassLoader());

        Object helloWorld = clazz.newInstance();
        System.out.println(helloWorld);
        Method welcomeMethod = clazz.getMethod("welcome");
        System.out.println(welcomeMethod.invoke(helloWorld));
    }
}
