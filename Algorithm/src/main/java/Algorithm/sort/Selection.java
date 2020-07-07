package Algorithm.sort;

/**
 * @ClassName : Selection
 * @Description : 选择排序
 * @Author : xfakir
 * @Date : 2020/6/2 10:30
 * @Version : 1.0
 */
public class Selection extends SortBasic{
    public static void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i+1; j < length; j++) {
                if (less(a[j],a[min])) min = j;
            }
            exchange(a,i,min);
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {1,8,5,6,7,2};
        sort(a);
        show(a);
    }
}
