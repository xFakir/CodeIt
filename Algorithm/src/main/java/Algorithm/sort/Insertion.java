package Algorithm.sort;

/**
 * @ClassName : Insertion
 * @Description :
 * @Author : xfakir
 * @Date : 2020/6/3 9:39
 * @Version : 1.0
 */
public class Insertion extends SortBasic{
    public static void sort(Comparable[] a){
        int length = a.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && less(a[j],a[j-1]) ; j--) {
                    exchange(a,j,j-1);
            }
        }
    }

    public static void main(String[] args) {
        sort(setTestCase("61578925"));
        show(getResult());
    }
}
