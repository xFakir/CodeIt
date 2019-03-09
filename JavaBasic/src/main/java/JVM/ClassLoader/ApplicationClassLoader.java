package JVM.ClassLoader;

/**
 * @ClassName : ApplicationClassLoader
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 14:51
 * @Version : 1.0
 */
public class ApplicationClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());
    }
}
