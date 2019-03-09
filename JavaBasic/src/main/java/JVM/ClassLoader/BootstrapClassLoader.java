package JVM.ClassLoader;

/**
 * @ClassName : BootstrapClassLoader
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 14:42
 * @Version : 1.0
 */
public class BootstrapClassLoader {
    public static void main(String[] args) {
        //根加载器获取不到引用
        System.out.println("Bootstrap: " + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
