package Algorithm.sort;

import org.apache.tools.ant.types.resources.Sort;

/**
 * @ClassName : SortBasic
 * @Description :
 * @Author : xfakir
 * @Date : 2020/6/2 10:58
 * @Version : 1.0
 */
public class SortBasic {
    private static Comparable[] a = {};

    public static boolean less(Comparable v, Comparable w)  {
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i-1]))
                return false;
        }
        return true;
    }

    public static Comparable[] setTestCase(String array) {
        a = new Comparable[array.length()];
        for (int i = 0; i < array.length(); i++) {
            a[i] = Integer.parseInt(array.substring(i,i+1));
        }
        return a;
    }

    public static Comparable[] getResult() {
        return a;
    }


}
