package JVM.ClassLoader.MyClassLoader;

/**
 * @ClassName : HelloWorld
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 16:24
 * @Version : 1.0
 */
public class HelloWorld {
    static {
        System.out.println("Hello World Class is Initialized");
    }
    public String welcome(){
        return "Hello World";
    }
}
