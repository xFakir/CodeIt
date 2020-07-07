package Algorithm;

import Algorithm.tree.TreeNode;

import java.lang.reflect.Field;

/**
 * @ClassName : Swap
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-10 10:42
 * @Version : 1.0
 */
public class Swap {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //System.out.println(transferTableNameToClassName("user_info_tb"));
        /*Integer a = 1;
        Integer b = 2;
        System.out.println("a= " + a + ",b= " + b);
        swap(a,b);
        System.out.println("a= " + a + ",b= " + b);*/
        /*int c = 1;
        int d = 2;
        System.out.println("c= " + c + ",d= " + d);
        swap(c,d);
        System.out.println("c= " + c + ",d= " + d);*/
        ClassTest classTest = new ClassTest();
        System.out.println(classTest.getClass() == ClassTest.class);

    }

    private static void swap(Integer a,Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        Integer temp = a;
        field.set(a,b);
        field.set(b,temp);
    }

    private static void swap(int a,int b){
        int c = a;
        a = b;
        b = c;
    }

    private static String transferTableNameToClassName(String tableName) {
        char[] chars = tableName.toCharArray();
        chars[0] -= 32;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '_') {
                chars[i + 1] -= 32;
            }
        }
        return new String(chars).substring(0,chars.length - 2).replace("_","").trim();
    }
}
