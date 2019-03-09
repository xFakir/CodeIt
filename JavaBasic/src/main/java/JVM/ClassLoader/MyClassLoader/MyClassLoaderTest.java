package JVM.ClassLoader.MyClassLoader;

import java.lang.reflect.Method;

/**
 * @ClassName : MyClassLoaderTest
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 15:38
 * @Version : 1.0
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws Exception{
        //以下代码只是加载而不初始化，且需要删除class文件，因为会被系统加载器加载
        /*MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.loadClass("JVM.ClassLoader.MyClassLoader.HelloWorld");
        System.out.println(clazz.getClassLoader());*/


        //绕过系统类加载器
        /*ClassLoader extClassLoader = MyClassLoaderTest.class.getClassLoader().getParent();
        MyClassLoader myClassLoader = new MyClassLoader("D:\\MyClassLoader",extClassLoader);
        Class<?> clazz = myClassLoader.loadClass("JVM.ClassLoader.MyClassLoader.HelloWorld");
        System.out.println(clazz.getClassLoader());*/

        //指定父加载器为null，这样就会直接使用根加载器进行加载
        ClassLoader extClassLoader = MyClassLoaderTest.class.getClassLoader().getParent();
        MyClassLoader myClassLoader = new MyClassLoader("D:\\MyClassLoader",null);
        Class<?> clazz = myClassLoader.loadClass("JVM.ClassLoader.MyClassLoader.HelloWorld");
        System.out.println(clazz.getClassLoader());

        Object helloWorld = clazz.newInstance();
        System.out.println(helloWorld);
        Method welcomeMethod = clazz.getMethod("welcome");
        System.out.println(welcomeMethod.invoke(helloWorld));
    }
}
