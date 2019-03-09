package JVM.ClassLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : SimpleClass
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 17:07
 * @Version : 1.0
 */
public class SimpleClass {
    private static byte[] buffer = new byte[8];

    private static String str = "";

    private static List<String> list = new ArrayList<>();

    static{
        buffer[0] = (byte)1;
        str = "simple";
        list.add("element");
        System.out.println(buffer[0]);
        System.out.println(str);
        System.out.println(list.get(0));
    }
}
