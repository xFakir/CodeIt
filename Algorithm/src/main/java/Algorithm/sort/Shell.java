package Algorithm.sort;

/**
 * @ClassName : Shell
 * @Description :
 * @Author : xfakir
 * @Date : 2020/6/3 10:56
 * @Version : 1.0
 */
public class Shell extends SortBasic{
    public static void sort(Comparable[] a) {
        int length = a.length;
        int h = 1;
        while (h < length/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(a[j],a[j - h]); j -= h) {
                    exchange(a,j,j-h);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        sort(setTestCase("156852498782"));
        show(getResult());
    }
}
